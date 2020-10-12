package com.ssm.service.inter;

public interface ShiroServiceInter {
	
	/**
	 * 查询所有shiro
	 * @return
	 * @throws Exception
	 */
	String GetsShiros() throws Exception;
	/**
	 * 修改管理员权限
	 * @param shiroId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	boolean AdminUpdateShi(Integer shiroId,Integer userId) throws Exception;

}
