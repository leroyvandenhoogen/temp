package nl.rsvier.icaras;

import nl.rsvier.icaras.util.MailMail;
import nl.rsvier.icaras.util.PasswordGenerator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:icarastestdb-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class RandomPassTester {

	@Test
	public void generatePass() {
		System.out.println(PasswordGenerator.generate());
	}
	
	@Test
	public void mailTest() {
		{
	    	ApplicationContext context = 
	             new ClassPathXmlApplicationContext("Spring-Mail.xml");
	 
	    	MailMail mm = (MailMail) context.getBean("mailMail");
	        mm.sendMail("icaras@rsvier.nl",
	    		   "@gmail.com",
	    		   "Testing123", 
	    		   "Testing only \n\n Hello Spring Email Sender");
	 
	    }
	}

}
