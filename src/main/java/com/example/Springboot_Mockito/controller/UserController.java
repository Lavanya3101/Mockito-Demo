package com.example.Springboot_Mockito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Springboot_Mockito.model.User;
import com.example.Springboot_Mockito.service.UserService;

@RestController
//@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/save")
	public User addUSer(@RequestBody User user) {
		return userService.addUSer(user);
	}
	
	@GetMapping("/getAll")
	public List<User> getAllUSers(){
		return userService.getUsers();
	}
	@GetMapping("/getByAddress/{address}")
	public List<User> getUSerByAddress(@PathVariable String address){
		return userService.getUSerByAddress(address);
	}
	@DeleteMapping("/removeUSer")
	public String deleteUSer(@RequestBody User user) {
		 userService.deleteUSer(user);
		 return "User deleted successfully";
	}

}
