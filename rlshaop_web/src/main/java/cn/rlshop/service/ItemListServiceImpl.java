package cn.rlshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rlshop.mapper.ItemListMapper;
import cn.rlshop.model.Item;
import cn.rlshop.model.ItemPage;
@Service
public class ItemListServiceImpl implements ItemListService{
	
	@Autowired
	private ItemListMapper itemListMapper;

	@Override
	public List<Item> findItemList(String type) {
		return itemListMapper.findItemList(type);
	}

	@Override
	public List<Item> search(String key, Integer page, Integer rows) {
//		return itemListMapper.findItemList("1");
		return itemListMapper.search(key,page,rows);
	}



}
