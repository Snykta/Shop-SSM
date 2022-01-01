package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.po.UserP;
import com.ssm.service.inter.UserServiceInter;

@Controller
public class PlainUserHandler {
	@Autowired
	private UserServiceInter serviceInter;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public String loginUsers(String users,String password) throws Exception {
		String states = serviceInter.login(users, password);
		return states;
	}
	@RequestMapping("/updateMagess.do")
	public String updateMagess(UserP userP) throws Exception {
		serviceInter.updateUsers(userP);
		return "redirect:/shop-user/user_center_info.html";
		
	}
	
	@RequestMapping("/updatePwds.do")
	@ResponseBody
	public String updatePwds(UserP userP,String oldPwd) throws Exception{
		String state = serviceInter.updatePwds(userP,oldPwd);
		return state;
	}
	
	
	@RequestMapping("/loginOut.do")
	public String loginOut(HttpServletRequest request,HttpServletResponse response) throws Exception {
		serviceInter.longOut(request, response);
		return "redirect:/shop-user/login.html";
		
	}
	
	
	@RequestMapping("/adminByidGetUser.do")
	@ResponseBody
	public String adminByidGetUser(Integer id) throws Exception{
		return serviceInter.AdminByIdPUser(id);
	}
	
	@RequestMapping(value="/adminGetByUsers.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String adminGetByUsers() throws Exception{
		return serviceInter.AdmingetByuser();
	}
	
	@RequestMapping(value="/adminDelsUsers.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String adminDelsUsers(Integer id,Integer shiro_id)throws Exception{
		if(id==null||shiro_id==null) {
			return "<script>alert('非法请求！');location.href='/Shop-SSM/admin/index.html';</script>";
		}else {
			return serviceInter.AdminDleuser(id, shiro_id);
		}
		
	}
	
	
	@RequestMapping(value="adminOneByManyOrder.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String adminOneByManyOrder() throws Exception {
		return serviceInter.adminOnToMantyode();
	}
	
	
	@RequestMapping(value="/addPlainUsers.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String addPlainUsers(UserP userP) throws Exception{
		if(userP.getUsers()==null||userP==null) {
			return "<script>alert('非法请求！');location.href='/Shop-SSM/shop-user/register.html';</script>";
		}else {
			boolean falg = serviceInter.addPlusers(userP);
			if(falg) {
				return "<script>alert('注册成功');location.href='/Shop-SSM/shop-user/login.html';</script>";
			}else {
				return "<script>alert('注册失败');location.href='/Shop-SSM/shop-user/register.html';</script>";
			}
		}
	}
	

}
