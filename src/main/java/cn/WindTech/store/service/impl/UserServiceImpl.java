package cn.WindTech.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.WindTech.store.entity.User;
import cn.WindTech.store.mapper.UserMapper;
import cn.WindTech.store.service.IUserService;
import cn.WindTech.store.service.ex.PasswordNotMatchException;
import cn.WindTech.store.service.ex.UserNotFoundException;

/**
 * 处理用户数据的业务层实现类
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired 
	private UserMapper userMapper;
	
	@Override
	public User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
		// 根据参数username查询用户：User findByUsername(String username)
		User result = findByUsername(username);
		// 判断查询结果是否为null
		if (result == null) {
			// 是：抛出UserNotFoundException
			throw new UserNotFoundException(
				"登录失败！尝试登录的用户不存在！");
		}

		// 判断is_delete是否标记为已删除：isDelete属性值是否为1
		if (result.getIsDelete().equals(1)) {
			// 是：抛出UserNotFoundException
			throw new UserNotFoundException(
				"登录失败！尝试登录的用户不存在！");
		}

		// 从查询结果中获取盐值
		String salt = result.getSalt();
		// 对参数password执行加密
		String md5Password = getMd5Password(password, salt);
		// 判断查询结果中的密码与刚加密结果是否一致
		if (result.getPassword().equals(md5Password)) {
			// 是：准备返回结果，先去除部分不需要对外使用的数据
			result.setPassword(null);
			result.setSalt(null);
			result.setIsDelete(null);
			// 返回查询结果
			return result;
		} else {
			// 否：抛出PasswordNotMatchException
			throw new PasswordNotMatchException(
				"登录失败！密码错误！");
		}
	}
	
	/**
	 * 根据用户名查询用户数据
	 * @param username 用户名
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	private User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}
	


	/**
	 * 获取执行MD5加密后的密码
	 * @param password 原密码
	 * @param salt 盐值
	 * @return 加密后的密码
	 */
	private String getMd5Password(
			String password, String salt) {
		// 加密规则：使用“盐+密码+盐”作为原始数据，执行5次加密
		String result = salt + password + salt;
		for (int i = 0; i < 5; i++) {
			result = DigestUtils
				.md5DigestAsHex(result.getBytes()).toUpperCase();
		}
		return result;
	}





}





