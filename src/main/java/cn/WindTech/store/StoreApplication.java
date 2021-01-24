package cn.WindTech.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@Configuration
@MapperScan("cn.WindTech.store.mapper")
public class StoreApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StoreApplication.class);
	}
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//允许上传的文件最大值
		factory.setMaxFileSize("500MB"); //KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("500MB");
		return factory.createMultipartConfig();
	}

}







