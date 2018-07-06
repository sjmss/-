package com.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.DAO.Word_only_dao;
@Component
public class Word_only_imp implements Word_only_service {
	@Autowired
	private Word_only_dao wod;
	@Override
	public int alike(String word_name) {
		return wod.alike_dao(word_name);
		
	}

}
