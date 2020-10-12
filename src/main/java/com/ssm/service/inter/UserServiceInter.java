package com.ssm.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssm.po.UserP;

public interface UserServiceInter {
	/**
	 * �û���¼service�ӿ�
	 * @param users
	 * @param password
	 * @return
	 * @throws Exception
	 */
	String login(String users,String password) throws Exception;
	
	/**
	 * 
	 * �û���Ϣ�޸�
	 * @param userP
	 * @return
	 * @throws Exception
	 */
	void updateUsers(UserP userP) throws Exception;
	/**
	 * �޸�����
	 * @param userP
	 * @return
	 * @throws Exception
	 */
	String updatePwds(UserP userP,String oldPwd) throws Exception;
	/**
	 * ��ͨ�û�ע��
	 * @param userP
	 * @return
	 * @throws Exception
	 */
	boolean addPlusers(UserP userP) throws Exception;
	
	/**
	 * �˳���¼
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	void longOut(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	/**
	 * ��id��ѯ�û�
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String AdminByIdPUser(Integer id) throws Exception;
	
	/**
	 * ����Ա��ѯ�����û�
	 * @return
	 * @throws Exception
	 */
	String AdmingetByuser() throws Exception;
	
	/**
	 * ����Աɾ����Ա�˺�
	 * @return
	 * @throws Exception
	 */
	String AdminDleuser(Integer id,Integer shiro_id) throws Exception;
	/**
	 * ����Ա��ѯ�û����¶���
	 * @return
	 * @throws Exception
	 */
	String adminOnToMantyode() throws Exception;
	

}
