package com.ssm.dao;



import org.apache.ibatis.annotations.Param;

import com.ssm.po.ReceAddress;

public interface ReceAddressMapper {
	
	/**
	 * 根据id查询收货地址
	 * @param id
	 * @return
	 * @throws Exception
	 */
	ReceAddress getAddress(Integer id) throws Exception;
	
	/**
	 * 更新收货地址
	 * @param address
	 * @return
	 * @throws Exception
	 */
	int updateAddress(@Param("addres") ReceAddress address) throws Exception;
	
	/**
	 * 在注册成功后加入该地址的用户外键
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	int addAddress(Integer userId) throws Exception;

}
