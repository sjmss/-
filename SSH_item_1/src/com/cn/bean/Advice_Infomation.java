package com.cn.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Advice_Infomation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int log_id;
	private String log_name;
	private String log_ip;
	private String log_time;
	private String log_context;
	private double log_req_Time;
	public double getLog_req_Time() {
		return log_req_Time;
	}
	public void setLog_req_Time(double log_req_Time) {
		this.log_req_Time = log_req_Time;
	}
	private int log_state;
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public String getLog_name() {
		return log_name;
	}
	public void setLog_name(String log_name) {
		this.log_name = log_name;
	}
	public String getLog_time() {
		return log_time;
	}
	public void setLog_time(String log_time) {
		this.log_time = log_time;
	}
	public String getLog_context() {
		return log_context;
	}
	public void setLog_context(String log_context) {
		this.log_context = log_context;
	}
	public int getLog_state() {
		return log_state;
	}
	public void setLog_state(int log_state) {
		this.log_state = log_state;
	}
	public String getLog_ip() {
		return log_ip;
	}
	public void setLog_ip(String log_ip) {
		this.log_ip = log_ip;
	}

	public Advice_Infomation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Advice_Infomation(int log_id, String log_name, String log_ip, String log_time, String log_context,
			double log_req_Time, int log_state) {
		super();
		this.log_id = log_id;
		this.log_name = log_name;
		this.log_ip = log_ip;
		this.log_time = log_time;
		this.log_context = log_context;
		this.log_req_Time = log_req_Time;
		this.log_state = log_state;
	}
	@Override
	public String toString() {
		return "{\"log_id\":\"" + log_id + "\", \"log_name\":\"" + log_name + "\", \"log_ip\":\"" + log_ip
				+ "\", \"log_time\":\"" + log_time + "\", \"log_context\":\"" + log_context + "\", \"log_req_Time\":\""
				+ log_req_Time + "\"}\n";
	}
	
	
}
