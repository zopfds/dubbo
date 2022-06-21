package com.example.consmer;

import com.example.provider.TestApi;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConsumerApplication {

	@DubboReference
	private TestApi testApi;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@GetMapping("/test")
	public String get(@RequestParam(name = "name", defaultValue = "peter.pan") String name){
		return testApi.testMethod(name);
	}
}
