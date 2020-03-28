package cn.WindTech.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.WindTech.store.controller.ex.FileUploadException;
import cn.WindTech.store.service.ex.PasswordNotMatchException;
import cn.WindTech.store.service.ex.ServiceException;
import cn.WindTech.store.service.ex.UserNotFoundException;
import cn.WindTech.store.service.ex.UsernameDuplicateException;
import cn.WindTech.store.util.ResponseResult;

/**
 * 控制器类的基类
 */
public abstract class BaseController {
	/**
	 * 响应结果的状态：成功
	 */
	public static final Integer SUCCESS = 200;
	/**
	 * 从Session获取当前登录的用户id
	 * @param session HttpSession对象
	 * @return 当前登录的用户id
	 */
	protected final Integer getUidFromSession(HttpSession session) {
		return Integer.valueOf(session.getAttribute("uid").toString());
	}
	/**
	 * 统一处理异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ServiceException.class, FileUploadException.class})
	public ResponseResult<Void> handleException(Throwable e) {
		ResponseResult<Void> rr = new ResponseResult<>();
		rr.setMessage(e.getMessage());
		if (e instanceof UsernameDuplicateException) {
			// 400-用户名冲突
			rr.setState(400);
		} else if (e instanceof UserNotFoundException) {
			// 401-用户数据不存在
			rr.setState(401);
		} else if (e instanceof PasswordNotMatchException) {
			// 402-验证密码失败
			rr.setState(402);
		}
		
		return rr;
	}
	
}
