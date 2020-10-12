package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.po.UserP;
import com.ssm.po.UserPVo;

/**
 * ��ͨ�û��ӿ�
 * @author snykt
 *
 */
public interface UserMapper {
	/**
	 * �û���¼dao�ӿ�
	 * @param users
	 * @param password
	 * @return
	 * @throws Exception
	 */
	UserP loginUsers(@Param("users") String users,@Param("password") String password) throws Exception;
	
	/**
	 * �û���Ϣ�޸�dao
	 * @param userP
	 * @return
	 * @throws Exception
	 */
	int updateUsers(UserP userP) throws Exception;
	
	/**
	 * ��ѯ�����û�
	 * @param id
	 * @return
	 * @throws Exception
	 */
	UserP getUsersId(Integer id) throws Exception;
	/**
	 * �޸�����
	 * @param userP
	 * @return
	 * @throws Exception
	 */
	int updatePwds(UserP userP) throws Exception;
	
	
	/***
	 * ����Ա��ѯ�����û�
	 * @return
	 * @throws Exception
	 */
	List<UserP> AdminGetUser() throws Exception;
	
	/**
	 * ����Աɾ����Ա�˺�
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int AdminDelsUsers(Integer id) throws Exception;
	/**
	 * ����Ա��ѯ�û����¶�����һ�Զ෽ʽ��ѯ
	 * @return
	 * @throws Exception
	 */
	List<UserPVo> AdminOneToManyOrdes() throws Exception;
	
	/**
	 * ��ͨ�û�ע��
	 * @param userP
	 * @return
	 * @throws Exception
	 */
	int addPlUsers(UserP userP) throws Exception;

}
