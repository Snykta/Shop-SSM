package com.ssm.service.impl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.dao.ReceAddressMapper;
import com.ssm.dao.UserMapper;
import com.ssm.enums.Shiros;
import com.ssm.po.UserP;
import com.ssm.po.UserPVo;
import com.ssm.service.inter.UserServiceInter;

public class UserServiceImpl implements UserServiceInter {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ReceAddressMapper receMapper;

	@Override
	public String login(String users, String password) throws Exception {
		Map<String, String> map = new HashMap<String,String>();
		UserP userP = userMapper.loginUsers(users, password);
		if(userP!=null) {
			map.put("state", "1");
			String jsonUser = JSONObject.toJSONString(userP);
			System.out.println(jsonUser);
			Cookie cookies = new Cookie("shop-users", java.net.URLEncoder.encode(jsonUser, "UTF-8"));
			HttpServletResponse response =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
			response.addCookie(cookies);
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			request.getSession().setAttribute("shop-users", jsonUser);
		}else {
			map.put("state", "-1");
		}
		return JSON.toJSONString(map);
	}

	@Override
	public void updateUsers(UserP userP) throws Exception {
		if(userP==null) {
			return;
		}else {
			int num = userMapper.updateUsers(userP);
			if(num>0) {
				String jsonUser = JSONObject.toJSONString(userMapper.getUsersId(userP.getId()));
				Cookie cookies = new Cookie("shop-users", java.net.URLEncoder.encode(jsonUser, "UTF-8"));
				HttpServletResponse response =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
				response.addCookie(cookies);
			}
		}
		
		
	}

	@Override
	public String updatePwds(UserP userP,String oldPwd) throws Exception {
		Map<String, String> map = new HashMap<String,String>();
		if(userP==null) {
			map.put("state", "-1");
		}else {
			UserP p = userMapper.getUsersId(userP.getId());	
			if(!oldPwd.equals(p.getPassword())) {
				map.put("state", "0");
			}else {
				int num = userMapper.updatePwds(userP);
				if(num>0) {
					map.put("state", "1");
				}
			}
		}
		return JSON.toJSONString(map);
	}

	@Override
	public void longOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session =  request.getSession();
		session.removeAttribute("shop-users");
		session.invalidate();
		 Cookie[] cookies = request.getCookies();
		 //ѭ��ɾ��cookie
			for(Cookie ck : cookies) {
				ck.setMaxAge(0);
				response.addCookie(ck);
			}
	}

	@Override
	public String AdminByIdPUser(Integer id) throws Exception {
		UserP userP = userMapper.getUsersId(id);
		return JSON.toJSONString(userP);
	}

	@Override
	public String AdmingetByuser() throws Exception {
		List<UserP> lists = userMapper.AdminGetUser();
		return JSON.toJSONString(lists);
	}

	@Override
	public String AdminDleuser(Integer id,Integer shiro_id) throws Exception {
		Map<String, String> map = new HashMap<String,String>();
		if(shiro_id!=Shiros.SuperAdmin.getCode()) {
			map.put("state", "-1");
		}else {
			int num = userMapper.AdminDelsUsers(id);
			if(num>0) {
				map.put("state", "1");
			}else {
				map.put("state", "0");
			}
		}
		return JSON.toJSONString(map);
	}

	@Override
	public String adminOnToMantyode() throws Exception {
		List<UserPVo> list = userMapper.AdminOneToManyOrdes();
		return JSON.toJSONString(list);
	}

	@Override
	public boolean addPlusers(UserP userP) throws Exception {
		boolean bol = false;
		int num = userMapper.addPlUsers(userP);
		if(num>0) {
			bol = true;
			receMapper.addAddress(userP.getId());
		}else {
			bol = false;
		}
		return bol;
	}



}
