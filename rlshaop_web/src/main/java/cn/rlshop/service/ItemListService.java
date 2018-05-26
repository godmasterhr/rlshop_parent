package cn.rlshop.service;

import java.util.List;

import cn.rlshop.model.Item;
import cn.rlshop.model.ItemPage;


public interface ItemListService {
	
	public List<Item> findItemList(String type);

	public List<Item> search(String key, Integer page, Integer rows);
	
}
