package com.ssm.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssm.po.UserP;

public interface UserServiceInter {
	/**
	 *用户登录service接口
	 * @param users
	 * @param password
	 * @return
	 * @throws Exception
	 */
	String login(String users,String password) throws Exception;
	
	/**
	 * 
	 * 用户信息修改
	 * @param userP
	 * @return
	 * @throws Exception
	 */
	void updateUsers(UserP userP) throws Exception;
	/**
	 * 修改密码
	 * @param userP
	 * @return
	 * @throws Exception
	 */
	String updatePwds(UserP userP,String oldPwd) throws Exception;
	/**
	 *  普通用户注册
	 * @param userP
	 * @return
	 * @throws Exception
	 */
	boolean addPlusers(UserP userP) throws Exception;
	
	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	void longOut(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	/**
	 * 以id查询用户
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String AdminByIdPUser(Integer id) throws Exception;
	
	/**
	 * 管理员查询所有用户
	 * @return
	 * @throws Exception
	 */
	String AdmingetByuser() throws Exception;
	
	/**
	 * 管理员删除会员账号
	 * @return
	 * @throws Exception
	 */
	String AdminDleuser(Integer id,Integer shiro_id) throws Exception;
	/**
	 * 管理员查询用户旗下订单
	 * @return
	 * @throws Exception
	 */
	String adminOnToMantyode() throws Exception;
	

}
