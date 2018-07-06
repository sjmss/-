package com.cn.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cn.bean.Word_info;

@Component
public interface WordCatalog_service {
	public Word_info get_word_info(String word_name);
	
	public List<?> get_catalog_info(int word_id);
}
