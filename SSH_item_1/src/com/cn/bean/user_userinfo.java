package com.cn.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import org.springframework.stereotype.Component;
@Entity
@Component
public class user_userinfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer wq_id;
	@Column(unique=true)
	private String wq_user;
	private String wq_password;
	private String wq_data;
	public user_userinfo() {
		// TODO Auto-generated constructor stub
	}
	public user_userinfo(Integer wq_id, String wq_user, String wq_password,
			String wq_data) {
		super();
		this.wq_id = wq_id;
		this.wq_user = wq_user;
		this.wq_password = wq_password;
		this.wq_data = wq_data;
	}
	public Integer getWq_id() {
		return wq_id;
	}
	public void setWq_id(Integer wq_id) {
		this.wq_id = wq_id;
	}
	public String getWq_user() {
		return wq_user;
	}
	public void setWq_user(String wq_user) {
		this.wq_user = wq_user;
	}
	public String getWq_password() {
		return wq_password;
	}
	public void setWq_password(String wq_password) {
		this.wq_password = wq_password;
	}
	public String getWq_data() {
		return wq_data;
	}
	public void setWq_data(String wq_data) {
		this.wq_data = wq_data;
	}
	@Override
	public String toString() {
		return "{\"wq_id\":\"" + wq_id + "\", \"wq_user\":\"" + wq_user + "\", \"wq_password\":\"" + wq_password
				+ "\", \"wq_data\":\"" + wq_data + "\"}\n";
	}
	
	
	

	
	
}
