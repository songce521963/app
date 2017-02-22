/**
 * 
 */
package com.ltkj.app.common.model;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.Page;

/**
 * @author SONGCE
 *
 */
public class PageResult implements Serializable {

	private static final long serialVersionUID = -482684880480587460L;
	
	public PageResult() {
		
	}
	
	public PageResult(List<?> rows) throws Exception {
		setRows(rows);
	}
	
	//总数
	private Long total;
	
	//数据
	private List<?> rows;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	@SuppressWarnings("unchecked")
	public void setRows(List<?> rows) throws Exception {
		this.rows = rows;
		this.total =((Page<Object>) rows).getTotal();
	}
}
