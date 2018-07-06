package com.cn.DAO;

import java.util.List;

import org.springframework.stereotype.Component;


import com.cn.bean.Word_info;

@Component
public interface WordCatalog_Dao {
	public Word_info wordinfo(String word_name);
	public List<?> catalog_info(int word_id);
}
