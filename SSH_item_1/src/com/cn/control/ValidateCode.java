package com.cn.control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;


import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.cn.model.Str;
import com.cn.validateCade.GetValidateCode;
import com.opensymphony.xwork2.ActionSupport;
@Component("vdc")
public class ValidateCode extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	BASE64Encoder encoder=new BASE64Encoder();
	
	BASE64Decoder decoder=new BASE64Decoder();
	
	public void getValidateCode() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		GetValidateCode gv=new GetValidateCode();
		gv.createCode();
		System.out.println(gv.getCode());
		/*OutputStream os=response.getOutputStream();
		ImageIO.write(gv.getImg(), "jpg", os);
		os.close();*/
		BufferedImage img=gv.getImg();
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		ImageIO.write(img, "png", baos);
		byte[] bytes=baos.toByteArray();
		String str=encoder.encodeBuffer(bytes).trim();
		PrintWriter pw=response.getWriter();
		Str st=new Str(str, gv.getCode());
		JSONArray json=JSONArray.fromObject(st);
		pw.print(json);
	}
}
