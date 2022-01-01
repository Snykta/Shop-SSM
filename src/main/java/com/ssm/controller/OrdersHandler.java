package com.ssm.controller;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.po.GoodsOrders;
import com.ssm.service.inter.OrdersServiceInter;

@Controller
public class OrdersHandler {
	@Autowired
	private OrdersServiceInter ordersServiceInter;
	
	@RequestMapping("/getCounts.do")
	@ResponseBody
	public String getCounts(Integer num) throws Exception{
		
		return ordersServiceInter.getCounts(num);
	}
	
	@RequestMapping(value="/FenyeLists.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String FenyeLists(Integer page,Integer shiro_id) throws Exception{
		
		return ordersServiceInter.FenyeList(page,shiro_id);
	}
	
	
	@RequestMapping("/delByOrderId.do")
	@ResponseBody
	public String delByOrderId(Integer id) throws Exception{
		
		return ordersServiceInter.delByidOrders(id);
	}
	
	
	@RequestMapping("/pay_order.do")
	@ResponseBody
	public String pay_order(Integer id) throws Exception{
		
		return ordersServiceInter.PayOrders(id);
	}
	
	
	@RequestMapping("/paysDing.do")
	@ResponseBody
	public String paysDing(@RequestBody String lists) throws Exception{
		lists=URLDecoder.decode(lists, "utf-8");//转化，不然会乱码
		return ordersServiceInter.addOrders(lists);
	}
	
	
	@RequestMapping(value="/adminDaiPays.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String adminDaiPays(Integer status) throws Exception {
		return ordersServiceInter.adminDaipays(status);
	}
	
	
	
	@RequestMapping(value="/adminDaiDels.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String adminDaiDels(Integer id,Integer shiro_id) throws Exception {
		if(id==null||shiro_id==null) {
			return "<script>alert('非法请求');location.href='/Shop-SSM/admin/orders_dai.html';</script>";
		}else {
			return ordersServiceInter.adminDelsOrders(id, shiro_id);
		}
		
	}
	
	@RequestMapping(value="/adminlogisticsOrdes.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String adminlogisticsOrdes(String status) throws Exception{
		return ordersServiceInter.adminLogistics(status);
		
	}
	
	@RequestMapping(value="/adminfahuoOrdes.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String adminfahuoOrdes(Integer id) throws Exception{
		if(id==null) {
			return "<script>alert('非法请求');location.href='/Shop-SSM/admin/orders_weifa.html';</script>";
		}else {
			boolean falg = ordersServiceInter.adminFaOrdes(id);
			if(falg) {
				return "<script>alert('发货成功');location.href='/Shop-SSM/admin/orders_weifa.html';</script>";
			}else {
				return "<script>alert('发货失败');location.href='/Shop-SSM/admin/orders_weifa.html';</script>";
			}
		}
	}
	
	
	@RequestMapping(value="/AdminGtByorderId.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String AdminGtByorderId(Integer id) throws Exception{
		return ordersServiceInter.adminGetords(id);
	}

}
