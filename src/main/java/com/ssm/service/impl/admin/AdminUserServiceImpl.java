package com.ssm.service.impl.admin;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.dao.AdminUserMapper;
import com.ssm.po.AdminUser;
import com.ssm.po.AdminUserOV;
import com.ssm.service.inter.admin.AdminUserServiceInter;

public class AdminUserServiceImpl implements AdminUserServiceInter{
	
	@Autowired
	private AdminUserMapper adminMapper;

	@Override
	public boolean adminLogin(AdminUser adminUser) throws Exception {
		boolean blo = false;
		AdminUser user = adminMapper.adminLogin(adminUser);
		if(user!=null) {
			blo = true;
			String jsonUser = JSONObject.toJSONString(user);
			System.out.println(jsonUser);
			Cookie cookies = new Cookie("admin-users", java.net.URLEncoder.encode(jsonUser, "UTF-8"));
			HttpServletResponse response =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
			response.addCookie(cookies);
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			request.getSession().setAttribute("admin-users", jsonUser);
		}else {
			return false;
		}
		return blo;
	}

	@Override
	public void LoginOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session =  request.getSession();
		session.removeAttribute("admin-users");
		session.invalidate();
		 Cookie[] cookies = request.getCookies();
		 //ѭ��ɾ��cookie
			for(Cookie ck : cookies) {
				ck.setMaxAge(0);
				response.addCookie(ck);
			}
	}

	@Override
	public String GetAdmins() throws Exception {
		List<AdminUserOV> lists = adminMapper.GetAdmin();
		return JSON.toJSONString(lists);
	}

}
