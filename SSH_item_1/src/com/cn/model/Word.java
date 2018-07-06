package com.cn.model;

import org.springframework.stereotype.Component;

@Component
public class Word {
	private String w_EnName;
	private String w_ChName;
	private String w_Company;
	private String w_Context;
	public String getW_EnName() {
		return w_EnName;
	}
	public void setW_EnName(String w_EnName) {
		this.w_EnName = w_EnName;
	}
	public String getW_ChName() {
		return w_ChName;
	}
	public void setW_ChName(String w_ChName) {
		this.w_ChName = w_ChName;
	}
	public String getW_Company() {
		return w_Company;
	}
	public void setW_Company(String w_Company) {
		this.w_Company = w_Company;
	}
	public String getW_Context() {
		return w_Context;
	}
	public void setW_Context(String w_Context) {
		this.w_Context = w_Context;
	}
}
