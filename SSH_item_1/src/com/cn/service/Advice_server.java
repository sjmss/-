package com.cn.service;


import org.springframework.stereotype.Component;

import com.cn.bean.Advice_Infomation;

@Component
public interface Advice_server {
	public void add(Advice_Infomation ai);
}
