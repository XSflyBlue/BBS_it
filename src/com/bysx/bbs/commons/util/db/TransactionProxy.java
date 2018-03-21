package com.bysx.bbs.commons.util.db;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

import com.bysx.bbs.commons.config.TransMethodConfig;

public class TransactionProxy implements InvocationHandler {
    private Object obj = null;

    // obj:需要代理的类
    public Object newProxyInstance(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(this.obj.getClass().getClassLoader(),
                this.obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // 用于接收参数
        Object param = null;
        Connection conn = JdbcUtil_DBCP.getConnection();
        // 如果是以下方法开头,则代理事务
        if (TransMethodConfig.isTransMethod(method.getName())) {//事务方法
            try {
                // 手动提交事务
            	JdbcUtil_DBCP.benigTransction(conn);
                param = method.invoke(obj, args);
                // 提交事务
                JdbcUtil_DBCP.endTransction(conn);
            } catch (Exception e) {
                // 回滚事务
            	JdbcUtil_DBCP.rollback(conn);
                if (e instanceof InvocationTargetException) {
                    InvocationTargetException inv = (InvocationTargetException) e;
                    throw inv.getTargetException();
                } else {
                    throw new Exception("操作失败!");
                }
            } finally {
            	JdbcUtil_DBCP.recoverTransction(conn);
            	JdbcUtil_DBCP.close(conn);
            }
        }else {//非事务方法
        	try {
                param = method.invoke(obj, args);
            } catch (Exception e) {
               e.printStackTrace();
            } finally {
            	JdbcUtil_DBCP.close(conn);
            }
        }
        return param;
    }
}