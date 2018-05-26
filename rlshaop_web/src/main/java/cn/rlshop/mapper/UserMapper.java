package cn.rlshop.mapper;

import cn.rlshop.model.User;

public interface UserMapper {
	/**
	 * 用户登录
	 */
	public User findUserByUP(User user);
	
	public User login(User user);
	
	public void saveUser(User user);
	/**
	 * 更新用户
	 */
	public void updateUser(User user);
}
