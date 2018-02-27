package com.taotao.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.utils.FastDFSClient;
import com.taotao.utils.JsonUtils;

@RestController
public class PictureController {

	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	
	
	//图片上传
	@RequestMapping("/pic/upload")
	public String fileUpload(MultipartFile uploadFile) throws Exception{
		
		try {
			//获取文件的文件名
			String filename = uploadFile.getOriginalFilename();
			
			//获取文件类型
			String extName = filename.substring(filename.lastIndexOf(".")+1);
			
			//创建上传的客户端对象
			FastDFSClient client = new FastDFSClient("classpath:resource/client.conf");
			
			//利用客户端进行文件上传 获取到的是服务器中的位置   不包含ip地址
			String string = client.uploadFile(uploadFile.getBytes(), extName);
			
			//将地址进行拼接返回给前台页面
			String url = IMAGE_SERVER_URL+string;
			
			//创建集合
			HashMap<String, Object> map = new HashMap<>();
			
			map.put("error", 0);
			
			map.put("url", url);
			
			//将对象转换成json对象
			String json = JsonUtils.objectToJson(map);
			
			//将json对象进行返回
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			//创建集合
			HashMap<String, Object> map = new HashMap<>();
			
			map.put("error", 1);
			
			map.put("message", "图片上传失败");
			
			//将对象转换成json对象
			String json = JsonUtils.objectToJson(map);
			
			//将json对象进行返回
			return json;
		}
		
	}
	
	
}
