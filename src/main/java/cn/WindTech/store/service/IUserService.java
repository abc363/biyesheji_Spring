package cn.WindTech.store.service;

import cn.WindTech.store.service.ex.*;
import cn.WindTech.store.entity.User;

import java.util.List;

/**
 * 处理用户数据的业务层接口
 */
public interface IUserService {
	/**
	 * 用户注册
	 * @param user 尝试注册的用户数据
	 * @throws UsernameDuplicateException 用户名被占用时的异常
	 * @throws InsertException 插入数据失败时的异常
	 */
	void reg(User user)
			throws UsernameDuplicateException,
			InsertException;

	/**
	 * 用户登录
	 * @return 成功登录的用户信息
	 * @throws UserNotFoundException 用户数据不存在
	 * @throws PasswordNotMatchException 密码错误
	 */
	User login(User user) throws UserNotFoundException, PasswordNotMatchException;

	/**
	 * 修改用户的密码
	 * @param uid 当前登录的用户id
	 * @param username 当前登录的用户名
	 * @param oldPassword 原密码
	 * @param newPassword 新密码
	 * @throws UserNotFoundException 用户数据不存在
	 * @throws PasswordNotMatchException 验证密码失败
	 * @throws UpdateException 更新数据异常
	 */
	void changePassword(
			Integer uid, String username,
			String oldPassword, String newPassword)
			throws UserNotFoundException,
			PasswordNotMatchException,
			UpdateException;
	/**
	 * 根据id删除用户数据
	 * @param uid 将删除的用户数据的id
	 * @throws DeleteException 删除数据异常
	 */
	void delete(Integer uid,User user) throws DeleteException;
	/**
	 *展示用户数据
	 */
	List<User> getAllUser(User user);


}





