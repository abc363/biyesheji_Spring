package cn.WindTech.store.service;

import cn.WindTech.store.entity.News;
import cn.WindTech.store.entity.User;
import cn.WindTech.store.entity.UserApplication;
import cn.WindTech.store.service.ex.*;

import java.util.List;

/**
 * 处理用户数据的业务层接口
 */
public interface IUserApplicationService {

	void reg(UserApplication userApplication)
			throws UsernameDuplicateException,
			InsertException;

	/**
	 * 用户登录
	 * @return 成功登录的用户信息
	 * @throws UserNotFoundException 用户数据不存在
	 * @throws PasswordNotMatchException 密码错误
	 */
	UserApplication login(UserApplication userApplication) throws UserNotFoundException, PasswordNotMatchException;

	/**
	 * 修改用户的密码
	 * @param uaid 当前登录的用户id
	 * @param username 当前登录的用户名
	 * @param oldPassword 原密码
	 * @param newPassword 新密码
	 * @throws UserNotFoundException 用户数据不存在
	 * @throws PasswordNotMatchException 验证密码失败
	 * @throws UpdateException 更新数据异常
	 */
	void changePassword(
            Integer uaid, String username,
            String oldPassword, String newPassword)
			throws UserNotFoundException,
			PasswordNotMatchException,
			UpdateException;

	void changeUser(
			Integer uaid, Integer news_isPublish,
			Integer news_isNow)
			throws
			UpdateException;
	/**
	 * 根据id删除用户数据
	 * @param uaid 将删除的用户数据的id
	 * @throws DeleteException 删除数据异常
	 */
	void delete(Integer uaid, UserApplication userApplication) throws DeleteException;
	/**
	 *展示用户数据
	 */
	List<UserApplication> getAllUser(UserApplication userApplication);

	//  搜索新闻数据
	List<UserApplication> searchUser(String username, Integer startPage, Integer pageSize);
}





