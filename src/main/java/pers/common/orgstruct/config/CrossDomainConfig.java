package pers.common.orgstruct.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author Qingyu
 * @Date 2021/2/12 21:20
 * @Version 1.0
 */
@Configuration
public class CrossDomainConfig extends WebMvcConfigurerAdapter {


	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("POST", "GET", "PUT", "DELETE")
				.maxAge(3600)
				.allowCredentials(true);
	}
}
