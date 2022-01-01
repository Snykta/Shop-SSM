package com.ssm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ssm.po.GoodsOrders;
public interface OrdersMapper {
	
	int getCount(Integer num) throws Exception;//查询总数
	
	/*
	 *
	 *  分页查询
	 */
	List<GoodsOrders> FenyeList(@Param("page")Integer page,@Param("order_userid")Integer order_userid) throws Exception;
	
	/**
	 * 删除orders
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int deleteByidOrders(Integer id) throws Exception;
	
	/**
	 * 付款
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int PayOrders(Integer id) throws Exception;
	/**
	 *新增订单
	 * @param goodsOrders
	 * @return
	 * @throws Exception
	 */
	
	int addOrdersMappers(GoodsOrders goodsOrders) throws Exception;
	
	/**
	 * 管理员查询待支付,已支付等等......订单的信息
	 * @return
	 * @throws Exception
	 */
	List<GoodsOrders> adminDaiOrWaitPay(Integer status) throws Exception;
	
	/**
	 * 管理员查询已发货,未发货等等......订单的信息
	 * @param status
	 * @return
	 * @throws Exception
	 */
	List<GoodsOrders> adminlogisticsWait(String status) throws Exception;
	
	/**
	 * 管理员发货
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int adminFahuoOrders(Integer id) throws Exception;
	
	/**
	 * 管理员查看用户下的订单
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<GoodsOrders> adminGetByorder_id(Integer id) throws Exception;

}
