package com.example.consmer;

import com.example.testApi.TestApi;
import com.example.testApi.dto.UserDto;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/user")
public class ConsumerApplication {

	@DubboReference
	private TestApi testApi;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@GetMapping("/test")
	public String getById(){
		return "test";
	}

	@GetMapping("/getById/{id}")
	public UserDto getById(@PathVariable("id") String id){
		return testApi.getById(Long.valueOf(id));
	}

	@PostMapping("/createUser")
	public boolean createUser(@RequestParam UserDto userDto){
		return testApi.insert(userDto) > 0;
	}

	@GetMapping("/getByUserName/{userName}")
	public List<UserDto> getByUserName(@PathVariable("userName") String userName){
		return testApi.getByUserName(userName);
	}

	@GetMapping("/getAllUsers")
	public List<UserDto> getAllUsers(){
		return testApi.getAllUsers();
	}
}
