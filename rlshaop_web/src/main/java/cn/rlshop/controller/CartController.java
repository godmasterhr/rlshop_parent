package cn.rlshop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.rlshop.model.Item;
import cn.rlshop.service.ItemInfoService;


@Controller
public class CartController {
	
	@Autowired
	private ItemInfoService itemInfoService;
	
	/**
	 * 购物车业务
	 * @param request
	 * @param itemId 商品的id
	 * @param num  购买的商品数目
	 * @return
	 */
	@RequestMapping("/toCart")
	public String toCart(HttpServletRequest request,String itemId,Integer num){
		Item item = itemInfoService.findItemById(itemId);
		Map<Item,Integer> cart = (Map<Item, Integer>) request.getSession(true).getAttribute("cart");
		if(cart!=null){
			if(cart.containsKey(item)){
				cart.put(item, cart.get(item)+1);
				itemInfoService.updateNum(item.getId(),1);
			}else{
				cart.put(item, num);
				itemInfoService.updateNum(item.getId(),num);
			}
		}else{
			cart = new HashMap<Item,Integer>();
			cart.put(item, num);
			itemInfoService.updateNum(item.getId(),num);
		}
		request.getSession().setAttribute("cart", cart);
		return "redirect:/cart";
	}
	/**
	 * 转向购物车页面
	 * @return
	 */
	@RequestMapping("/cart")
	public String cart(){
		return "cart";
	}
	
	/**
	 * 购物车页面||详情页面修改数量
	 */
	@RequestMapping("/cartNum")
	public String cartNum(HttpServletRequest request,String itemId,Integer num){
		Item item = new Item();
		item.setId(itemId);
		Map<Item,Integer> cart = (Map<Item, Integer>) request.getSession(true).getAttribute("cart");
		cart.put(item, num);
		request.getSession().setAttribute("cart", cart);
		return "cart";
	}
	/**
	 * 删除购物车中的商品
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/delCart")
	public String delCart(HttpServletRequest request,String itemId){
		Item item = new Item();
		item.setId(itemId);
		Map<Item,Integer> cart = (Map<Item, Integer>) request.getSession(true).getAttribute("cart");
		cart.remove(item);
		request.getSession().setAttribute("cart", cart);
		return "cart";
	}
	
	
}
