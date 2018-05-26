package cn.rlshop.service;

import cn.rlshop.model.User;

public interface UserService {
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	/**
	 * 新增用户
	 * @param user
	 */
	public void addUser(User user);
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * ajax检测用户名是否存在
	 * @return
	 */
	public User findUserByUserName(String userName);
	/**
	 * 用户登录
	 */
	public User findUserByUP(User user);
}
