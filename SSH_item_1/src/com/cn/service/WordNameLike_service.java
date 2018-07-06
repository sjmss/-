package com.cn.service;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public interface WordNameLike_service {
	public List<?> like_word(String word_name);
}
