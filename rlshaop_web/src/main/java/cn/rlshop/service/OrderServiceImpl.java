package cn.rlshop.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rlshop.mapper.OrderMapper;
import cn.rlshop.model.Item;
import cn.rlshop.model.OrderInfo;
import cn.rlshop.model.Orders;
import cn.rlshop.model.User;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderMapper orderMapper;
	/**
	 * 添加订单 订单项
	 */
	public void addOrders(Map<Item,Integer> cart, User user) {
			//定义order
			Orders order = new Orders();
			order.setOrderId(UUID.randomUUID().toString());
			order.setUserId(user.getUserId());
			order.setName(user.getName());
			order.setAddress(user.getAddress());
			order.setOrderTime(new Date());
			order.setPayMode("0");
			Double sumPrice = 0.0;
			Map<Item,Integer> itemMap = new HashMap<Item,Integer>();
		for (Map.Entry<Item,Integer> entry : cart.entrySet()) {
			Item item = entry.getKey();
			int num =  entry.getValue();
			//定义orderInfo
			OrderInfo  oi = new OrderInfo();
			oi.setOrderId(order.getOrderId());
			oi.setItemId(item.getId());
			oi.setItemTitle(item.getTitle());
			oi.setPrice(item.getPrice());
			oi.setNum(num);
			oi.setItemUrl(item.getItemUrl());
			itemMap.put(item, num);
			sumPrice += item.getPrice()*num;
			//执行插入orderInfo
			orderMapper.addOrderInfo(oi);
		}
		order.setSumPrice(sumPrice);
		//执行插入orders
		orderMapper.addOrders(order);
	}
	
	/**
	 * 根据用户id查询订单id
	 * @param userId
	 * @return
	 */
	public List<Orders> findOrderIdByUserId(String userId) {
		return orderMapper.findOrderIdByUserId(userId);
	}
	
	/**
	 * 根据订单id查询所有的订单项
	 * @param orderId
	 * @return
	 */
	public List<OrderInfo> findOrderInfoByOrderId(String orderId) {
		return orderMapper.findOrderInfoByOrderId(orderId);
	}

	/**
	 * 去支付
	 */
	public void pay(String orderId) {
		orderMapper.pay(orderId);
	}

}
