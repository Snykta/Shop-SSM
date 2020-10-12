package com.ssm.service.inter;

import com.ssm.po.GoodsType;

public interface TypeServiceInter {
	
	/**
	 * 首页展示service层
	 * @return
	 * @throws Exception
	 */
	String goodsIndex() throws Exception;
	/**
	 * 管理员删除
	 * @param id
	 * @param shiro_id
	 * @return
	 * @throws Exception
	 */
	String admin_delType(Integer id,Integer shiro_id) throws Exception;
	/**
	 * 管理员添加类别
	 * @param name
	 * @return
	 * @throws Exception
	 */
	boolean AdminAddType(GoodsType type) throws Exception;
	
	/**
	 * 以id查询类别
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String AdminGetIdType(Integer id) throws Exception;
	
	/**
	 * 更新类别
	 * @param type
	 * @return
	 * @throws Exception
	 */
	boolean AdminUpdateTypes(GoodsType type) throws Exception;

}
