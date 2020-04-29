package cn.WindTech.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.WindTech.store.entity.User;
import cn.WindTech.store.service.IUserService;
import cn.WindTech.store.util.ResponseResult;

import java.util.Date;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping(value = "/users")
public class UserController extends BaseController{

	@Autowired
	private IUserService userService;
	@RequestMapping("/reg")
	public ResponseResult<Void> reg(User user) {
		userService.reg(user);
		return new ResponseResult<>(SUCCESS);
	}

	@RequestMapping("/login")
	public ResponseResult<User> login(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session) {
		// 执行登录验证
		User data = userService.login(username, password);
		// 向Session中封装用户信息
		session.setAttribute("id", data.getId());
		session.setAttribute("username", data.getUsername());
		// 返回
		return new ResponseResult<>(SUCCESS, data);
	}

}







