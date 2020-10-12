package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.po.Goods;
import com.ssm.po.GoodsList;
import com.ssm.po.GoodsVo;

public interface GoodsMapper {
	
	/**
	 * ��id��ѯ��Ʒ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Goods getIdGoods(Integer id) throws Exception;
	
	/**
	 * �����ѯ������Ʒ
	 * @return
	 * @throws Exception
	 */
	List<Goods> roundGoods() throws Exception;
	
	/**
	 * ������id��ѯ������Ʒ������listҳ��չʾͬʱ��ҳ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<GoodsList> getTypeIdList(Integer id) throws Exception;

	/**
	 * ģ����ѯ��Ʒ
	 * @param value
	 * @return
	 * @throws Exception
	 */
	List<Goods> searchByName(String value) throws Exception;
	
	/**
	 * ���һ��ѯ
	 * @return
	 * @throws Exception
	 */
	List<GoodsVo> AdminManyToOne(Integer num) throws Exception;
	
	/**
	 * ����
	 * @return
	 * @throws Exception
	 */
	int Admincounts() throws Exception;
	
	/**
	 * ɾ��
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int AdminDelGoods(Integer id) throws Exception;
	/**
	 * ����Ա����ɾ����Ʒ
	 * @param arryy
	 * @return
	 * @throws Exception
	 */
	int AdminDels(String[] ids) throws Exception;
	
	/**
	 * ����Ա�޸���Ʒ
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	int adminUpdatGoods(Goods goods) throws Exception;
	/**
	 * ����Ա�����Ʒ
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	int adminAddGoods(Goods goods) throws Exception;
	
	/**
	 * ����Աת����Ʒ���
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	int adminUpdateByType(Goods goods) throws Exception;
}
