package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.po.UserP;
import com.ssm.po.UserPVo;

/**
 * 普通用户接口
 * @author snykt
 *
 */
public interface UserMapper {
	/**
	 * 用户登录dao接口
	 * @param users
	 * @param password
	 * @return
	 * @throws Exception
	 */
	UserP loginUsers(@Param("users") String users,@Param("password") String password) throws Exception;
	
	/**
	 *用户信息修改dao
	 * @param userP
	 * @return
	 * @throws Exception
	 */
	int updateUsers(UserP userP) throws Exception;
	
	/**
	 * 查询单个用户
	 * @param id
	 * @return
	 * @throws Exception
	 */
	UserP getUsersId(Integer id) throws Exception;
	/**
	 * 修该密码
	 * @param userP
	 * @return
	 * @throws Exception
	 */
	int updatePwds(UserP userP) throws Exception;
	
	
	/***
	 * 管理员查询所有用户
	 * @return
	 * @throws Exception
	 */
	List<UserP> AdminGetUser() throws Exception;
	
	/**
	 * 管理员删除会员账号
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int AdminDelsUsers(Integer id) throws Exception;
	/**
	 * 管理员查询用户旗下订单，一对多方式查询
	 * @return
	 * @throws Exception
	 */
	List<UserPVo> AdminOneToManyOrdes() throws Exception;
	
	/**
	 * 普通用户注册
	 * @param userP
	 * @return
	 * @throws Exception
	 */
	int addPlUsers(UserP userP) throws Exception;

}
