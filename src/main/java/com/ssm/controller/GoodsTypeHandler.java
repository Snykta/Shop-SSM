package com.ssm.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.po.GoodsType;
import com.ssm.service.inter.TypeServiceInter;

@Controller
public class GoodsTypeHandler {
	@Autowired
	private TypeServiceInter typeInetr;
	
	@RequestMapping(value="/getGoods.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String goodsIndex() throws Exception{
		String goods = typeInetr.goodsIndex();
		return goods;
	}
	
	
	@RequestMapping(value="/del_types.do")
	@ResponseBody
	public String del_types(Integer id,Integer shiro_id) throws Exception{

		return typeInetr.admin_delType(id, shiro_id);
	}
	
	
	@RequestMapping(value="/addType.do")
	public void addType(GoodsType type,HttpServletResponse response) throws Exception{
		boolean flag = typeInetr.AdminAddType(type);
		if(flag) {
			response.sendRedirect("/Shop-SSM/admin/goods_sort.html");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('添加失败！');location.href='/Shop-SSM/admin/add_type.html';</script>");
		}
		
	}
	
	@RequestMapping(value="/AdminGetType.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String AdminGetType(Integer id) throws Exception{

		return typeInetr.AdminGetIdType(id);
	}
	
	
	@RequestMapping(value="/AdminUpdateType.do")
	public void AdminUpdateType(GoodsType type,HttpServletResponse response) throws Exception{
		boolean flag = typeInetr.AdminUpdateTypes(type);
		if(flag) {
			response.sendRedirect("/Shop-SSM/admin/goods_sort.html");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('修改失败！');location.href='/Shop-SSM/admin/goods_sort.html';</script>");
		}
		
	}

}
