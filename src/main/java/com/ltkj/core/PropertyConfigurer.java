/**
 * 
 */
package com.ltkj.core;

import java.text.MessageFormat;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 读取properties文件
 * @author SONGCE
 *
 */
public class PropertyConfigurer extends PropertyPlaceholderConfigurer{

	private static Properties properties;
	
    @Override 
    protected void processProperties( 
            ConfigurableListableBeanFactory beanFactoryToProcess, 
            Properties props) throws BeansException { 
        super.processProperties(beanFactoryToProcess, props); 
        properties = new Properties(); 
        for (Object key : props.keySet()) { 
            String keyStr = key.toString(); 
            String value = props.getProperty(keyStr); 
            properties.put(keyStr, value); 
        }
    }

	public static String getMessage(String message,Object ... arguments) {
		message = properties.getProperty(message);
		return MessageFormat.format(message,arguments); 
	}

}
