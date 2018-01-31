package com.example.demo.test;


import java.io.IOException;

import org.springframework.stereotype.Component;

import com.example.demo.MyAutowired;

@Component
public class CarFactory2 {
	@MyAutowired
	private CarFactory car1;
	private int id;
	private String name;

	public int calculate(int i,int j) {
		return car1.add(i, j);
	}
	public CarFactory getCar1() {
		return car1;
	}
	public void setCar1(CarFactory car1) {
		this.car1 = car1;
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
	public static void main(String[] args) {
		System.out.println("press ENTER to call System.exit() and run the shutdown routine.");  
        try {  
            System.in.read();  
            System.out.println("shutdown");
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        System.exit(0);  
	}
}
