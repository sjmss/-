package com.cn.DAO;

import org.springframework.stereotype.Component;

import com.cn.model.Word;
@Component
public interface Word_addDAO {
	public void add(Word w);
	public void seID();
}
