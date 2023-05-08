package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {
	@GetMapping("/good-morning")
	public ResponseEntity<String> index() {
		if (new Date().getHours() >= 10) {
			return ResponseEntity.internalServerError().body("It's not morning");
		}
		return ResponseEntity.ok("Good Morning");
	}
	@GetMapping("/hello")
	public String exercise1() {
		return "Hello Marco's World";
	}

	@GetMapping("/greeting")
	public ResponseEntity<String> exercise2() {
		return ResponseEntity.status(200).body("Good Afternoon!");
	}

}
