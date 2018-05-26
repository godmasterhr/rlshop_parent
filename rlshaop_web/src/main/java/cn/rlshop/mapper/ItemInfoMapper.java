package cn.rlshop.mapper;

import org.apache.ibatis.annotations.Param;

import cn.rlshop.model.Item;


public interface ItemInfoMapper {
	/**
	 * 根据商品id查询商品详细信息
	 * @return
	 */
	public Item findItemById(String id);

	public void saveItem(Item item);

	public void updateItemIncluImg(Item item);

	public void updateItemNoImg(Item item);

	public void deleteItemById(String itemId);

	public void updateNum(@Param("id")String id,@Param("num") int i);
}
