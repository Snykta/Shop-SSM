package com.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.ssm.dao.GoodsMapper;
import com.ssm.enums.Shiros;
import com.ssm.po.Goods;
import com.ssm.po.GoodsList;
import com.ssm.service.inter.GoodsServiceInter;


public class GoodsServiceImpl implements GoodsServiceInter {
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public String getIdGoods(Integer id) throws Exception {
		Goods goods = goodsMapper.getIdGoods(id);
		return JSON.toJSONString(goods);
	}

	@Override
	public String roundGoods() throws Exception {
		return JSON.toJSONString(goodsMapper.roundGoods());
	}

	@Override
	public String getTypeIdList(Integer id) throws Exception {
		List<GoodsList> lists =  goodsMapper.getTypeIdList(id);
		return JSON.toJSONString(lists);
	}

	@Override
	public String secahByBanmes(String name) throws Exception {
		List<Goods> lists = goodsMapper.searchByName(name);
		return JSON.toJSONString(lists);
	}

	@Override
	public String AdminManyToOne(Integer num) throws Exception {

		return JSON.toJSONString(goodsMapper.AdminManyToOne(num));
	}

	@Override
	public String AdminCounts() throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("count", goodsMapper.Admincounts());
		return JSON.toJSONString(map);
	}

	@Override
	public String AdmindelGoods(Integer id,Integer shiro_id) throws Exception {
		Map<String, String> map = new  HashMap<String,String>();
		if(shiro_id!=Shiros.SuperAdmin.getCode()) {
			map.put("state", "-1");
		}else {
			int num = goodsMapper.AdminDelGoods(id);
			if(num>0) {
				map.put("state", "1");
			}
		}
		return JSON.toJSONString(map);
	}

	@Override
	public String AdminDels(String ids,Integer shiro_id) throws Exception {
		Map<String, String> map = new  HashMap<String,String>();
		if(shiro_id!=Shiros.SuperAdmin.getCode()) {
			map.put("state", "-1");
		}else {
			String[] id = ids.split(",");
			int num = goodsMapper.AdminDels(id);
			if(num>0) {
				map.put("state", "1");
			}
		}
		return JSON.toJSONString(map);
	}

	@Override
	public boolean AdminupdaGoods(Goods goods) throws Exception {
		boolean bol = false;
		if(goods==null) {
			bol = false;
		}else {
			int num = goodsMapper.adminUpdatGoods(goods);
			if(num>0) {
				bol = true;
			}else {
				bol = false;
			}
		}
		return bol;
	}

	@Override
	public boolean AdminAddGood(Goods goods) throws Exception {
		boolean bol = false;
		if(goods==null||goods.getGoods_name()==null) {
			bol = false;
		}else {
			int num = goodsMapper.adminAddGoods(goods);
			if(num>0) {
				bol = true;
			}else {
				bol = false;
			}
		}
		return bol;
	}

	@Override
	public boolean adminUpdateByTypes(Goods goods) throws Exception {
		boolean bol = false;
		if(goods==null) {
			 bol = false;
		}else {
			int num = goodsMapper.adminUpdateByType(goods);
			if(num>0) {
				bol = true;
			}else {
				bol = false;
			}
		}
		return bol;
	}

}
