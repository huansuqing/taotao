package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemService;
import com.taotao.utils.E3mallResult;
import com.taotao.utils.PageResult;

@RestController
public class ItemController {
	
	
	@Autowired
	private ItemService itemService;
	
	//按照id进行查询
	@RequestMapping("/item/{itemId}")
	public TbItem getItemById(@PathVariable Long itemId){
		TbItem item = itemService.getItemById(itemId);
		return item;
				 
	}
	
	//分页查询  传参取值
	@RequestMapping("/item/list")
	public PageResult getItemsByPage(Integer page, Integer rows){
		PageResult result = itemService.getItemsByPage(page, rows);
		return result;
	}
	
	//添加商品的方法
	@RequestMapping("/item/save")
	public E3mallResult addItem(TbItem item,TbItemDesc itemDesc){
		
		//调用service层进行方法的调用
		E3mallResult result = itemService.addItem(item, itemDesc);
		
		return result;
	}

}
