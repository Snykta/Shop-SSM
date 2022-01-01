package com.ssm.interceptors;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class InterceptorCustom implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
			throws Exception {
		
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String url = request.getRequestURI();
		System.out.println(url);
		Object user=request.getSession().getAttribute("shop-users");
		
		if(user==null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('请先登录再访问！');location.href='/Shop-SSM/shop-user/login.html';</script>");
			return false;
		}

		return true;
		
		
	}

}
