package com.example03;

import java.util.List;
import java.util.NoSuchElementException;

import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gumtree.example03.gateway.AdvertsGateway;
import com.gumtree.example03.gateway.AdvertsRepository;
import com.gumtree.example03.gateway.UsersGateway;
import com.gumtree.example03.gateway.UsersRepository;
import com.gumtree.example03.model.Advert;
import com.gumtree.example03.service.AdvertServiceImpl;
import com.gumtree.example03.service.UserAdapter;
import com.gumtree.example03.service.UserAdapterImpl;
import com.gumtree.example03.service.UserService;
import com.gumtree.example03.service.UserServiceImpl;

public class AdvertServiceImplTest {

	AdvertServiceImpl advertService;
	
	AdvertsGateway advertsRepository;
	
	UsersGateway usersRepository;
	
	UserAdapter userAdapter;
	
	UserService userService;
	
	
	@BeforeMethod
	public void setup() {
		advertsRepository = new AdvertsRepository();
		usersRepository = new UsersRepository();
		userAdapter = new UserAdapterImpl(); 
		userService = new UserServiceImpl(usersRepository,userAdapter);
		MockitoAnnotations.initMocks(this);
		}
	
	@Test
	public void verifyingGetAdvertValidTest() {
		
		advertService = new AdvertServiceImpl(userService, advertsRepository);

		List<Advert> result= advertService.getAdverts(1l);
		
		for( Advert ad : result ) {
			System.out.println(ad);
		}
		
		
		System.out.println(result);
		
		Assert.assertEquals(5, result.size());
	}
	
	@Test
	public void verifyingGetAdvertInvalidTest() {
		
		advertService = new AdvertServiceImpl(userService, advertsRepository);
		
		List<Advert> result= advertService.getAdverts(11l);
		
		for( Advert ad : result ) {
			System.out.println(ad);
		}
		
		Assert.assertEquals(0, result.size());
		
	}
	
	@Test 
	public void canRepostForFreeNonExpiredAdAsTrueCheckTest() {
			
		advertService = new AdvertServiceImpl(userService, advertsRepository);
		
		boolean result= advertService.canRepostForFree(9l);
		
		Assert.assertTrue(result);
		
	}
	
	@Test 
	public void canRepostForFreeNonExpiredAdAsFalseCheckTest() {
			
		advertService = new AdvertServiceImpl(userService, advertsRepository);
		
		boolean result= advertService.canRepostForFree(2l);

		Assert.assertFalse(result);
		
	}
	
	
	@Test(expectedExceptions = NoSuchElementException.class)
	public void canRepostForFreeAdvertNotFoundExceptionTest() {
			
		advertService = new AdvertServiceImpl(userService, advertsRepository);
		
		boolean result= advertService.canRepostForFree(11l);
		
		System.out.println(result);
		
		Assert.assertTrue(result);
		
	}
	
	@Test(expectedExceptions = NoSuchElementException.class)
	public void canRepostForFreeUserNotFoundExceptionTest() {
		
		Advert advert = new Advert(11l, 11l, "test", false);
		advertService = new AdvertServiceImpl(userService, advertsRepository);
		advertsRepository.updateAdvert(advert);
		
		boolean result= advertService.canRepostForFree(11l);
		
		System.out.println(result);
		
		Assert.assertTrue(result);
		
	}
	
	@Test 
	public void canRepostForFreeFalseCheckTest() {
			
		advertService = new AdvertServiceImpl(userService, advertsRepository);
		
		boolean result= advertService.canRepostForFree(1l);
		
		System.out.println(result);
		
		Assert.assertFalse(result);
		
	}
	
	@Test
	public void verifyingUpdateAdvertListTest() {
		
		Advert advert = new Advert(11l, 11l, "test", false);

		
		advertService = new AdvertServiceImpl(userService, advertsRepository);
		advertsRepository.updateAdvert(advert);
		List<Advert> result= advertService.getAdverts(11l);
		
		Assert.assertEquals(1, result.size());
	}
	
	@Test(expectedExceptions = IllegalStateException.class)
	public void repostForFreeTest() {
		
		advertService = new AdvertServiceImpl(userService, advertsRepository);
		advertService.repostForFree(4l);		
	}
	
}
