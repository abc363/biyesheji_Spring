package cn.WindTech.store.service.impl;

import cn.WindTech.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import cn.WindTech.store.entity.User;
import cn.WindTech.store.mapper.UserMapper;
import cn.WindTech.store.service.IUserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 处理用户数据的业务层实现类
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired 
	private UserMapper userMapper;
	@Override
	public void reg(User user) throws UsernameDuplicateException, InsertException {
		// 根据尝试注册的用户名查询用户数据
		String username = user.getUsername();
		User result = findByUsername(username);
		// 检查用户名是否被占用：如果查询到数据，则表示被占用，如果查询结果为null，则表示用户名没有被占用
		if (result == null) {
			// 设置is_delete
			user.setIsDelete(0);

			// 设置4项日志
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			user.setCreatedUser(username);
			user.setCreatedTime(formatter.format(date));
			user.setModifiedUser(username);
			user.setModifiedTime(formatter.format(date));
			// 执行注册
			insert(user);
		} else {
			// 已占用：抛出UsernameDuplicateException
			throw new UsernameDuplicateException(
					"注册失败！您尝试注册的用户名(" + username + ")已经被占用！");
		}
	}

	@Override
	public User login(User user) throws UserNotFoundException, PasswordNotMatchException {
		// 根据参数username查询用户：User findByUsername(String username)
		String username = user.getUsername();
		String password = user.getPassword();
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

		if (result.getPassword().equals(password)) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setModifiedUser(username);
            user.setModifiedTime(formatter.format(date));
            updateTime(user);
			// 是：准备返回结果，先去除部分不需要对外使用的数据
			result.setIsDelete(null);
			// 返回查询结果
			return result;
		} else {
			// 否：抛出PasswordNotMatchException
			throw new PasswordNotMatchException(
				"登录失败！密码错误！");
		}
	}
	@Override
	public void changePassword(Integer uid, String username, String oldPassword, String newPassword)
			throws UserNotFoundException, PasswordNotMatchException, UpdateException {
		// 根据uid查询用户数据
		User result = findByUid(uid);
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
		updatePassword(uid, newPassword,formatter.format(date));
	}
	//    删除用户数据
	@Override
	@Transactional
	public void delete(Integer uid,User user) throws DeleteException{
		// 执行删除
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setModifiedUser("windiot");
        user.setUsername("windiot");
        user.setModifiedTime(formatter.format(date));
        updateTime(user);
		deleteByUid(uid);
	}
	@Override
	public List<User> getAllUser(User user) {
		return showAllUser(user);
	}
	//    查询产品数据

	/**
	 * 插入用户数据
	 * @param user 用户数据
	 */
	private void insert(User user) {
		Integer rows = userMapper.insert(user);
		if (rows != 1) {
			throw new InsertException(
					"插入用户数据时出现未知错误！");
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
	 * 更新用户密码
	 * @param uid 用户的id
	 * @param password 新密码
	 */
	private void updatePassword(
			Integer uid, String password,String time) {
		Integer rows = userMapper.updatePassword(uid, password,time);
		if (rows != 1) {
			throw new UpdateException(
					"修改用户数据时出现未知错误！");
		}
	}
    private void updateTime(User user) {
        Integer rows = userMapper.updateTime(user);
        if (rows != 1) {
            throw new UpdateException(
                    "修改用户数据时出现未知错误！");
        }
    }
	/**
	 * 根据用户id查询用户数据
	 * @param uid 用户id
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	private User findByUid(Integer uid) {
		return userMapper.findByUid(uid);
	}

	private void deleteByUid(Integer uid) {
		Integer rows = userMapper.deleteByUid(uid);
		if (rows != 1) {
			throw new DeleteException("删除用户时出现未知错误！");
		}
	}
	/**
	 * 查询用户数据
	 */
	private List<User> showAllUser(User user) {
		return userMapper.showUser(user);
	}
}





