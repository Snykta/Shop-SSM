package com.ssm.service.inter;

import com.ssm.po.Goods;

public interface GoodsServiceInter {
	/**
	 * 以id查询商品
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String getIdGoods(Integer id) throws Exception;
	/**
	 * 随机产生商品
	 * @return
	 * @throws Exception
	 */
	String roundGoods() throws Exception;
	
	/**
	 * 以种类id查询,同时分页
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String getTypeIdList(Integer id) throws Exception;
	
	/**
	 * 查询商品
	 * @param name
	 * @return
	 * @throws Exception
	 */
	String secahByBanmes(String name) throws Exception;
	
	/**
	 * 多对一查询
	 * @return
	 * @throws Exception
	 */
	String AdminManyToOne(Integer num) throws Exception;
	
	/*
	 * 总数
	 */
	String AdminCounts() throws Exception;
	/**
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String AdmindelGoods(Integer id,Integer shiro_id) throws Exception;
	
	/**
	 *
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	String AdminDels(String ids,Integer shiro_id) throws Exception;
	
	/***
	 *
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	boolean AdminupdaGoods(Goods goods) throws Exception;
	
	/**
	 *
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	boolean AdminAddGood(Goods goods) throws Exception;
	/**
	 *
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	boolean adminUpdateByTypes(Goods goods) throws Exception;

}
