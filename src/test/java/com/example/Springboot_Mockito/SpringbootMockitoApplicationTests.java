package com.example.Springboot_Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import com.example.Springboot_Mockito.model.User;
import com.example.Springboot_Mockito.repository.UserRepository;
import com.example.Springboot_Mockito.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootMockitoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private UserService service;
	@MockBean
	private UserRepository repository;
	@Test
	public void getUSersTest() {
		when(repository.findAll()).thenReturn(Stream.of(new User(320,"John",25,"tpt"),new User(400,"vela",27,"tpt")).collect(Collectors.toList()));
	assertEquals(2, service.getUsers().size());
	}
	@Test
	public void getUserByAddressTest() {
		String address="AP";
		when(repository.findByAddress(address)).thenReturn(Stream.of(new User(320,"Josh",25,"Ctr")).collect(Collectors.toList()));
		assertEquals(1, service.getUSerByAddress(address).size());
	}
	
	@Test
	public void saveUserTest() {
		User user=new User(500,"Peter",30,"Klr");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addUSer(user));
	}
	@Test
	public void deleteUSerTest() {
		User user=new User(500,"Peter",30,"Klr");
		service.deleteUSer(user);
		verify(repository, times(1)).delete(user);
		
	}

}
