package com.example.demo.test;

import org.springframework.stereotype.Component;

@Component
public class CarFactory {
	private int id;
	private String name;
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
	public int add(int i,int j) {
		return i+j;
	}
}
