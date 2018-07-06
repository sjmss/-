package com.cn.captcha;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
@SuppressWarnings("unused")
public class CaptchaCode {
	
	private int windth;
	private int height;
	private int number;
	private int linecount;
	private BufferedImage img=null;
	
	public CaptchaCode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	public CaptchaCode(int windth, int height) {
		super();
		this.windth = windth;
		this.height = height;
	}


	public CaptchaCode(int windth, int height, int number, int linecount,
			BufferedImage img) {
		super();
		this.windth = windth;
		this.height = height;
		this.number = number;
		this.linecount = linecount;
		this.img = img;
	}
	
	@SuppressWarnings("static-access")
	public void createCode(){
		img=new BufferedImage(400, 50, img.TYPE_INT_RGB);
		Graphics2D g=img.createGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, 160, height);
		
	}
	
	
}
