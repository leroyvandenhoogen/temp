package nl.rsvier.icaras;

import nl.rsvier.icaras.core.User;
import nl.rsvier.icaras.service.UserService;
import nl.rsvier.icaras.util.PasswordGenerator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:icarastestdb-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class RandomPassTester {

	@Autowired
	UserService userService; 
	
	@Test
	public void generatePass() {
		System.out.println(PasswordGenerator.generate());
	}
	
	@Test
	public void mailTest() {
		User user = new User();
		user.setUsername("");
		user.setEmail("@gmail.com");
		userService.save(user);
	}

}
