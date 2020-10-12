package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.ssm.dao.AdminShiro;
import com.ssm.po.AdminShiroS;
import com.ssm.service.inter.ShiroServiceInter;

public class ShiroServiceImpl implements ShiroServiceInter {
	
	@Autowired
	private AdminShiro adminShiro;

	@Override
	public String GetsShiros() throws Exception {
		List<AdminShiroS> lists = adminShiro.ShiroGets();
		
		return JSON.toJSONString(lists);
	}

	@Override
	public boolean AdminUpdateShi(Integer shiroId, Integer userId) throws Exception {
		boolean blo = false;
		if(shiroId==null||userId==null) {
			blo = false;
		}else {
			int num = adminShiro.AdminUpdateShiro(shiroId, userId);
			if(num>0) {
				blo = true;
			}else {
				blo = false;
			}
		}
		
		return blo;
	}

}
