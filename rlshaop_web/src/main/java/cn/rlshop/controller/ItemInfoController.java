package cn.rlshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.rlshop.model.Item;
import cn.rlshop.service.ItemInfoService;


/**
 * 商品的详细信息的Controller
 * @author Administrator
 *
 */

@Controller
public class ItemInfoController {
	@Autowired
	private ItemInfoService itemInfoService;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@RequestMapping("/toItemInfo")
	public String toItemInfo(String id,Model model){
		logger.info("进入了商品详情页面，查看的商品id为"+id);
		Item item = itemInfoService.findItemById(id);
		model.addAttribute("item", item);
		return "itemInfo";
	}
}
