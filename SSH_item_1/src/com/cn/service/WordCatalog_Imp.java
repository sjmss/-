package com.cn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.DAO.WordCatalog_Dao;
import com.cn.bean.Word_info;

@Component
public class WordCatalog_Imp implements WordCatalog_service {
	@Autowired
	private WordCatalog_Dao wcld;
	@Override
	public Word_info get_word_info(String word_name) {
		
			return wcld.wordinfo(word_name);
	
	}

	@Override
	public List<?> get_catalog_info(int word_id) {
		// TODO Auto-generated method stub
		return wcld.catalog_info(word_id);
	}

}
