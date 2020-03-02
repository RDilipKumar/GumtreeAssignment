package com.example02;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gumtree.example02.DbUser;
import com.gumtree.example02.User;
import com.gumtree.example02.UserAdapterImpl;
import com.gumtree.example03.gateway.AdvertsRepository;
import com.gumtree.example03.gateway.UsersRepository;
import com.gumtree.example03.model.Advert;
import com.gumtree.example03.service.AdvertServiceImpl;
import com.gumtree.example03.service.UserServiceImpl;


public class UserAdapterImplTest {

	private UserAdapterImpl userAdapt;
	
	
	//@Mock
	   //AdvertsGateway advertGateway;
		
		//@Mock
		//UserService userService;
	
	@BeforeMethod
	public void setup() {
		userAdapt = new UserAdapterImpl();
		MockitoAnnotations.initMocks(this);
		}
	
	@Test
	public void verifyingGetAdvertValidTest() {
		
//		Advert advert = new Advert(1l, 1l, "test", false);
		//List<Advert> list = new ArrayList<Advert>();
		
		//list.add(advert);
		//Mockito.when(advertGateway.getAll()).thenReturn(list);
		
		//User user = new User(1l, "user", false);
		DbUser dbUser = new DbUser(0, null, null, null, null, null, null, null, null, null, false);
		
		User user = userAdapt.adapt(dbUser);
		
		Assert.assertNotNull(user);
//		advertService = new AdvertServiceImpl(userService, advertsRepository);
////		advertsRepository.updateAdvert(advert);
//		List<Advert> result= advertService.getAdverts(1l);
//		
//		for( Advert ad : result ) {
//			System.out.println(ad);
//		}
//		

	}

}
