package cn.rlshop.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rlshop.mapper.UserMapper;
import cn.rlshop.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 用户登录
	 */
	public User login(User user) {
		return userMapper.login(user);
	}
	/**
	 * 新增用户
	 */
	public void addUser(User user){
		user.setUserId(UUID.randomUUID().toString());
		userMapper.saveUser(user);
			
	}
	/**
	 * 更新用户
	 */
	public void updateUser(User user){
		userMapper.updateUser(user);
	}
	
	/**
	 * 用户登录
	 */
	public User findUserByUP(User user) {
		return userMapper.findUserByUP(user);
	}
	@Override
	public User findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
}
