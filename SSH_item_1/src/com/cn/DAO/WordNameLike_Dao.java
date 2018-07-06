package com.cn.DAO;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface WordNameLike_Dao {
	public List<?> like_word(String word_name);
}
