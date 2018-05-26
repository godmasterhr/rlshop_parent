package cn.rlshop.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.rlshop.model.Item;
import cn.rlshop.model.ItemPage;
import cn.rlshop.service.ItemListService;




@Controller
public class ItemListController {
	
	@Autowired
	private ItemListService itemListService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	@RequestMapping("/toItemList")
	public String toItemList(HttpServletRequest request,Model model) throws Exception{
		int page = Integer.parseInt(request.getParameter("page"));
		String type = request.getParameter("type");
		PageHelper.startPage(page, 30);  //myatis分页插件   limit (page-1)*30+1,30
		List<Item> itemList = itemListService.findItemList(type);
		PageInfo<Item> pageInfo = new PageInfo<Item>(itemList);//page 包含分页所有信息  当前页  所有记录数   总页数 等
		model.addAttribute("page", pageInfo);
		model.addAttribute("type", type);
		return "itemList";
	}
	
	
	 /**
     * 通过关键字搜索
     * 
     * @param keyWords
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/toSearch")
    public String search(String key, Integer page, Integer rows,Model model) throws Exception {
         List<Item> itemList = itemListService.search(key, page, rows);
         model.addAttribute("item", itemList);
         model.addAttribute("key", key);
         return "search";
    }
	

}
