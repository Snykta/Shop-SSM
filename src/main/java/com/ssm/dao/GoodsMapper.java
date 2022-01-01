package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.po.Goods;
import com.ssm.po.GoodsList;
import com.ssm.po.GoodsVo;

public interface GoodsMapper {
	
	/**
	 *  以id查询商品
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Goods getIdGoods(Integer id) throws Exception;
	
	/**
	 * 随机查询两条商品
	 * @return
	 * @throws Exception
	 */
	List<Goods> roundGoods() throws Exception;
	
	/**
	 * 以种类id查询所有商品，用于list页面展示同时分页
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<GoodsList> getTypeIdList(Integer id) throws Exception;

	/**
	 * 模糊查询商品
	 * @param value
	 * @return
	 * @throws Exception
	 */
	List<Goods> searchByName(String value) throws Exception;
	
	/**
	 * 多对一查询
	 * @return
	 * @throws Exception
	 */
	List<GoodsVo> AdminManyToOne(Integer num) throws Exception;
	
	/**
	 * 总数
	 * @return
	 * @throws Exception
	 */
	int Admincounts() throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int AdminDelGoods(Integer id) throws Exception;
	/**
	 * 管理员批量删除商品
	 * @param arryy
	 * @return
	 * @throws Exception
	 */
	int AdminDels(String[] ids) throws Exception;
	
	/**
	 * 管理员修改商品
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	int adminUpdatGoods(Goods goods) throws Exception;
	/**
	 * 管理员添加商品
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	int adminAddGoods(Goods goods) throws Exception;
	
	/**
	 *  管理员转移商品类别
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	int adminUpdateByType(Goods goods) throws Exception;
}
