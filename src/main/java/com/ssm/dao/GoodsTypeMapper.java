package com.ssm.dao;

import java.util.List;

import com.ssm.po.GoodsType;
import com.ssm.po.GoodsTypeCustom;

public interface GoodsTypeMapper {
	
	/**
	 * 首页展示
	 * @return
	 * @throws Exception
	 */
	List<GoodsTypeCustom> goodsIndex() throws Exception;
	
	/**
	 * 管理员删除类别
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int admin_del_type(Integer id) throws Exception;
	
	/**
	 * 管理员添加类别
	 * @param type_name
	 * @return
	 * @throws Exception
	 */
	int AdminaddType(GoodsType type) throws Exception;
	/**
	 * 以id查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	GoodsType AdminGetIdType(Integer id) throws Exception;
	/**
	 * 更新type
	 * @param type
	 * @return
	 * @throws Exception
	 */
	int AdminUpdateType(GoodsType type) throws Exception;

}
