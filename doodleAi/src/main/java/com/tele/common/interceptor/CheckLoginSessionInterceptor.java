package com.tele.common.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import com.tele.common.constants.Constants;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class CheckLoginSessionInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (request.getSession().getAttribute("sessSeqUsr") != null) {
			// by pass
		} else {
			response.sendRedirect(Constants.URL_LOGINFORMUSR);
	        return false;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
}
