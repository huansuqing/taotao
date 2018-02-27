package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taotao.service.ContentCategoryService;
import com.taotao.utils.E3mallResult;
import com.taotao.utils.EasyUITreeNode;

@RestController
@RequestMapping("/content/category")
public class ContentCategoryController {

	//内容查询
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/list")
	public List<EasyUITreeNode> getContentCategoryList(@RequestParam(name="id",defaultValue="0")long parentId){
		List<EasyUITreeNode> list = contentCategoryService.getContentCategoryList(parentId);
		return list;
	}
	
	//添加内容
	@RequestMapping("/create")
	public E3mallResult addContentCategory(Long parentId,String name){
		
		E3mallResult result = contentCategoryService.addContentCategory(parentId, name);
		
		return result;
	}
	
	
	
}
