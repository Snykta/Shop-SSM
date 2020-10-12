package com.ssm.service.inter.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssm.po.AdminUser;

public interface AdminUserServiceInter {
	
	/**
	 * 管理登录
	 * @param adminUser
	 * @return
	 */
	boolean adminLogin(AdminUser adminUser) throws Exception;
	
	/**
	 * 管理员退出登录
	 * @throws Exception
	 */
	void LoginOut(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	/**
	 * 展示所有管理员信息
	 * @return
	 * @throws Exception
	 */
	String GetAdmins() throws Exception;

}
