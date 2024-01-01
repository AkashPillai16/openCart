package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjectmodule.HomePage;
import Pageobjectmodule.HomeRegistration;
import testBase.BeforeTCclass;

public class TC_00_AccountRegistration extends BeforeTCclass {
	@Test(groups= {"Sanity","Regression"})
	void Registration() throws InterruptedException
	{
		logger.debug("application logs......");
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");
		//logger.info("Hi this is new Log");
		HomePage page=new HomePage(driver);
		Thread.sleep(3000);
		//page.clickMyaccount();
		Thread.sleep(3000);
		page.clickRegister();
		Thread.sleep(3000);
		logger.info("Clicked on register link");
		HomeRegistration registration = new HomeRegistration(driver);
		registration.FirstName("Akash");
		registration.LastName("Pillai");
		registration.DOB("16","December","1998");
		String  mailbody=randomString()+"@gmail.com";
		//String  mailbody="Pillai.a";
		registration.email(mailbody);
		registration.password("Akash@1234");
		registration.confirmpassword("Akash@1234");
		//registration.clickagree();
		Thread.sleep(5000);
		registration.clickSubmit();
		
		String confirmationmsg=registration.RegistrationStatus();
		Assert.assertEquals(confirmationmsg,"Your registration completed");
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");
		Thread.sleep(5000);
		registration.continuebutton();
	}
	
	
}

