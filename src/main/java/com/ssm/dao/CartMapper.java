package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.po.GoodsCart;

public interface CartMapper {
	/**
	 * 
	 * 	��ӹ��ﳵ
	 * @param cart
	 * @return
	 * @throws Exception
	 */
	int addCart(GoodsCart cart) throws Exception;
	
	/**
	 * �����ֲ�ѯ���ﳵ
	 * @param goods_name
	 * @return
	 * @throws Exception
	 */
	GoodsCart findGetName(@Param("userId")Integer userId,@Param("goods_name")String goods_name) throws Exception;
	
	/**
	 * ��id����
	 * @param cart
	 * @return
	 * @throws Exception
	 */
	int updateByid(GoodsCart cart) throws Exception;
	
	/**
	 * ���û�idչʾ�û����ﳵ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<GoodsCart> findByUserId(Integer id) throws Exception;
	
	/**
	 * ��idɾ�����ﳵ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int delByid(Integer id) throws Exception;
	
	/**
	 * ��id����ɾ��
	 * @param ids
	 * @return
	 */
	int delByIdsArry(String[] ids);

}
