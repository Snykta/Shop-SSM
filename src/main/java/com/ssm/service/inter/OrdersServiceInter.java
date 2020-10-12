package com.ssm.service.inter;

import com.ssm.po.GoodsOrders;

public interface OrdersServiceInter {
	
	String getCounts(Integer num) throws Exception;
	
	/**
	 * ��ҳ��ѯ
	 * @param page
	 * @return
	 * @throws Exception
	 */
	String FenyeList(Integer page,Integer order_userid) throws Exception;
	
	
	String delByidOrders(Integer id) throws Exception;
	
	/**
	 * ����
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String PayOrders(Integer id) throws Exception;
	
	
	/**
	 * ����
	 * @param goodsOrders
	 * @return
	 * @throws Exception
	 */
	String addOrders(String lists) throws Exception;
	
	/**
	 * ����Ա��ѯ��֧������֧���ȵ�......������Ϣ
	 * @return
	 * @throws Exception
	 */
	String adminDaipays(Integer status) throws  Exception;
	
	
	/**
	 * ����Ա��ѯ�ѷ�����δ�����ȵ�......������Ϣ
	 * @param status
	 * @return
	 * @throws Exception
	 */
	String adminLogistics(String status) throws  Exception;
	
	/**
	 * ����Աɾ������
	 * @param id
	 * @param shiro_id
	 * @return
	 * @throws Exception
	 */
	String adminDelsOrders(Integer id,Integer shiro_id) throws Exception;
	/**
	 * ����Ա����
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean adminFaOrdes(Integer id) throws Exception;
	
	/**
	 * ����Ա�鿴�����û����µĶ���
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String adminGetords(Integer id) throws Exception;

}
