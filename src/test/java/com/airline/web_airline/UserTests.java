package com.airline.web_airline;

import com.airline.web_airline.model.User;
import com.airline.web_airline.repository.UserRepository;
import com.airline.web_airline.service.UserService;
import com.airline.web_airline.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class UserTests {
	@Mock
	private UserRepository userRepositoryMock;
	//vrem sa testam userservice, deci nu il facem mock
	private UserService userService;

	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		userService = new UserServiceImpl(userRepositoryMock);
	}
	//before - inainte de fiecare test se cheama ce exista in metoda before
	@Test
	public void saveUserTest() {
		User expectedUser = new User(2, "Popa", "Daniela", "daniela92@yahoo.com");
		userService.saveUser(expectedUser);
		verify(userRepositoryMock).save(expectedUser);
	}

	@Test
	public void getUserByIdTest(){
		int id = 2;
		userService.getUserById(id);
		verify(userRepositoryMock).findById(id);
	}

	@Test
	public void deleteUserByIdTest(){
		int id = 2;
		userService.deleteUserById(id);
		verify(userRepositoryMock).deleteById(id);
	}

	@Test
	public void getAllUsersTest(){
		userService.getAllUsers();
		verify(userRepositoryMock).findAll();
	}

}
