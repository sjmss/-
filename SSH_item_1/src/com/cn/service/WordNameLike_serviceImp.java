package com.cn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.DAO.WordNameLike_Dao;
import com.cn.annotation.AdviceInfomation;
@Component
public class WordNameLike_serviceImp implements WordNameLike_service {
	@Autowired
	private WordNameLike_Dao wnld;
	@AdviceInfomation(context="≤È—Øµ•¥ ")
	@Override
	public List<?> like_word(String word_name) {
		return wnld.like_word(word_name);
	}

}
