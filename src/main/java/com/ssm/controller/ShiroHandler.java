package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.service.inter.ShiroServiceInter;

@Controller
public class ShiroHandler {
	
	@Autowired
	private ShiroServiceInter shiroInter;
	
	@RequestMapping(value="GetsShiros.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String GetsShiros() throws Exception{
		return shiroInter.GetsShiros();
	}
	
	@RequestMapping(value="/updateAdminShiro.do/{shiroId}/{userId}",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String updateAdminShiro(@PathVariable Integer shiroId,@PathVariable Integer userId) throws Exception {
		if(shiroId==null||userId==null) {
			return "<script>alert('非法请求！');location.href='/Shop-SSM/admin/AdminUserShiro.html'</script>";
		}else {
			boolean falg = shiroInter.AdminUpdateShi(shiroId, userId);
			if(falg) {
				return "<script>alert('修改成功');location.href='/Shop-SSM/admin/AdminUserShiro.html'</script>";
			}else {
				return "<script>alert('修改失败');location.href='/Shop-SSM/admin/AdminUserShiro.html'</script>";
			}
		}
	}

}
