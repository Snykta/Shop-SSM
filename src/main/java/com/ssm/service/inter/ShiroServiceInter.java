package com.ssm.service.inter;

public interface ShiroServiceInter {
	
	/**
	 * ��ѯ����shiro
	 * @return
	 * @throws Exception
	 */
	String GetsShiros() throws Exception;
	/**
	 * �޸Ĺ���ԱȨ��
	 * @param shiroId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	boolean AdminUpdateShi(Integer shiroId,Integer userId) throws Exception;

}
