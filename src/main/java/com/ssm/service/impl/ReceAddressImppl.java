package com.ssm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.ssm.dao.ReceAddressMapper;
import com.ssm.po.ReceAddress;
import com.ssm.service.inter.ReceAddressInter;

public class ReceAddressImppl implements ReceAddressInter {
	
	@Autowired
	private ReceAddressMapper receMapper;

	@Override
	public String getByIdAddress(Integer id) throws Exception {
		ReceAddress address = receMapper.getAddress(id);
		return JSON.toJSONString(address);
	}

	@Override
	public String updateAddress(ReceAddress address) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		if(address==null) {
			map.put("state", "-1");
		}else {
			int num = receMapper.updateAddress(address);
			if(num>0) {
				map.put("state", "1");
			}
		}
		
		return JSON.toJSONString(map);
	}

}
