package com.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.ssm.dao.GoodsMapper;
import com.ssm.dao.GoodsTypeMapper;
import com.ssm.enums.Shiros;
import com.ssm.po.GoodsList;
import com.ssm.po.GoodsType;
import com.ssm.po.GoodsTypeCustom;
import com.ssm.service.inter.TypeServiceInter;
import com.ssm.util.Time;


public class TypeServiceImpl implements TypeServiceInter {
	
	@Autowired
	private GoodsTypeMapper goodMapper;
	
	@Autowired
	private GoodsMapper goodsMa;;

	@Override
	public String goodsIndex() throws Exception {
		List<GoodsTypeCustom> lists = goodMapper.goodsIndex();
		return JSON.toJSONString(lists);
	}

	@Override
	public String admin_delType(Integer id, Integer shiro_id) throws Exception {
		List<GoodsList> lists = goodsMa.getTypeIdList(id);
		Map<String, String> map = new HashMap<String, String>();
		if(shiro_id!=Shiros.SuperAdmin.getCode()) {
			map.put("state", "-1");
		}else if(lists!=null) {
			map.put("state", "0");
		}else {
			int num = goodMapper.admin_del_type(id);
			if(num>0) {
				map.put("state", "1");
			}
		}
		return JSON.toJSONString(map);
	}

	@Override
	public boolean AdminAddType(GoodsType type) throws Exception {
		
		boolean bol = false;
		type.setDate(Time.getTimes());
		int num =  goodMapper.AdminaddType(type);
		if(num>0) {
			bol = true;
		}else {
			bol = false;
		}
		return bol;
	}

	@Override
	public String AdminGetIdType(Integer id) throws Exception {
		GoodsType type = goodMapper.AdminGetIdType(id);
		
		return JSON.toJSONString(type);
	}

	@Override
	public boolean AdminUpdateTypes(GoodsType type) throws Exception {
		boolean bol = false;
		int num =  goodMapper.AdminUpdateType(type);
		if(num>0) {
			bol = true;
		}else {
			bol = false;
		}
		return bol;
	}

}
