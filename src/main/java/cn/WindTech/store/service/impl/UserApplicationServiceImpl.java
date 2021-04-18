package cn.WindTech.store.service.impl;

import cn.WindTech.store.entity.News;
import cn.WindTech.store.entity.UserApplication;
import cn.WindTech.store.mapper.UserApplicationMapper;
import cn.WindTech.store.mapper.UserMapper;
import cn.WindTech.store.service.IUserApplicationService;
import cn.WindTech.store.service.IUserService;
import cn.WindTech.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 处理用户数据的业务层实现类
 */
@Service
public class UserApplicationServiceImpl implements IUserApplicationService {

	@Autowired 
	private UserApplicationMapper userApplicationMapper;
//	注册功能
	@Override
	public void reg(UserApplication userApplication) throws UsernameDuplicateException, InsertException {
		// 根据尝试注册的用户名查询用户数据
		String username = userApplication.getUsername();
		UserApplication result = findByUsername(username);
		// 检查用户名是否被占用：如果查询到数据，则表示被占用，如果查询结果为null，则表示用户名没有被占用
		if (result == null) {
			userApplication.setIsDelete(0);
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			userApplication.setCreatedUser(username);
			userApplication.setCreatedTime(formatter.format(date));
			userApplication.setModifiedUser(username);
			userApplication.setModifiedTime(formatter.format(date));
			// 执行注册
			insert(userApplication);
		} else {
			// 已占用：抛出UsernameDuplicateException
			throw new UsernameDuplicateException(
					"注册失败！您尝试注册的用户名(" + username + ")已经被占用！");
		}
	}
//	登录功能
	@Override
	public UserApplication login(UserApplication userApplication) throws UserNotFoundException, PasswordNotMatchException {
		// 根据参数username查询用户：User findByUsername(String username)
		String username = userApplication.getUsername();
		String password = userApplication.getPassword();
		UserApplication result = findByUsername(username);
		// 判断查询结果是否为null
		if (result == null) {
			throw new UserNotFoundException(
				"登录失败！尝试登录的用户不存在！");
		}
		// 判断is_delete是否标记为已删除：isDelete属性值是否为1
		if (result.getIsDelete().equals(1)) {
			throw new UserNotFoundException(
				"登录失败！尝试登录的用户不存在！");
		}
		if (result.getPassword().equals(password)) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			userApplication.setModifiedUser(username);
			userApplication.setModifiedTime(formatter.format(date));
            updateTime(userApplication);
			result.setIsDelete(null);
			// 返回查询结果
			return result;
		} else {
			throw new PasswordNotMatchException(
				"登录失败！密码错误！");
		}
	}
//	修改密码
	@Override
	public void changePassword(Integer uaid, String username, String oldPassword, String newPassword)
			throws UserNotFoundException, PasswordNotMatchException, UpdateException {
		// 根据uid查询用户数据
		UserApplication result = findByUAid(uaid);
		// 判断查询结果是否为null
		if (result == null) {
			// 是：抛出UserNotFoundException
			throw new UserNotFoundException(
					"修改密码失败！尝试访问的用户不存在！");
		}

		// 判断查询结果中isDelete是否为1
		if (result.getIsDelete().equals(1)) {
			// 是：抛出UserNotFoundException
			throw new UserNotFoundException(
					"修改密码失败！尝试访问的用户不存在！");
		}
		if (result.getPassword().equals(oldPassword)) {
			// 是：抛出PasswordNotMatchException
			throw new PasswordNotMatchException(
					"修改密码失败！原密码错误！");
		}
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		updatePassword(uaid, newPassword,formatter.format(date));
	}
	@Override
	public void changeUser(Integer uaid, Integer news_isPublish, Integer news_isNow)
			throws UpdateException {
		updateUser(uaid, news_isPublish,news_isNow);
	}
	//    搜索新闻
	@Override
	public List<UserApplication> searchUser(String username, Integer startPage, Integer pageSize) {
		return searchUsers(username,startPage,pageSize);
	}
	//    删除用户数据
	@Override
	@Transactional
	public void delete(Integer uaid,UserApplication userApplication) throws DeleteException{
		// 执行删除
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		userApplication.setModifiedUser("windiot");
		userApplication.setUsername("windiot");
		userApplication.setModifiedTime(formatter.format(date));
        updateTime(userApplication);
		deleteByUAid(uaid);
	}
//	获取所有用户
	@Override
	public List<UserApplication> getAllUser(UserApplication userApplication) {
		return showAllUser(userApplication);
	}
	/**
	 * 插入用户数据
	 * @param userApplication 用户数据
	 */
	private void insert(UserApplication userApplication) {
		Integer rows = userApplicationMapper.insert(userApplication);
		if (rows != 1) {
			throw new InsertException(
					"插入用户数据时出现未知错误！");
		}
	}
	private List<UserApplication> searchUsers(String username,Integer startPage,Integer pageSize) {
		return userApplicationMapper.searchUser(username,startPage,pageSize);
	}
	/**
	 * 根据用户名查询用户数据
	 * @param username 用户名
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	private UserApplication findByUsername(String username) {
		return userApplicationMapper.findByUsername(username);
	}


	/**
	 * 更新用户密码
	 * @param uaid 用户的id
	 * @param password 新密码
	 */
	private void updatePassword(
			Integer uaid, String password,String time) {
		Integer rows = userApplicationMapper.updatePassword(uaid, password,time);
		if (rows != 1) {
			throw new UpdateException(
					"修改用户数据时出现未知错误！");
		}
	}
	private void updateUser(
			Integer uaid, Integer news_isPublish,Integer news_isNow) {
		Integer rows = userApplicationMapper.updateUser(uaid, news_isPublish,news_isNow);
		if (rows != 1) {
			throw new UpdateException(
					"修改用户数据时出现未知错误！");
		}
	}
//	修改时间
    private void updateTime(UserApplication userApplication) {
        Integer rows = userApplicationMapper.updateTime(userApplication);
        if (rows != 1) {
            throw new UpdateException(
                    "修改用户数据时出现未知错误！");
        }
    }
	/**
	 * 根据用户id查询用户数据
	 * @param uaid 用户id
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	private UserApplication findByUAid(Integer uaid) {
		return userApplicationMapper.findByUAid(uaid);
	}
//	删除用户数据
	private void deleteByUAid(Integer uaid) {
		Integer rows = userApplicationMapper.deleteByUAid(uaid);
		if (rows != 1) {
			throw new DeleteException("删除用户时出现未知错误！");
		}
	}
	/**
	 * 查询所有用户数据
	 */
	private List<UserApplication> showAllUser(UserApplication userApplication) {
		return userApplicationMapper.showUser(userApplication);
	}
}





