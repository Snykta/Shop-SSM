package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.po.AdminShiroS;

public interface AdminShiro {
	
	/**
	 * ��ѯ����Ȩ��
	 * @return
	 * @throws Exception
	 */
	List<AdminShiroS> ShiroGets() throws Exception;
	
	/**
	 * ���¹���ԱȨ��
	 * @param shiroId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	int AdminUpdateShiro(@Param("shiroId")Integer shiroId,@Param("userId")Integer userId) throws Exception;

}
