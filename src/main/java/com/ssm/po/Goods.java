package com.ssm.po;

public class Goods {
	private int id;
	private String goods_name;
	private String goods_unit;
	private String goods_stock;
	private String goods_price;
	private String goods_present;
	private int goods_type;
	private String goods_img;
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
	public String getGoods_stock() {
		return goods_stock;
	}
	public void setGoods_stock(String goods_stock) {
		this.goods_stock = goods_stock;
	}
	public String getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(String goods_price) {
		this.goods_price = goods_price;
	}
	public String getGoods_present() {
		return goods_present;
	}
	public void setGoods_present(String goods_present) {
		this.goods_present = goods_present;
	}
	public int getGoods_type() {
		return goods_type;
	}
	public void setGoods_type(int goods_type) {
		this.goods_type = goods_type;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", goods_name=" + goods_name + ", goods_unit=" + goods_unit + ", goods_stock="
				+ goods_stock + ", goods_price=" + goods_price + ", goods_present=" + goods_present + ", goods_type="
				+ goods_type + ", goods_img=" + goods_img + "]";
	}
	
	

}
