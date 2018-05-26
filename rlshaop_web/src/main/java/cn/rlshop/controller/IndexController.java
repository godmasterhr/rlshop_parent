package cn.rlshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.rlshop.model.Item;
import cn.rlshop.service.ItemListService;

@Controller
public class IndexController {
	
	@Autowired
	private ItemListService itemListService;
	
	@RequestMapping("/index")
	public String  toIndex(){
		return "index";
	}

}
