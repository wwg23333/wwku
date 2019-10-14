package com.gaoyuan.demo.bean;

import java.math.BigDecimal;

public class Goods {
	
	private int gid;
	private String gname;
	private BigDecimal price;
	private double saleBfb;
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public double getSaleBfb() {
		return saleBfb;
	}
	public void setSaleBfb(double saleBfb) {
		this.saleBfb = saleBfb;
	}
	
	
}
