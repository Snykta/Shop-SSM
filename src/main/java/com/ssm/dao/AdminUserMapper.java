package com.ssm.dao;

import java.util.List;

import com.ssm.po.AdminUser;
import com.ssm.po.AdminUserOV;

public interface AdminUserMapper {
	
	/**
	 * 后台登录
	 * @param adminUser
	 * @return
	 * @throws Exception
	 */
	AdminUser adminLogin(AdminUser adminUser) throws Exception;
	
	/**
	 * 查询所有管理员
	 * @return
	 * @throws Exception
	 */
	List<AdminUserOV> GetAdmin() throws Exception;

}
