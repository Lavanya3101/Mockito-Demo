package com.example.Springboot_Mockito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Springboot_Mockito.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	List<User> findByAddress(String address);

}
