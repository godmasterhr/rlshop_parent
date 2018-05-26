package cn.rlshop.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 采用输入输出流将本地的图片显示在jsp页面中
 * @author 何睿
 *
 */
@Controller
public class ImageController {
	@RequestMapping("getImage")
	public void getImage(HttpServletRequest request,  
            HttpServletResponse response, Model model){
			String itemUrl = request.getParameter("itemUrl");
			itemUrl = itemUrl.replace(" ", "").replace("'", "");
			FileInputStream fis = null;  
	        OutputStream os = null;  
	        try {  
	            fis = new FileInputStream(itemUrl);  
	            os = response.getOutputStream();  
	            int count = 0;  
	            byte[] buffer = new byte[1024 * 8];  
	            while ((count = fis.read(buffer)) != -1) {  
	                os.write(buffer, 0, count);  
	                os.flush();  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally{
	        	  try {
					fis.close();
					os.close();  
				} catch (IOException e) {
					e.printStackTrace();
				}  
	        }
	      
	}


}