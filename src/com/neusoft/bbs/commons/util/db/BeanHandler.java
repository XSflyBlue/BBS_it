package com.neusoft.bbs.commons.util.db;

import java.sql.ResultSet;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSetMetaData;

import com.neusoft.bbs.commons.util.StringUtils;

/**
* 将结果集转换成bean对象的处理器
*
*/ 
public class BeanHandler implements ResultSetHandler {
    private Class<?> clazz;
    public BeanHandler(Class<?> clazz){
        this.clazz = clazz;
    }
    public Object handler(ResultSet rs) {
        try{
            if(!rs.next()){
                return null;
            }
            Object bean = clazz.newInstance();
            //得到结果集元数据
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();//得到结果集中有几列数据
            for(int i=0;i<columnCount;i++){
                String coulmnName = metadata.getColumnName(i+1);//得到每列的列名
                coulmnName = StringUtils.dbFieldToJava(coulmnName);
                Object coulmnData = rs.getObject(i+1);
                Field f = clazz.getDeclaredField(coulmnName);//反射出类上列名对应的属性
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
                    	}
                    }else {
                    	f.set(bean, coulmnData);
                    }
                }
            }
            return bean;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
