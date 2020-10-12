package com.ssm.dao;

import java.util.List;

import com.ssm.po.GoodsType;
import com.ssm.po.GoodsTypeCustom;

public interface GoodsTypeMapper {
	
	/**
	 * ��ҳչʾ
	 * @return
	 * @throws Exception
	 */
	List<GoodsTypeCustom> goodsIndex() throws Exception;
	
	/**
	 * ����Աɾ�����
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int admin_del_type(Integer id) throws Exception;
	
	/**
	 * ����Ա������
	 * @param type_name
	 * @return
	 * @throws Exception
	 */
	int AdminaddType(GoodsType type) throws Exception;
	/**
	 * ��id��ѯ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	GoodsType AdminGetIdType(Integer id) throws Exception;
	/**
	 * ����type
	 * @param type
	 * @return
	 * @throws Exception
	 */
	int AdminUpdateType(GoodsType type) throws Exception;

}
