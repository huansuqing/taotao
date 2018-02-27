package com.taotao.utils;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable{
	
	
	private long total;
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long l) {
		this.total = l;
	}
	private List<?> rows;
	
	
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	

	
	
}
