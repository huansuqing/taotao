package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.service.ItemCatService;
import com.taotao.utils.EasyUITreeNode;

@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	//查询目录的方法
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(@RequestParam(name="id",defaultValue="0")Long parentId){
		List<EasyUITreeNode> list = itemCatService.getCatList(parentId);
		
		return list;
		
	}
	
	
}
