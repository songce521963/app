/**
 * 
 */
package com.ltkj.core.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.ltkj.core.ReflectUnit;

/**
 * @author SONGCE
 *
 */
//ParameterHandler、ResultSetHandler、StatementHandler以及Executor。 
@Intercepts({
		@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})
})
public class MybatisInterceptor implements Interceptor {
	//版本号
	private static final String VERSION = "version";
		
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		 StatementHandler statementHandler = (StatementHandler) invocation.getTarget();  
         MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);  
         MappedStatement mappedStatement=(MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
		 SqlCommandType type = mappedStatement.getSqlCommandType();
		 ParameterHandler paramerHandler = (ParameterHandler) metaStatementHandler.getValue("delegate.parameterHandler"); 
		 Object parameter = paramerHandler.getParameterObject();
		 BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");  
		 if(type.compareTo(SqlCommandType.UPDATE) == 0){
        	if(ReflectUnit.checkFieldName(parameter,VERSION)){
        		Integer version = (Integer) ReflectUnit.getFieldValue(parameter, VERSION);
        		if(version!=null){
        			// 重写sql 
	        		String versionSql = concatVersionSql(boundSql.getSql(), String.valueOf(version-1));
	        		metaStatementHandler.setValue("delegate.boundSql.sql", versionSql); 
        		}
        	}
	     }
		return invocation.proceed();
	}

	/**
	 * @param sql
	 * @return
	 */
	private String concatVersionSql(String sql,String version) {
		StringBuffer sb=new StringBuffer();
        sb.append(sql);
        sb.append(" AND "+VERSION+" = "+version);
        return sb.toString();
	}

	@Override
	public Object plugin(Object target) {
		if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
	}

	@Override
	public void setProperties(Properties properties) {
	}
}
