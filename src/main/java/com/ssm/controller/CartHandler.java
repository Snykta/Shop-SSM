package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.po.GoodsCart;
import com.ssm.service.inter.CartServiceInter;

@Controller
public class CartHandler {
	
	@Autowired
	private CartServiceInter cartInter;
	
	
	@RequestMapping("/addCrat.do")
	@ResponseBody
	public String addCrat(GoodsCart cart) throws Exception {		
		return cartInter.addCart(cart);
	}
	
	
	@RequestMapping(value="/getUserIdC.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String getUserIdC(Integer id) throws Exception {
		
		return cartInter.findUserIdC(id);
	}
	
	@RequestMapping(value="/delByid.do")
	@ResponseBody
	public String delByid(Integer id) throws Exception {
		return cartInter.delByid(id);
	}
	
	@RequestMapping(value="/delByIdsA.do")
	@ResponseBody
	public String delByIdsA(String ids) throws Exception {
		return cartInter.delByIdS(ids);
	}

}
