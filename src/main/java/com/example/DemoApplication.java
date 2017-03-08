package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@SpringBootApplication
public class DemoApplication {

    @Autowired
    private Repository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public String test() {

		return "Hello Heroku test!";
	}

    @GetMapping("/dbtest")
    public String testDb() throws SQLException {
        return repository.testDb();
    }
}
