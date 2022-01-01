package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.po.GoodsCart;

public interface CartMapper {
	/**
	 * 
	 * 	添加购物车
	 * @param cart
	 * @return
	 * @throws Exception
	 */
	int addCart(GoodsCart cart) throws Exception;
	
	/**
	 * 以名字查询购物车
	 * @param goods_name
	 * @return
	 * @throws Exception
	 */
	GoodsCart findGetName(@Param("userId")Integer userId,@Param("goods_name")String goods_name) throws Exception;
	
	/**
	 * 以id更新
	 * @param cart
	 * @return
	 * @throws Exception
	 */
	int updateByid(GoodsCart cart) throws Exception;
	
	/**
	 * 以用户id展示用户购物车
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<GoodsCart> findByUserId(Integer id) throws Exception;
	
	/**
	 * 以id删除购物车
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int delByid(Integer id) throws Exception;
	
	/**
	 * 以id批量删除
	 * @param ids
	 * @return
	 */
	int delByIdsArry(String[] ids);

}
