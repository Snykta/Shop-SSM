package com.ssm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ssm.po.GoodsOrders;
public interface OrdersMapper {
	
	int getCount(Integer num) throws Exception;//��ѯ����
	
	/*
	 *
	 * ��ҳ��ѯ
	 */
	List<GoodsOrders> FenyeList(@Param("page")Integer page,@Param("order_userid")Integer order_userid) throws Exception;
	
	/**
	 * ɾ��orders
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int deleteByidOrders(Integer id) throws Exception;
	
	/**
	 * ����
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int PayOrders(Integer id) throws Exception;
	/**
	 * ��������
	 * @param goodsOrders
	 * @return
	 * @throws Exception
	 */
	
	int addOrdersMappers(GoodsOrders goodsOrders) throws Exception;
	
	/**
	 * ����Ա��ѯ��֧��,��֧���ȵ�......��������Ϣ
	 * @return
	 * @throws Exception
	 */
	List<GoodsOrders> adminDaiOrWaitPay(Integer status) throws Exception;
	
	/**
	 * ����Ա��ѯ�ѷ���,δ�����ȵ�......��������Ϣ
	 * @param status
	 * @return
	 * @throws Exception
	 */
	List<GoodsOrders> adminlogisticsWait(String status) throws Exception;
	
	/**
	 * ����Ա����
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int adminFahuoOrders(Integer id) throws Exception;
	
	/**
	 * ����Ա�鿴�û��µĶ���
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<GoodsOrders> adminGetByorder_id(Integer id) throws Exception;

}
