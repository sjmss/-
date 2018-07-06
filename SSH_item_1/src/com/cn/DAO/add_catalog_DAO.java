package com.cn.DAO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cn.bean.Word_Catalogue_Context;
import com.cn.bean.Word_info;
@Component
public interface add_catalog_DAO {
	public Word_info look_ID(String word_name);
	public void add_catalog(Word_info word_id,List<Word_Catalogue_Context> li);
}
