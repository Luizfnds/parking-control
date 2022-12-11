package com.lefnds.parkingcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ParkingControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingControlApplication.class, args);
	}

	@GetMapping
	@RequestMapping(value = "/")
	public ResponseEntity<String> test() {
		String text = "Test performed successfully!!!!";
		return ResponseEntity.ok().body(text);
	}
}
