package com.tele.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tele.common.interceptor.CheckLoginSessionInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer{
	
	 @Override
	    public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(new CheckLoginSessionInterceptor())
//					.order(1)
					.addPathPatterns("/v1/infra/**")
					.excludePathPatterns(
							"/resources/**",
//							"/adt/**",
//							"/xdm/**",
							"/v1/infra/member/signinUsrForm",
							"/v1/infra/member/signupUsrForm"
							
			);	
			
		}
	
}
