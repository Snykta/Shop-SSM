package com.ssm.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.po.AdminUser;
import com.ssm.service.inter.admin.AdminUserServiceInter;

@Controller
@RequestMapping("/admin")
public class AdminUserHandler {
	
	@Autowired
	private AdminUserServiceInter adminInter;
	
	@RequestMapping(value="/adminLogin.do")
	public void adminLogin(AdminUser adminUser,HttpServletResponse response) throws Exception {
		boolean falg = adminInter.adminLogin(adminUser);
		if(falg) {
			response.sendRedirect("/Shop-SSM/admin/index.html");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('登录失败');location.href='/Shop-SSM/admin/login.html';</script>");
			
		}
	}
	
	
	@RequestMapping("/LoginOut.do")
	public String LoginOut(HttpServletRequest request,HttpServletResponse response) throws Exception {
		adminInter.LoginOut(request, response);
		return "redirect:/admin/login.html";
	}
	
	@RequestMapping(value="/adminGets.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String adminGets() throws Exception{
		return adminInter.GetAdmins();
	}

}
