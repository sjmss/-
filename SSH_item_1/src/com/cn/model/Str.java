package com.cn.model;

public class Str {
	private String src;
	private String code;
	
	public Str() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Str(String src, String code) {
		super();
		this.src = src;
		this.code = code;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Str [src=" + src + ", code=" + code + "]";
	}
	
}
