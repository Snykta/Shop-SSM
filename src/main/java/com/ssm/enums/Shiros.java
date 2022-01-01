package com.ssm.enums;

public enum Shiros {
	SuperAdmin(1,"超级管理员"),GeneralAdmin(2,"普通管理员");
	 private int code;
	 private String name;
	private Shiros(int code,String name) {
		this.code = code;
        this.name = name();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
