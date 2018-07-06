package com.cn.control;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cn.bean.Word_Catalogue_Context;
import com.cn.service.add_catalog_service;
import com.opensymphony.xwork2.ActionSupport;


@Component("addr")
public class Add_Catalog extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String word_name;
	private List<Word_Catalogue_Context> li1=new ArrayList<Word_Catalogue_Context>();
	@Autowired
	private add_catalog_service acs;
	public void add_rank(){
		System.out.println("请求接受addr");
		System.out.println("单词名:"+word_name);
		System.out.println(li1.size());
		System.out.println(li1);
		acs.add_catalog_se(word_name, li1);
	}

	//getset方法，获取值，和名字
	public String getWord_name() {
		return word_name;
	}

	public void setWord_name(String word_name) {
		this.word_name = word_name;
	}
	public List<Word_Catalogue_Context> getLi1() {
		return li1;
	}

	public void setLi1(List<Word_Catalogue_Context> li1) {
		this.li1 = li1;
	}


	
	
	
	
	





}
