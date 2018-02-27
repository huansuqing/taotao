package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;
import com.taotao.utils.E3mallResult;
import com.taotao.utils.PageResult;

@RestController
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	//内容列表查询
	@RequestMapping("/content/query/list")
	public PageResult getContentByPage(Long categoryId,
			@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="10")Integer rows){
		
		PageResult result = contentService.getContentByPage(categoryId, page, rows);
		
		return result;
	}
	
	
	//添加广告
	@RequestMapping("/content/save")
	public E3mallResult saveContent(TbContent content){
		
		E3mallResult result = contentService.addContent(content);
		
		return result;
		
	}
	

}
