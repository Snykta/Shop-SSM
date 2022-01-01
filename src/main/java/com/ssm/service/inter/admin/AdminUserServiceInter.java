package com.ssm.service.inter.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssm.po.AdminUser;

public interface AdminUserServiceInter {
	

	boolean adminLogin(AdminUser adminUser) throws Exception;
	

	void LoginOut(HttpServletRequest request, HttpServletResponse response) throws Exception;
	

	String GetAdmins() throws Exception;

}
