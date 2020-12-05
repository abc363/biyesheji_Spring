package cn.WindTech.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
		    System.out.println("#############");
			response.setHeader("sessionstatus", "timeout");
			response.sendError(518, "因为您长时间没有操作，您的登录信息已过期，请重新登录");
			return false;
		}
		return true;
	}

}
