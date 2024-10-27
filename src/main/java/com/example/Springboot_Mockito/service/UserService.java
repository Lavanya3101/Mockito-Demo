package com.example.Springboot_Mockito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Springboot_Mockito.model.User;
import com.example.Springboot_Mockito.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User addUSer(User user) {
		return userRepository.save(user);
	}
	public List<User> getUsers(){
		List<User>users=userRepository.findAll();
		System.out.println("getting data from db:"+users);
		return users;
	}
	public List<User> getUSerByAddress(String address){
		return userRepository.findByAddress(address);
	}
	public void deleteUSer(User user) {
		userRepository.delete(user);
	}

}
