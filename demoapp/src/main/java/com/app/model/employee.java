package com.app.model;

public class employee {
	private int id;
	private String name;
	private String gender;
	
	public employee() {
		
		
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public employee(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}

	public employee(int id, String name, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "employee [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}

}