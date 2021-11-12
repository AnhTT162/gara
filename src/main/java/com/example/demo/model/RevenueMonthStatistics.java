package com.example.demo.model;

import lombok.Data;

public class RevenueMonthStatistics {
	private String month;
	private float total_money;
	
	public RevenueMonthStatistics(String month, float total_money) {
		super();
		this.month = month;
		this.total_money = total_money;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public float getTotal_money() {
		return total_money;
	}
	public void setTotal_money(float total_money) {
		this.total_money = total_money;
	}
	

}
