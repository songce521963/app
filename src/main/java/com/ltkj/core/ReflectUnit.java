/**
 * 
 */
package com.ltkj.core;

import java.lang.reflect.Field;

import org.apache.commons.lang3.reflect.FieldUtils;

/**
 * @author SONGCE
 *
 */
public class ReflectUnit {
	
	/**
	 * 反射设定私有变量
	 * @param Object 目标对象
	 * @param string 文件名称
	 * @param Object 设置值
	 */
	public static void setFieldValue(Object obj , String fieldName , Object value) {
		if(null == obj){return;}  
        Field targetField = getTargetField(obj.getClass(), fieldName);    
        try {  
             FieldUtils.writeField(targetField, obj, value) ;  
        } catch (IllegalAccessException e) {  
            e.printStackTrace();  
        }   
	}
	
	public static Field getTargetField(Class<?> targetClass, String fieldName) {  
        Field field = null;  
  
        try {  
            if (targetClass == null) {  
                return field;  
            }  
  
            if (Object.class.equals(targetClass)) {  
                return field;  
            }  
  
            field = FieldUtils.getDeclaredField(targetClass, fieldName, true);  
            if (field == null) {  
                field = getTargetField(targetClass.getSuperclass(), fieldName);  
            }  
        } catch (Exception e) {  
        }  
  
        return field;  
    }  
	
	/**
	 * 反射获取私有变量
	 * @param Object 目标对象
	 * @param string 文件名称
	 */
	public static Object getFieldValue(Object obj , String fieldName ){  
        
        if(obj == null){  
            return null ;  
        }  
          
        Field targetField = getTargetField(obj.getClass(), fieldName);  
          
        try {  
            return FieldUtils.readField(targetField, obj, true ) ;  
        } catch (IllegalAccessException e) {  
            e.printStackTrace();  
            return null;
        }   
    }  
	
	/**
	 * 判断反射类是否有私有变量
	 * @param Object 目标对象
	 * @param string 文件名称
	 */
	public static boolean checkFieldName(Object obj , String fieldName){
		if(obj == null){  
            return false;  
        }  
        Field targetField = getTargetField(obj.getClass(), fieldName); 
        if(targetField== null){
        	return false;  
        }else{
        	return true;  
        }
	}
}
