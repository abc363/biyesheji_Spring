package cn.WindTech.store.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.WindTech.store.entity.password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.WindTech.store.entity.User;
import cn.WindTech.store.service.IUserService;
import cn.WindTech.store.util.ResponseResult;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;


@RestController
@RequestMapping(value = "/users")
@CrossOrigin
public class UserController extends BaseController{

	@Autowired
	private IUserService userService;
	@RequestMapping("/reg")
	public ResponseResult<Void> reg(@RequestBody User user) {
		userService.reg(user);
		return new ResponseResult<>(SUCCESS);
	}

	@RequestMapping("/login")
	public ResponseResult<User> login(@RequestBody User user, HttpSession session,HttpServletRequest request) {
		// 执行登录验证
		User data = userService.login(user);
		// 向Session中封装用户信息
		session.setAttribute("uid", data.getUid());
		session.setAttribute("username", data.getUsername());
		// 返回
		return new ResponseResult<>(SUCCESS, data);
	}

	@RequestMapping("/change_password")
	public ResponseResult<Void> changePassword(
			@RequestBody password password,
			HttpSession session) {
		// 从session中获取uid和username
		String oldPassword = password.getOldPassword();
		String newPassword = password.getNewPassword();
		Integer uid = Integer.parseInt(session.getAttribute("uid").toString());
		System.out.println(uid);
		String username =session.getAttribute("username").toString();
		// 执行修改密码：
		userService.changePassword(uid, username, oldPassword, newPassword);
		// 返回结果
		return new ResponseResult<>(SUCCESS);
	}
	//删除特定id的数据
	@RequestMapping("/{uid}/deleteUser")
	public ResponseResult<Void> delete(@PathVariable("uid") Integer uid,User user) {
		// 执行
		userService.delete(uid,user);
		// 返回
		return new ResponseResult<>(SUCCESS);
	}
	// 展示用户数据
	@GetMapping("/showUser")
	public ResponseResult<List<User>> getAllUser(User user) {
		// 调用业务层对象执行
		List<User> data = userService.getAllUser(user);
		// 返回
		return new ResponseResult<>(SUCCESS, data);
	}
	@RequestMapping("/logout")
	public ResponseResult<Void> logout(HttpServletRequest request) {
		request.getSession().invalidate();
		// 返回成功
		return new ResponseResult<>(SUCCESS);
	}
}







