package com.ssm.po;

import java.util.List;
/**
 * 用于一对多查询用户旗下的订单
 * @author snykt
 *
 */
public class UserPVo extends UserP {
	
	private List<GoodsOrders> lists;

	public List<GoodsOrders> getLists() {
		return lists;
	}

	public void setLists(List<GoodsOrders> lists) {
		this.lists = lists;
	}
	

}
