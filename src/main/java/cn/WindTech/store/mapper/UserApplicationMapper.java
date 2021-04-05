package cn.WindTech.store.mapper;

import cn.WindTech.store.entity.News;
import cn.WindTech.store.entity.User;
import cn.WindTech.store.entity.UserApplication;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 处理用户数据的持久层接口
 */
public interface UserApplicationMapper {

	Integer insert(UserApplication userApplication);
	/**
	 * 根据用户名查询用户数据
	 * @param username 用户名
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	UserApplication findByUsername(String username);
	/**
	 * 更新用户密码
	 * @param uaid 用户的id
	 * @param password 新密码
	 * @return 受影响的行数
	 */
	Integer updatePassword(
            @Param("uaid") Integer uaid,
            @Param("password") String password,
            @Param("modifiedTime") String modifiedTime);

	/**
	 * 根据用户id查询用户数据
	 * @param uaid 用户id
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	UserApplication findByUAid(Integer uaid);
	/**
	 * 根据id删除产品数据
	 * @param uaid 将删除的用户数据的id
	 * @return 受影响的行数
	 */
	Integer deleteByUAid(Integer uaid);
//	展示用户列表
	List<UserApplication> showUser(UserApplication userApplication);
//  更新时间
    Integer updateTime(UserApplication userApplication);
//      搜索新闻数据
	List<UserApplication> searchUser(@Param("username")String username,
						  @Param("startPage")Integer startPage, @Param("pageSize")Integer pageSize);
}





