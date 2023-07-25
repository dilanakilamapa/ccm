package net.shop.model;

public class Item {
	
	private int item_id;
	private String name;
	private double price;
	private int quantity;
	private String employee;
	private int id;
	
	public Item(int item_id, String name, double price, int quantity, String employee, int id) {
		this.item_id = item_id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.employee = employee;
		this.id = id;
	}

	public Item(int item_id, String name, double price, int quantity, String employee) {
		this.item_id = item_id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.employee = employee;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
	

}
