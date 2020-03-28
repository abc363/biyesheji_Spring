package cn.WindTech.store.service;

import cn.WindTech.store.service.ex.PasswordNotMatchException;
import cn.WindTech.store.service.ex.UserNotFoundException;
import cn.WindTech.store.entity.User;

/**
 * 处理用户数据的业务层接口
 */
public interface IUserService {

	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 成功登录的用户信息
	 * @throws UserNotFoundException 用户数据不存在
	 * @throws PasswordNotMatchException 密码错误
	 */
	User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException;
}





