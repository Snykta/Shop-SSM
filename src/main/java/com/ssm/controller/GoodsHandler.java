package com.ssm.controller;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssm.po.Goods;
import com.ssm.service.inter.GoodsServiceInter;

@Controller
public class GoodsHandler {
	
	@Autowired
	private GoodsServiceInter goods;
	
	@RequestMapping(value="getIdGoods.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String getIdGoods(Integer id) throws Exception {
		String gods = goods.getIdGoods(id);
		return gods;
	}
	
	@RequestMapping(value="roundGoods.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String roundGoods() throws Exception {
		return goods.roundGoods();
	}
	
	@RequestMapping(value="getTypeIdlist.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String getTypeIdlist(Integer id) throws Exception {
		String lists = goods.getTypeIdList(id);
		return lists;
	}
	
	
	@RequestMapping(value="getByNames.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String getByNames(String name) throws Exception {
		return goods.secahByBanmes(name);
	}
	
	
	@RequestMapping(value="AdminGetCounts.do")
	@ResponseBody
	public String AdminGetCounts() throws Exception {
		return goods.AdminCounts();
	}
	
	@RequestMapping(value="adminListPage.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String adminListPage(Integer num) throws Exception {
		return goods.AdminManyToOne(num);
	}
	
	
	@RequestMapping(value="adminDelgoods.do")
	@ResponseBody
	public String adminDelgoods(Integer id,Integer shiro_id) throws Exception {
		return goods.AdmindelGoods(id, shiro_id);
	}
	
	@RequestMapping(value="admindelsGood.do")
	@ResponseBody
	public String admindelsGood(String ids,Integer shiro_id) throws Exception {
		return goods.AdminDels(ids, shiro_id);
	}
	
	@RequestMapping("/adminUpdateGoods.do")
	public void adminUpdateGoods(Goods good,HttpServletResponse response) throws Exception{
		boolean falg = goods.AdminupdaGoods(good);
		if(falg) {
			response.sendRedirect("/Shop-SSM/admin/goods_list.html");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('修改失败！');location.href='/Shop-SSM/admin/goods_list.html';</script>");
		}
		
	}
	
	
	@RequestMapping("/AdminaddGoods.do")
	public void AdminaddGoods(Goods good,HttpServletResponse response,MultipartFile imgs) throws Exception{
		String oldImg  = imgs.getOriginalFilename();//获取图片原始名字
		if(imgs!=null && oldImg!=null && oldImg.length()>0) {
			String path = "E:\\apache-tomcat-9.0.11\\webapps\\test\\";
			File file = new File(path+oldImg);
			imgs.transferTo(file);//写入磁盘
			good.setGoods_img(oldImg);//写入同时给图片属性赋值，以便存入数据库
		}
		boolean falg = goods.AdminAddGood(good);
		if(falg) {
			response.sendRedirect("/Shop-SSM/admin/goods_list.html");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('添加失败！');location.href='/Shop-SSM/admin/goods_list.html';</script>");
		}
		
	}
	
	
	@RequestMapping("/adminGoodsBytype.do")
	public void adminGoodsBytype(Goods god,HttpServletResponse response) throws Exception {
		boolean falg = goods.adminUpdateByTypes(god);
		if(falg) {
			response.sendRedirect("/Shop-SSM/admin/goods_type_update.html");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<script>alert('转移失败！');location.href='/Shop-SSM/admin/goods_list.html';</script>");
		}
		
	}
	
	
	

}
