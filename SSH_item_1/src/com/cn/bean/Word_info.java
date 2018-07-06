package com.cn.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import org.springframework.stereotype.Component;
@Entity
@Component
public class Word_info {
	//词条id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer w_id;
	//词条英文名
	@Column(unique=true)
	private String w_EnName;
	//词条中文别名
	private String w_ChName;
	//所属公司
	private String w_Company;
	//基本信息
	private String w_Context;
	
	
	public Word_info() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Word_info(String w_EnName, String w_ChName, String w_Company,
			String w_Context, Integer w_CatalogueID) {
		super();
		this.w_EnName = w_EnName;
		this.w_ChName = w_ChName;
		this.w_Company = w_Company;
		this.w_Context = w_Context;
	
	}

	public Integer getW_id() {
		return w_id;
	}
	public void setW_id(Integer w_id) {
		this.w_id = w_id;
	}
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
	
	
	@Override
	public String toString() {
		return "Word_info [w_id=" + w_id + ", w_EnName=" + w_EnName
				+ ", w_ChName=" + w_ChName + ", w_Company=" + w_Company
				+ ", w_Context=" + w_Context + "]";
	}
	
	
	
}
