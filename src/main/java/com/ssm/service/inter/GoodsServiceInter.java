package com.ssm.service.inter;

import com.ssm.po.Goods;

public interface GoodsServiceInter {
	/**
	 * ��id��ѯ��Ʒ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String getIdGoods(Integer id) throws Exception;
	/**
	 * ���������Ʒ
	 * @return
	 * @throws Exception
	 */
	String roundGoods() throws Exception;
	
	/**
	 * ������id��ѯ,ͬʱ��ҳ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String getTypeIdList(Integer id) throws Exception;
	
	/**
	 * ��ѯ��Ʒ
	 * @param name
	 * @return
	 * @throws Exception
	 */
	String secahByBanmes(String name) throws Exception;
	
	/**
	 * ���һ��ѯ
	 * @return
	 * @throws Exception
	 */
	String AdminManyToOne(Integer num) throws Exception;
	
	/*
	 * ����
	 */
	String AdminCounts() throws Exception;
	/**
	 * ����Աɾ����Ʒ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String AdmindelGoods(Integer id,Integer shiro_id) throws Exception;
	
	/**
	 * ����ɾ��goods
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	String AdminDels(String ids,Integer shiro_id) throws Exception;
	
	/***
	 * ����Ա�޸���Ʒ
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	boolean AdminupdaGoods(Goods goods) throws Exception;
	
	/**
	 * ����Ա�����Ʒ
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	boolean AdminAddGood(Goods goods) throws Exception;
	/**
	 * ����Աת����Ʒ���
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	boolean adminUpdateByTypes(Goods goods) throws Exception;

}
