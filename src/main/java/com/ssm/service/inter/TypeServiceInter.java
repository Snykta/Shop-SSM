package com.ssm.service.inter;

import com.ssm.po.GoodsType;

public interface TypeServiceInter {
	
	/**
	 * ��ҳչʾservice��
	 * @return
	 * @throws Exception
	 */
	String goodsIndex() throws Exception;
	/**
	 * ����Աɾ��
	 * @param id
	 * @param shiro_id
	 * @return
	 * @throws Exception
	 */
	String admin_delType(Integer id,Integer shiro_id) throws Exception;
	/**
	 * ����Ա������
	 * @param name
	 * @return
	 * @throws Exception
	 */
	boolean AdminAddType(GoodsType type) throws Exception;
	
	/**
	 * ��id��ѯ���
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String AdminGetIdType(Integer id) throws Exception;
	
	/**
	 * �������
	 * @param type
	 * @return
	 * @throws Exception
	 */
	boolean AdminUpdateTypes(GoodsType type) throws Exception;

}
