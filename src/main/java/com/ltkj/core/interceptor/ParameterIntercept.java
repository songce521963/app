/**					
 * 					
 */					
package com.ltkj.core.interceptor;					
					
import java.util.Date;					
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.executor.Executor;					
import org.apache.ibatis.mapping.MappedStatement;					
import org.apache.ibatis.mapping.SqlCommandType;					
import org.apache.ibatis.plugin.Interceptor;					
import org.apache.ibatis.plugin.Intercepts;					
import org.apache.ibatis.plugin.Invocation;					
import org.apache.ibatis.plugin.Plugin;					
import org.apache.ibatis.plugin.Signature;					
					
import com.ltkj.core.CommonUtil;					
import com.ltkj.core.ReflectUnit;					
import com.ltkj.core.SessionContext;					
import com.ltkj.core.exception.BusinessException;					
					
/**					
 * @author SONGCE					
 *					
 */					
//ParameterHandler、ResultSetHandler、StatementHandler以及Executor。 					
@Intercepts(@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}))					
public class ParameterIntercept implements Interceptor {					
					
	//排他错误信息				
	private String message ="当前数据已经被修改或删除,请重新操作！";				
	//应用名				
	private String defaultOp = "system";				
	//有效		
	private String defaultActive = "1";				
					
	//主键				
	private static final String UUID = "uuid";				
	//是否可用				
	private static final String IS_ACTIVE = "isActive";				
	//创建时间				
	private static final String CREATE_DT = "createDt";				
	//创建应用				
	private static final String CREATE_OP = "createOp";				
	//创建人				
	private static final String CREATE_PG = "createPg";				
	//更新时间				
	private static final String UPDATE_DT = "updateDt";				
	//更新应用				
	private static final String UPDATE_OP = "updateOp";				
	//更新人				
	private static final String UPDATE_PG = "updatePg";				
	//版本号				
	private static final String VERSION = "version";
	
					
	@Override				
	public Object intercept(Invocation invocation) throws Throwable,BusinessException {				
			Object[] args = invocation.getArgs();		
			//获取原始的ms		
	        MappedStatement mappedStatement = (MappedStatement) args[0];				
	        SqlCommandType type = mappedStatement.getSqlCommandType();				
	        Object parameter = args[1];				
	        Date date = CommonUtil.getCurrentDate();	
	        Object obj =null;
            if(type.compareTo(SqlCommandType.INSERT) == 0){					
	        	if(ReflectUnit.checkFieldName(parameter, UUID)){
	        		obj = ReflectUnit.getFieldValue(parameter, UUID);
	        		if(obj instanceof String){
	        			if(StringUtils.isBlank((String)obj)){
	        				String uuid = CommonUtil.getUuid();	
	    	        		ReflectUnit.setFieldValue(parameter, UUID, uuid);
	        			}
	        		}
	        	}			
	        	if(ReflectUnit.checkFieldName(parameter, IS_ACTIVE)){
	        		obj = ReflectUnit.getFieldValue(parameter, IS_ACTIVE);
	        		if(obj instanceof String){
	        			if(StringUtils.isBlank((String)obj)){
	        				ReflectUnit.setFieldValue(parameter, IS_ACTIVE, defaultActive);
	        			}
	        		}
	        	}			
	        	if(ReflectUnit.checkFieldName(parameter, CREATE_DT)){
	        		obj = ReflectUnit.getFieldValue(parameter, CREATE_DT);
	        		if(obj instanceof Date){
	        			if((Date)obj!=null){
	        				ReflectUnit.setFieldValue(parameter, CREATE_DT, date);	
	        			}
	        		}
	        	}			
	        	if(ReflectUnit.checkFieldName(parameter, CREATE_OP)){	
	        		obj = ReflectUnit.getFieldValue(parameter, CREATE_OP);
	        		if(obj instanceof String){
	        			if(StringUtils.isBlank((String)obj)){
	        				ReflectUnit.setFieldValue(parameter, CREATE_OP, defaultOp);	
	        			}
	        		}
	        	}			
	        	if(ReflectUnit.checkFieldName(parameter, CREATE_PG)){	
	        		obj = ReflectUnit.getFieldValue(parameter, CREATE_PG);
	        		if(obj instanceof String){
	        			if(StringUtils.isBlank((String)obj)){
	        				ReflectUnit.setFieldValue(parameter, CREATE_PG, SessionContext.getLogInUser().getUserName());		
	        			}
	        		}
	        	}			
	        	if(ReflectUnit.checkFieldName(parameter, UPDATE_DT)){	
	        		obj = ReflectUnit.getFieldValue(parameter, UPDATE_DT);
	        		if(obj instanceof Date){
	        			if((Date)obj!=null){
	        				ReflectUnit.setFieldValue(parameter, UPDATE_DT, date);	
	        			}
	        		}
	        	}			
	        	if(ReflectUnit.checkFieldName(parameter, UPDATE_OP)){	
	        		obj = ReflectUnit.getFieldValue(parameter, UPDATE_OP);
	        		if(obj instanceof String){
	        			if(StringUtils.isBlank((String)obj)){
	        				ReflectUnit.setFieldValue(parameter, UPDATE_OP, defaultOp);		
	        			}
	        		}
	        	}			
	        	if(ReflectUnit.checkFieldName(parameter, UPDATE_PG)){			
	        		obj = ReflectUnit.getFieldValue(parameter, UPDATE_PG);
	        		if(obj instanceof String){
	        			if(StringUtils.isBlank((String)obj)){
	        				ReflectUnit.setFieldValue(parameter, UPDATE_PG, SessionContext.getLogInUser().getUserName());
	        			}
	        		}
	        	}			
	        	if(ReflectUnit.checkFieldName(parameter, VERSION)){			
	        		ReflectUnit.setFieldValue(parameter, VERSION, 1);		
	        	}			
	        }else if(type.compareTo(SqlCommandType.UPDATE) == 0){				
	        	if(ReflectUnit.checkFieldName(parameter, UPDATE_DT)){
	        		obj = ReflectUnit.getFieldValue(parameter, UPDATE_DT);
	        		if(obj instanceof Date){
	        			if((Date)obj!=null){
	        				ReflectUnit.setFieldValue(parameter, UPDATE_DT, date);	
	        			}
	        		}
	        	}			
	        	if(ReflectUnit.checkFieldName(parameter, UPDATE_OP)){		
	        		obj = ReflectUnit.getFieldValue(parameter, UPDATE_OP);
	        		if(obj instanceof String){
	        			if(StringUtils.isBlank((String)obj)){
	        				ReflectUnit.setFieldValue(parameter, UPDATE_OP, defaultOp);		
	        			}
	        		}
	        		
	        	}			
	        	if(ReflectUnit.checkFieldName(parameter, UPDATE_PG)){			
	        		obj = ReflectUnit.getFieldValue(parameter, UPDATE_PG);
	        		if(obj instanceof String){
	        			if(StringUtils.isBlank((String)obj)){
	        				ReflectUnit.setFieldValue(parameter, UPDATE_PG, SessionContext.getLogInUser().getUserName());		
	        			}
	        		}
	        	}			
	        	if(ReflectUnit.checkFieldName(parameter, VERSION)){			
	        		Integer version = (Integer) ReflectUnit.getFieldValue(parameter,VERSION);		
	        		if(version!=null){		
    	        		version++;		
    	        		ReflectUnit.setFieldValue(parameter, VERSION, version);		
    	        		Integer count = (Integer) invocation.proceed();		
	        			if(count!=1){	
	        				throw new BusinessException(message);
	        			}	
	        		}		
	        	}			
	        }				
            return invocation.proceed();					
	}				
					
	@Override				
	public Object plugin(Object target) {				
		if (target instanceof Executor) {			
            return Plugin.wrap(target, this);					
        } else {					
            return target;					
        }					
	}				
					
	@Override				
	public void setProperties(Properties properties) {				
	}				
					
	public String getMessage() {				
		return message;			
	}				
					
	public void setMessage(String message) {				
		this.message = message;			
	}				
					
	public String getDefaultOp() {				
		return defaultOp;			
	}				
					
	public void setDefaultOp(String defaultOp) {				
		this.defaultOp = defaultOp;			
	}				
					
}					
