package com.cn.validateCade;

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

public class ValidateCode {
	private int width=160;
	private int height=40;
	private int codeCount=5;
	private int lineCount=140;
	private String code=null;
	private BufferedImage img;
	private char[] cha={'q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','z','x','c','v','b','n','M','Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M','2','3','4','5','6','7','8','9','0'};
	public ValidateCode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ValidateCode(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	public ValidateCode(int width, int height, int codeCount, int lineCount) {
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
			
			red=random.nextInt(255);
			green=random.nextInt(255);
			blue=random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.drawLine(sx, sy, sx+2, sy+2);
			
		}
		
		for(int j=0;j<codeCount;j++){
			String str_cha=String.valueOf(cha[random.nextInt(cha.length)]);
			System.out.println(str_cha);
			red=random.nextInt(255);
			green=random.nextInt(255);
			blue=random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.drawString(str_cha,(width/9)*(j+2),height-8);
		}
	}
	
	public void write(String path) throws IOException{
		OutputStream os=new FileOutputStream(path);
		ImageIO.write(img, "png", os);
	}
	
	public static void main(String[] args) throws IOException {
		ValidateCode vl=new ValidateCode();
		vl.createCode();
		String path="C:/Users/Administrator/Desktop/"+new Date().getTime()+".png";
		System.out.println(vl.code+">"+path);
		vl.write(path);
	}
}
