package com.cn.validateCade;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

public class GetValidateCode {
	private int width=160;
	private int height=40;
	private int codeCount=5;
	private int lineCount=100;
	private String code="";
	private BufferedImage img;
	private char[] cha={'q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','z','x','c','v','b','n','M','Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M','2','3','4','5','6','7','8','9','0'};
	public GetValidateCode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GetValidateCode(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	public GetValidateCode(int width, int height, int codeCount, int lineCount) {
		super();
		this.width = width;
		this.height = height;
		this.codeCount = codeCount;
		this.lineCount = lineCount;
	}
	
	public void createCode(){
		int red,green,blue;
		img=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g=img.createGraphics();
		Random random=new Random();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		Font font=new Font("Microsoft YaHei", Font.PLAIN, height-4);
		g.setFont(font);
		
		for(int i=0;i<lineCount;i++){
			int sx=random.nextInt(width);
			int sy=random.nextInt(height);
			int ex=sx+random.nextInt(width);
			int ey=sy+random.nextInt(height);
			
			red=random.nextInt(255);
			green=random.nextInt(255);
			blue=random.nextInt(255);
			g.setColor(new Color(173,173,173));
	
			g.drawLine(sx, sy, ex, ey);
			
		}
		
		for(int j=0;j<codeCount;j++){
			String str_cha=String.valueOf(cha[random.nextInt(cha.length)]);
			System.out.println(str_cha);
			red=random.nextInt(255);
			green=random.nextInt(255);
			blue=random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,0.5f));
			g.drawString(str_cha,(width/8)*(j+2),height-5);
			code+=str_cha;
		}
		
	}
	
	public void write(String path) throws IOException{
		OutputStream os=new FileOutputStream(path);
		ImageIO.write(img, "png", os);
	}
	
	public static void main(String[] args) throws IOException {
		GetValidateCode vl=new GetValidateCode();
		vl.createCode();
		String path="C:/Users/Administrator/Desktop/"+new Date().getTime()+".png";
		System.out.println(vl.code+">"+path);
		vl.write(path);
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getCodeCount() {
		return codeCount;
	}
	public void setCodeCount(int codeCount) {
		this.codeCount = codeCount;
	}
	public int getLineCount() {
		return lineCount;
	}
	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	public char[] getCha() {
		return cha;
	}
	public void setCha(char[] cha) {
		this.cha = cha;
	}
	
	
}
