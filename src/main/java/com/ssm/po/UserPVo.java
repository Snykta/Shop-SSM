package com.ssm.po;

import java.util.List;
/**
 * ����һ�Զ��ѯ�û����µĶ���
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
