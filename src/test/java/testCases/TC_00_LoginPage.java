package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pageobjectmodule.Loginadmin;
import Pageobjectmodule.MyAccount;
import junit.framework.Assert;
import testBase.BeforeTCclass;

public class TC_00_LoginPage extends BeforeTCclass {
	//public  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

	@Test(groups= {"Sanity","Regression"})
	public void login() throws InterruptedException
	{
		
		logger.debug("application logs......");
		logger.info("***  Starting TC_00_Login page ***");
		Thread.sleep(8000);
		Loginadmin login=new Loginadmin(driver);
		//Thread.sleep(5000);
		
		//login.enterUsername("Mens");
		login.clicklogin();
		Thread.sleep(8000);
		login.enterUsername(rb.getString("email"));
		login.enterPassword(rb.getString("password"));
		//login.enterUsername("Mens");
		//login.enterPassword("admin123");
		Thread.sleep(5000);
		login.clicksubmit();
		Thread.sleep(5000);
		String  str=driver.getTitle();
		System.out.println("The title is "+str);
		MyAccount account=new MyAccount(driver);
		String  confirm=account.ConfirmLogin();
		Assert.assertEquals(confirm,"Log out");
		logger.info("Completed");
		account.clicklogout();
	}
	
}
