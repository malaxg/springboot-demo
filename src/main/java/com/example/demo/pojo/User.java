package com.example.demo.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data @Entity public class User {

	@Id @GeneratedValue private int id;
	private String name;
	private int age;
	private String loginAccout;
	private String address;

	public User() {
	}
}
