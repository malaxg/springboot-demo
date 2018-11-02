package com.example.demo.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data @Component @ConfigurationProperties(prefix = "girl") public class GirlProperties {

	private String cupSize;
	private int age;
}
