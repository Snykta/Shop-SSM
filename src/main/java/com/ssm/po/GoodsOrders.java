package com.ssm.po;

public class GoodsOrders {
	private int id;
	private int order_userid;
	private String address;
	private String pay_type;
	private String goods_name;
	private int goods_num;
	private String goods_price;
	private String order_date;
	private int order_succ;
	private String order_counts;
	private int order_code;
	private String order_state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrder_userid() {
		return order_userid;
	}
	public void setOrder_userid(int order_userid) {
		this.order_userid = order_userid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}
	public String getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(String goods_price) {
		this.goods_price = goods_price;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getOrder_succ() {
		return order_succ;
	}
	public void setOrder_succ(int order_succ) {
		this.order_succ = order_succ;
	}
	public int getOrder_code() {
		return order_code;
	}
	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}
	public String getOrder_counts() {
		return order_counts;
	}
	public void setOrder_counts(String order_counts) {
		this.order_counts = order_counts;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	@Override
	public String toString() {
		return "GoodsOrders [id=" + id + ", order_userid=" + order_userid + ", address=" + address + ", pay_type="
				+ pay_type + ", goods_name=" + goods_name + ", goods_num=" + goods_num + ", goods_price=" + goods_price
				+ ", order_date=" + order_date + ", order_succ=" + order_succ + ", order_counts=" + order_counts
				+ ", order_code=" + order_code + ", order_state=" + order_state + "]";
	}
	
	

}
