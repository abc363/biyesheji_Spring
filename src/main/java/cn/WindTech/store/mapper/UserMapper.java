package cn.WindTech.store.mapper;

import cn.WindTech.store.entity.Product;
import cn.WindTech.store.entity.User;
import cn.WindTech.store.vo.ProductVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 处理用户数据的持久层接口
 */
public interface UserMapper {
	/**
	 * 插入用户数据
	 * @param user 用户数据
	 * @return 受影响的行数
	 */
	Integer insert(User user);
	/**
	 * 根据用户名查询用户数据
	 * @param username 用户名
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	User findByUsername(String username);
	/**
	 * 更新用户密码
	 * @param uid 用户的id
	 * @param password 新密码
	 * @return 受影响的行数
	 */
	Integer updatePassword(
			@Param("uid") Integer uid,
			@Param("password") String password,
            @Param("modifiedTime") String modifiedTime);

	/**
	 * 根据用户id查询用户数据
	 * @param uid 用户id
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	User findByUid(Integer uid);
	/**
	 * 根据id删除产品数据
	 * @param uid 将删除的用户数据的id
	 * @return 受影响的行数
	 */
	Integer deleteByUid(Integer uid);

	List<User> showUser(User user);

    Integer updateTime(User user);

}





