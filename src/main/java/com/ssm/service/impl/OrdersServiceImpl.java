package com.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ssm.dao.OrdersMapper;
import com.ssm.enums.Shiros;
import com.ssm.po.GoodsOrders;
import com.ssm.service.inter.OrdersServiceInter;
import com.ssm.util.Time;

public class OrdersServiceImpl implements OrdersServiceInter {
	
	@Autowired
	private OrdersMapper orderMapper;

	@Override
	public String getCounts(Integer num) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("state", orderMapper.getCount(num));
		return JSON.toJSONString(map);
	}

	@Override
	public String FenyeList(Integer page,Integer shiro_id) throws Exception {
		List<GoodsOrders> lists = orderMapper.FenyeList(page, shiro_id);
		return JSON.toJSONString(lists);
	}

	@Override
	public String delByidOrders(Integer id) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		int num = orderMapper.deleteByidOrders(id);
		if(num>0) {
			map.put("state", "1");
		}else {
			map.put("state", "-1");
		}
		return JSON.toJSONString(map);
	}

	@Override
	public String PayOrders(Integer id) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		int num = orderMapper.PayOrders(id);
		if(num>0) {
			map.put("state", "1");
		}else {
			map.put("state", "-1");
		}
		return JSON.toJSONString(map);
	}

	@Override
	public String addOrders(String lists) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		
		 String jsonSubStr = lists.substring(6, lists.length());
		 int sum = 1;
		 JSONArray array = JSONArray.parseArray(jsonSubStr);
		 for(int i=0;i<array.size();i++) {
			 JSONObject userJson = JSONObject.parseObject(array.getString(i));
			 GoodsOrders goodsOrders = JSON.toJavaObject(userJson,GoodsOrders.class);
			 goodsOrders.setOrder_date(Time.getTimes());
			 goodsOrders.setOrder_code(Time.getTimeCode());
			 goodsOrders.setOrder_state("未发货");//默认未发货
			  int num = orderMapper.addOrdersMappers(goodsOrders);
			  sum = 1*num;
		 }
		
		if(sum>0) {
			map.put("state", "1");
		}else {
			map.put("state", "-1");
		}
		return JSON.toJSONString(map);
	}

	@Override
	public String adminDaipays(Integer status) throws Exception {
		List<GoodsOrders> lists = orderMapper.adminDaiOrWaitPay(status);
		return JSON.toJSONString(lists);
	}

	@Override
	public String adminDelsOrders(Integer id, Integer shiro_id) throws Exception {
		
		Map<String, String> map = new HashMap<String,String>();
		if(shiro_id!=Shiros.SuperAdmin.getCode()) {
			map.put("state", "-1");//权限不够
		}else {
			int num = orderMapper.deleteByidOrders(id);
			if(num>0) {
				map.put("state", "1");//删除成功
			}
		}
		return JSON.toJSONString(map);
	}

	@Override
	public String adminLogistics(String status) throws Exception {
		List<GoodsOrders> lists = orderMapper.adminlogisticsWait(status);
		return JSON.toJSONString(lists);
	}

	@Override
	public boolean adminFaOrdes(Integer id) throws Exception {
		boolean bol = false;
		if(id==null) {
			bol = false;
		}else {
			int num = orderMapper.adminFahuoOrders(id);
			if(num>0) {
				 bol = true;
			}else {
				bol = false;
			}
		}
		return bol;
	}

	@Override
	public String adminGetords(Integer id) throws Exception {
		List<GoodsOrders> lists = orderMapper.adminGetByorder_id(id);
		return JSON.toJSONString(lists);
	}

}
