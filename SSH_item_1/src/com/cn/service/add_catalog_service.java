package com.cn.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cn.bean.Word_Catalogue_Context;
@Component
public interface add_catalog_service {
	public void add_catalog_se(String word_name,List<Word_Catalogue_Context> li);
}
