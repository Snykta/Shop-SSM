package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.po.ReceAddress;
import com.ssm.service.inter.ReceAddressInter;

@Controller
public class ReceAddressHandler {
	@Autowired
	private ReceAddressInter receAddress;

	
	@RequestMapping(value="/getByIdaddress.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String getByIdAddress(Integer id) throws Exception{
		String address = receAddress.getByIdAddress(id);
		return address;
	}
	
	@RequestMapping("/updateAddress.do")
	@ResponseBody
	public String updateAddress(ReceAddress address)throws Exception {
		String ads = receAddress.updateAddress(address);
	    return ads;
	}
}
