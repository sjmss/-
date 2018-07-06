package com.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.DAO.Word_addDAO;
import com.cn.model.Word;

@Component
public class Word_addimp implements Word_addservice {
	@Autowired
	private Word_addDAO wa_dao;
	@Override
	public void add_Word(Word w) {
		wa_dao.add(w);
	}


}
