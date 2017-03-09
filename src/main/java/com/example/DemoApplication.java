package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@SpringBootApplication
public class DemoApplication {

    @Autowired
    private Repository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public String test() throws Exception {
		List<Hello> hellos = repository.listHellos();
		return "Hello Heroku test!!! hellos.size: " + hellos.size();
	}

	@GetMapping("/hello/{helloId}")
	public String test(@PathVariable long helloId) throws Exception {
		Hello hello = repository.getHello(helloId);
		return hello.text;
	}

    @GetMapping("/dbtest")
    public String testDb() throws SQLException {
        return repository.testDb();
    }
}
