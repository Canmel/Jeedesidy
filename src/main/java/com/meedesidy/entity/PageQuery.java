package com.meedesidy.entity;

import java.util.List;

public class PageQuery {

	public int total;// 总记录数
	public List result; // 结果集

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getResult() {
		return result;
	}
	public void setResult(List result) {
		this.result = result;
	}

}
