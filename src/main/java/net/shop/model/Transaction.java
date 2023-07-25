package net.shop.model;

import java.util.Date;

public class Transaction {
	private int id;
	private String type;
	private int item_id;
	private String item_name;
	private String employee_name;
	private Date date;
	private Double price;
	
	public Transaction(int id, String type, int item_id, String item_name, String employee_name, Date date,
			Double price) {
		this.id = id;
		this.type = type;
		this.item_id = item_id;
		this.item_name = item_name;
		this.employee_name = employee_name;
		this.date = date;
		this.price = price;
	}

	public Transaction(String type, int item_id, String item_name, String employee_name,  Double price) {
		this.type = type;
		this.item_id = item_id;
		this.item_name = item_name;
		this.employee_name = employee_name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
