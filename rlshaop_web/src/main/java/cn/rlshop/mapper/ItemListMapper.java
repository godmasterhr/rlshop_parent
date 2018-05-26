package cn.rlshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.rlshop.model.Item;
import cn.rlshop.model.ItemPage;

public interface ItemListMapper {
	
	public List<Item> findItemList(String type);

	public List<Item> search(@Param("key")String key, @Param("page")Integer page, @Param("rows")Integer rows);

	
	

	
}
