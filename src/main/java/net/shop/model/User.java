package net.shop.model;

public class User {
	private int id;
	private String name;
	private String password;
	private int is_admin;
	
	public User(String name, String password, int is_admin) {
		this.name = name;
		this.password = password;
		this.is_admin = is_admin;
	}
	public User(int id, String name, String password, int is_admin) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.is_admin = is_admin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}

}
