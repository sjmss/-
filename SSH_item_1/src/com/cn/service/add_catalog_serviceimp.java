package com.cn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.DAO.add_catalog_DAO;
import com.cn.bean.Word_Catalogue_Context;
import com.cn.bean.Word_info;
@Component
public class add_catalog_serviceimp implements add_catalog_service {
	@Autowired
	private add_catalog_DAO acd;
	@Override
	public void add_catalog_se(String word_name,List<Word_Catalogue_Context> li) {
		Word_info wi=acd.look_ID(word_name);
		acd.add_catalog(wi, li);
		
		
	}
	
}
