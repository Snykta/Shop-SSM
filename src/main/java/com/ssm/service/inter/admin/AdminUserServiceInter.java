package com.ssm.service.inter.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssm.po.AdminUser;

public interface AdminUserServiceInter {
	
	/**
	 * �����¼
	 * @param adminUser
	 * @return
	 */
	boolean adminLogin(AdminUser adminUser) throws Exception;
	
	/**
	 * ����Ա�˳���¼
	 * @throws Exception
	 */
	void LoginOut(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	/**
	 * չʾ���й���Ա��Ϣ
	 * @return
	 * @throws Exception
	 */
	String GetAdmins() throws Exception;

}
