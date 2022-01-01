package com.ssm.service.inter;

import com.ssm.po.GoodsOrders;

public interface OrdersServiceInter {
	
	String getCounts(Integer num) throws Exception;
	
	/**
	 * 分页查询
	 * @param page
	 * @return
	 * @throws Exception
	 */
	String FenyeList(Integer page,Integer order_userid) throws Exception;
	
	
	String delByidOrders(Integer id) throws Exception;
	
	/**
	 * 付款
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String PayOrders(Integer id) throws Exception;
	
	
	/**
	 * 新增
	 * @param goodsOrders
	 * @return
	 * @throws Exception
	 */
	String addOrders(String lists) throws Exception;
	
	/**
	 * 管理员查询待支付，已支付等等......订单信息
	 * @return
	 * @throws Exception
	 */
	String adminDaipays(Integer status) throws  Exception;
	
	
	/**
	 * 管理员查询已发货，未发货等等......订单信息
	 * @param status
	 * @return
	 * @throws Exception
	 */
	String adminLogistics(String status) throws  Exception;
	
	/**
	 * 管理员删除订单
	 * @param id
	 * @param shiro_id
	 * @return
	 * @throws Exception
	 */
	String adminDelsOrders(Integer id,Integer shiro_id) throws Exception;
	/**
	 * 管理员发货
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean adminFaOrdes(Integer id) throws Exception;
	
	/**
	 * 管理员查看单个用户旗下的订单
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String adminGetords(Integer id) throws Exception;

}
