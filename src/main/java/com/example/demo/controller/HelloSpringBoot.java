package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController public class HelloSpringBoot {
	@Autowired private GirlProperties girlProperties;
	@GetMapping("/hello") public String helloSpringBoot(@RequestParam(defaultValue = "123") int id) {
		return "hello Spring boot  " + girlProperties.getCupSize() + girlProperties.getAge() + "id=" + id;
	}
}
