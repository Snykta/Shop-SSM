package com.ssm.service.inter;

import com.ssm.po.ReceAddress;

public interface ReceAddressInter {
	
	/**
	 * ����id��ѯ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String getByIdAddress(Integer id) throws Exception;
	/**
	 * ���µ�ַ
	 * @param address
	 * @return
	 * @throws Exception
	 */
	String updateAddress(ReceAddress address) throws Exception; 

}
