package com.ssm.service.inter;

import java.util.List;

import com.ssm.po.GoodsCart;

public interface CartServiceInter {
	
	String addCart(GoodsCart cart) throws Exception; 
	
	String findUserIdC(Integer id) throws Exception;
	
	String delByid(Integer id)  throws Exception;
	
	String delByIdS(String str);

}
