package com.cn.bean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
	public class Word_Catalogue_Context {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//目录id
	private Integer C_id;
	//本级目录名
	private String C_rank1;
	//本级目录为最后一级目录时的，目录信息
	@Column(length=500)
	private String C_context;
	//本目录下的其他目录
	private String C_rank2;
	//关联词条的目录id
	@ManyToOne(cascade={CascadeType.ALL})
	private Word_info w_CatalogueID;
	public Integer getC_id() {
		return C_id;
	}
	public void setC_id(Integer c_id) {
		C_id = c_id;
	}
	public String getC_rank1() {
		return C_rank1;
	}
	public void setC_rank1(String c_rank1) {
		C_rank1 = c_rank1;
	}
	public String getC_context() {
		return C_context;
	}
	public void setC_context(String c_context) {
		C_context = c_context;
	}
	public String getC_rank2() {
		return C_rank2;
	}
	public void setC_rank2(String c_rank2) {
		C_rank2 = c_rank2;
	}
	
	public Word_info getW_CatalogueID() {
		return w_CatalogueID;
	}
	public void setW_CatalogueID(Word_info w_CatalogueID) {
		this.w_CatalogueID = w_CatalogueID;
	}
	public Word_Catalogue_Context(String c_rank1, String c_context,
			String c_rank2, Integer c_grade, Word_info w_CatalogueID) {
		super();
		C_rank1 = c_rank1;
		C_context = c_context;
		C_rank2 = c_rank2;
		
		this.w_CatalogueID = w_CatalogueID;
	}
	public Word_Catalogue_Context() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Word_Catalogue_Context [C_id=" + C_id + ", C_rank1=" + C_rank1
				+ ", C_context=" + C_context + ", C_rank2=" + C_rank2
				+ "]";
	}
	
	
}
