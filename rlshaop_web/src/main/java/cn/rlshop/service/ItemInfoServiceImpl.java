package cn.rlshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rlshop.mapper.ItemInfoMapper;
import cn.rlshop.model.Item;



@Service
public class ItemInfoServiceImpl implements ItemInfoService{
	@Autowired
	private ItemInfoMapper itemInfoMapper;
	/**
	 * 根据商品id查询商品详细信息
	 * @return
	 */
	@Override
	public Item findItemById(String id) {
		return itemInfoMapper.findItemById(id);
	}
	@Override
	public void saveItem(Item item) {
		itemInfoMapper.saveItem(item);
	}
	@Override
	public void updateItem(Item item, boolean b) {
		if(b)itemInfoMapper.updateItemIncluImg(item);
			 itemInfoMapper.updateItemNoImg(item);
		
	}
	@Override
	public void deleteItemById(String itemId) {
		itemInfoMapper.deleteItemById(itemId);
	}
	@Override
	public void updateNum(String id, int i) {
		 itemInfoMapper.updateNum(id,i);
	}

}
