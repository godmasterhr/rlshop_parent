package cn.rlshop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.rlshop.model.Item;
import cn.rlshop.model.OrderInfo;
import cn.rlshop.model.Orders;
import cn.rlshop.model.User;
import cn.rlshop.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/addOrder")
	public String addOrder(HttpServletRequest request,Model model){
		Map<Item,Integer> cart= (Map<Item, Integer>) request.getSession().getAttribute("cart");
		User user = (User) request.getSession().getAttribute("user");
		if(cart!=null){
			orderService.addOrders(cart,user);
			//添加完订单 清除购物车的信息
			request.getSession().removeAttribute("cart");
		}
		orderList(request,model);
		return "orderList";
	}
	
	
	@RequestMapping("/order")
	public String orderList(HttpServletRequest request,Model model){
		User user = (User) request.getSession().getAttribute("user");
		//创建新的集合存储所有的Order信息
		List<Orders> orderList = new ArrayList<Orders>();
		//根据用户id查询订单Id
		List<Orders> ordersList = orderService.findOrderIdByUserId(user.getUserId());
		//根据订单Id查询所有的订单项
		for (Orders orders : ordersList) {
			String orderId = orders.getOrderId();
			List<OrderInfo> orderInfoList = orderService.findOrderInfoByOrderId(orderId);
			Map<Item,Integer> itemMap = new HashMap<Item,Integer>();
			for (OrderInfo orderInfo : orderInfoList) {
				Item item = new Item();
				item.setId(orderInfo.getItemId());
				item.setTitle(orderInfo.getItemTitle());
				item.setItemUrl(orderInfo.getItemUrl());
				item.setNum(orderInfo.getNum());
				item.setPrice(orderInfo.getPrice());
				itemMap.put(item, orderInfo.getNum());
			}
			orders.setItemMap(itemMap);
			orderList.add(orders);
			model.addAttribute("orderList",orderList);
		}
		return "orderList";
	}
	
	@RequestMapping("/toPay")
	public String toPay(String orderId){
		orderService.pay(orderId);
		return "pay";
	}
}
