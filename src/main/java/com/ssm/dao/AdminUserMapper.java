package com.ssm.dao;

import java.util.List;

import com.ssm.po.AdminUser;
import com.ssm.po.AdminUserOV;

public interface AdminUserMapper {
	
	/**
	 * ��̨��¼
	 * @param adminUser
	 * @return
	 * @throws Exception
	 */
	AdminUser adminLogin(AdminUser adminUser) throws Exception;
	
	/**
	 * ��ѯ���й���Ա
	 * @return
	 * @throws Exception
	 */
	List<AdminUserOV> GetAdmin() throws Exception;

}
