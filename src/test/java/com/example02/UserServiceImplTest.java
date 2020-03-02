package com.example02;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gumtree.example02.DbUser;
import com.gumtree.example02.User;
import com.gumtree.example02.UserAdapter;
import com.gumtree.example02.UserAdapterImpl;
import com.gumtree.example02.UserServiceImpl;
import com.gumtree.example02.UsersGateway;

import java.util.NoSuchElementException;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class UserServiceImplTest {

	private UserServiceImpl userService;
	
	@Mock
	private  UsersGateway usersGateway;
	@Mock
	private  UserAdapter userAdapter;
	
	
	@BeforeMethod
	public void setup() {
		MockitoAnnotations.initMocks(this);
		userService = new UserServiceImpl( usersGateway, userAdapter);
		
		}
	
	
	@Test
	public void userAdapterTest() {
		
		DbUser dbUser = new DbUser(1l, null, null, null, null, null, null, null, null, null, false);
		
		Optional<DbUser> db= Optional.of(dbUser);
		
		User user = new User(1l, null, false);
		
		Mockito.when(usersGateway.getById(1l)).thenReturn(db);
		Mockito.when(userAdapter.adapt(dbUser)).thenReturn(user);
		
		Optional<User> response_user = userService.getUser(1l);
		
		Assert.assertNotNull(response_user);
		
		
		

	}
	
}
