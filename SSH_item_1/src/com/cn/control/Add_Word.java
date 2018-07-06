package com.cn.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.model.Word;
import com.cn.service.Word_addservice;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component("addw")
public class Add_Word extends ActionSupport implements ModelDriven<Word>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private Word_addservice ws;
	@Autowired
	private Word w;
	public void add(){
		System.out.println(w.getW_ChName());
		System.out.println(w.getW_Company());
		System.out.println(w.getW_Context());
		System.out.println(w.getW_EnName());
		
		ws.add_Word(w);
	}

	@Override
	public Word getModel() {
		// TODO Auto-generated method stub
		return w;
	}
	
	
	public Word getW() {
		return w;
	}

	public void setW(Word w) {
		this.w = w;
	}

	
}
