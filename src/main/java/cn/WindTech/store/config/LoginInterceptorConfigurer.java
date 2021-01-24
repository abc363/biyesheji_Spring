package cn.WindTech.store.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.WindTech.store.interceptor.LoginInterceptor;


@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
	//在Spring映射前完成拦截器依赖注入
	@Bean
	public LoginInterceptor userInterceptor() {
		return new LoginInterceptor();
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 拦截路径：必须登录才可以访问
		List<String> patterns = new ArrayList<>();
		patterns.add("/index.html#/index");
		// 排除访问路径，不需要登录就可以访问
		List<String> excludePatterns = new ArrayList<>();
		excludePatterns.add("/static/**");
		excludePatterns.add("/index.html#/resigter");
		excludePatterns.add("/index.html#/login");
		// 注册拦截器
		registry.addInterceptor(userInterceptor()).addPathPatterns(patterns).excludePathPatterns(excludePatterns);
	}
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**").allowedOrigins("*").allowedMethods(
				"GET","POST","PUT","DELETE","TRACE","OPTIONS","PATCH","HEAD"
		).allowCredentials(true);
	}
}






