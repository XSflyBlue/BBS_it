﻿package com.bysx.bbs.commons.util.db;

import java.sql.ResultSet;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.bysx.bbs.commons.util.StringUtils;

/**
*将结果集转换成bean对象的list集合的处理器
*
*/ 
public class BeanListHandler implements ResultSetHandler {
    private Class<?> clazz;
    public BeanListHandler(Class<?> clazz){
        this.clazz = clazz;
    }
    
    public Object handler(ResultSet rs) {
        try{
            List<Object> list = new ArrayList<Object>();
            while(rs.next()){
                Object bean = clazz.newInstance();
                
                ResultSetMetaData  metadata = rs.getMetaData();
                int count = metadata.getColumnCount();
                for(int i=0;i<count;i++){
                    String name = metadata.getColumnName(i+1);
                    Object coulmnData = rs.getObject(name);
                    name = StringUtils.dbFieldToJava(name);
                    Field f = bean.getClass().getDeclaredField(name);
                    f.setAccessible(true);
                    if(coulmnData != null) {
                    	if(coulmnData.getClass() == BigDecimal.class) {
                        	BigDecimal bgDecimal = (BigDecimal) coulmnData;
                        	if(f.getType()==Long.class) {
                        		 f.set(bean, bgDecimal.longValue());
                        	}else if(f.getType()==Integer.class) {
                        		 f.set(bean, bgDecimal.intValue());
                        	}else if(f.getType()==Double.class) {
                        		 f.set(bean, bgDecimal.doubleValue());
                        	}else if(f.getType()==Short.class) {
                        		f.set(bean, bgDecimal.shortValue());
                        	}
                        }else if(coulmnData.getClass()==oracle.sql.CLOB.class) {
                        	f.set(bean, OracleTypeUtil.ClobToString((java.sql.Clob)coulmnData));
                    	}else {
                        	f.set(bean, coulmnData);
                        }
                    }
                }
                list.add(bean);
            }
            return list.size()>0?list:null;
        
        }catch (Exception e) {
        	e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}