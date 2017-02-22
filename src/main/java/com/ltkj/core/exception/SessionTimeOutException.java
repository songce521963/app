/**
 * 
 */
package com.ltkj.core.exception;

import org.springframework.security.access.AccessDeniedException;

/**
 * @author SONGCE
 *
 */
public class SessionTimeOutException extends AccessDeniedException {

	private static final long serialVersionUID = 6436631424293298702L;

	/**
	 * @param msg
	 */
	public SessionTimeOutException(String msg) {
		super(msg);
	}

}
