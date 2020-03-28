package cn.WindTech.store.mapper;

import cn.WindTech.store.entity.User;

/**
 * 处理用户数据的持久层接口
 */
public interface UserMapper {
	/**
	 * 根据用户名查询用户数据
	 * @param username 用户名
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	User findByUsername(String username);

}





