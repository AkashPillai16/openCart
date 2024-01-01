package testCases;

import org.testng.annotations.Test;

import Pageobjectmodule.HomePage;
import Pageobjectmodule.HomeRegistration;
import testBase.BeforeTCclass;

public class TC_00_AccountRegistration extends BeforeTCclass {
	@Test
	void Registration() throws InterruptedException
	{
		logger.debug("application logs......");
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");

		HomePage page=new HomePage(driver);
		Thread.sleep(3000);
		page.clickMyaccount();
		Thread.sleep(3000);
		page.clickRegister();
		Thread.sleep(3000);
		logger.info("Clicked on register link");
		HomeRegistration registration = new HomeRegistration(driver);
		registration.FirstName("Akash");
		registration.LastName("Pillai");
		String  mailbody=randomString()+"@gmail.com";
		registration.email(mailbody);
		registration.password("Akash@1234");
		//registration.clickagree();
		Thread.sleep(5000);
		registration.clickSubmit();
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");
	}
	
	
}

