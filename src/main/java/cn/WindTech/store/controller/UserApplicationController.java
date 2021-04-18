package cn.WindTech.store.controller;

import cn.WindTech.store.entity.SearchUser;
import cn.WindTech.store.entity.User;
import cn.WindTech.store.entity.UserApplication;
import cn.WindTech.store.entity.password;
import cn.WindTech.store.service.IUserApplicationService;
import cn.WindTech.store.service.IUserService;
import cn.WindTech.store.util.ResponseResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping(value = "/userApplication")
@CrossOrigin
public class UserApplicationController extends BaseController{

	@Autowired
	private IUserApplicationService userApplicationService;
	@RequestMapping("/reg")
	public ResponseResult<Void> reg(@RequestBody UserApplication userApplication) {
		userApplicationService.reg(userApplication);
		return new ResponseResult<>(SUCCESS);
	}

	@RequestMapping("/login")
	public ResponseResult<UserApplication> login(@RequestBody UserApplication userApplication, HttpSession session,HttpServletRequest request) {
		// 执行登录验证
		UserApplication data = userApplicationService.login(userApplication);
		// 向Session中封装用户信息
		session.setAttribute("uid", data.getUaid());
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
		Integer uaid = Integer.parseInt(session.getAttribute("uaid").toString());
		String username =session.getAttribute("username").toString();
		// 执行修改密码：
		userApplicationService.changePassword(uaid, username, oldPassword, newPassword);
		// 返回结果
		return new ResponseResult<>(SUCCESS);
	}

	@RequestMapping("/changeUser")
	public ResponseResult<Void> changeUser(
			@RequestBody UserApplication userApplication,
			HttpSession session) {
		// 从session中获取uid和username
		Integer uaid = userApplication.getUaid();
		Integer news_isPublish = userApplication.getNews_isPublish();
		Integer news_isNow = userApplication.getNews_isNow();
		// 执行修改密码：
		userApplicationService.changeUser(uaid,news_isPublish,news_isNow);
		// 返回结果
		return new ResponseResult<>(SUCCESS);
	}
	//删除特定id的数据
	@RequestMapping("/{uaid}/deleteUser")
	public ResponseResult<Void> delete(@PathVariable("uaid") Integer uaid,UserApplication userApplication) {
		// 执行
		userApplicationService.delete(uaid,userApplication);
		// 返回
		return new ResponseResult<>(SUCCESS);
	}
	// 展示用户数据
	@GetMapping("/showUser")
	public ResponseResult<List<UserApplication>> getAllUser(UserApplication userApplication) {
		// 调用业务层对象执行
		List<UserApplication> data = userApplicationService.getAllUser(userApplication);
		// 返回
		return new ResponseResult<>(SUCCESS, data);
	}
	@RequestMapping("/logout")
	public ResponseResult<Void> logout(HttpServletRequest request) {
		request.getSession().invalidate();
		// 返回成功
		return new ResponseResult<>(SUCCESS);
	}
	// 模糊搜索新闻数据
	@RequestMapping("/search")
	public ResponseResult<JSONObject> searchUser(@RequestBody SearchUser search) {
		String username = search.getUsername();
		Integer startPage = search.getStartPage();
		Integer pageSize = search.getPageSize();
		// 调用业务层对象执行
		List<UserApplication> data = userApplicationService.searchUser(username,startPage,pageSize);
		JSONObject result = new JSONObject();
		result.put("tableData",data);
		result.put("totalNum",1);
		// 返回
		return new ResponseResult<>(SUCCESS, result);
	}
}







