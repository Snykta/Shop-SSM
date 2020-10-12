package com.ssm.dao;



import org.apache.ibatis.annotations.Param;

import com.ssm.po.ReceAddress;

public interface ReceAddressMapper {
	
	/**
	 * ����id��ѯ�ջ���ַ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	ReceAddress getAddress(Integer id) throws Exception;
	
	/**
	 * �����ջ���ַ
	 * @param address
	 * @return
	 * @throws Exception
	 */
	int updateAddress(@Param("addres") ReceAddress address) throws Exception;
	
	/**
	 * ��ע��ɹ������õ�ַ���û����
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	int addAddress(Integer userId) throws Exception;

}
