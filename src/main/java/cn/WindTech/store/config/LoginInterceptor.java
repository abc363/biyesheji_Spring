package cn.WindTech.store.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control","no-cache");
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        String url = request.getRequestURL().toString();
//        if(url.indexOf("login")>0){
//            return true;
//        }
//        System.out.println("11111");
//        HttpSession session = request.getSession(true);
//        String username = session.getAttribute("username").toString();
//
//        if(null!=username) {//已登录
//            return true;
//        }else{
//            request.setAttribute("msg", "您还没有登录，请先登录！");
//            System.out.println("2222");
//            return false;
//        }
//        else {//未登录
//            //直接重定向到登录页面
//            if(request.getHeader("x-requested-with")!=null &&
//                    request.getHeader("x-requested-with").equals("XMLHttpRequest")){
//                response.setHeader("sessionStatus","timeout");
//                response.sendError(518,"session timeOut");
//            }else{
//                System.out.println("################"+request.getContextPath());
//                response.sendRedirect(request.getContextPath()+"/index.html/#login");
//            }
//            return false;
//        }
        return true;
    }
}