package com.ssm.po;

public class GoodsCart {
	private int id;
	private String goods_name;
	private String goods_unit;
	private String goods_price;
	private int goods_num;
	private int users_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_unit() {
		return goods_unit;
	}
	public void setGoods_unit(String goods_unit) {
		this.goods_unit = goods_unit;
	}
	public String getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(String goods_price) {
		this.goods_price = goods_price;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	@Override
	public String toString() {
		return "GoodsCart [id=" + id + ", goods_name=" + goods_name + ", goods_unit=" + goods_unit + ", goods_price="
				+ goods_price + ", goods_num=" + goods_num + ", users_id=" + users_id + "]";
	}
	
	

}
