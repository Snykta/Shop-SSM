package com.ssm.service.inter;

import com.ssm.po.ReceAddress;

public interface ReceAddressInter {
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String getByIdAddress(Integer id) throws Exception;
	/**
	 * 更新地址
	 * @param address
	 * @return
	 * @throws Exception
	 */
	String updateAddress(ReceAddress address) throws Exception; 

}
