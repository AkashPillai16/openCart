package testCases;
import org.testng.annotations.Test;

import Pageobjectmodule.Loginadmin;
import Pageobjectmodule.MyAccount;
import junit.framework.Assert;
import testBase.BeforeTCclass;
import utilities.DataProviders;

public class TC_002_LoginPageDataDrivenTest extends BeforeTCclass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void loginDDT(String email,String pwd,String exp)
	{
		//logger.info("Starting TC  002");
		Loginadmin login2=new Loginadmin(driver);
		login2.clicklogin();
		
		login2.enterUsername(email);
		login2.enterPassword(pwd);
		login2.clicksubmit();
		MyAccount acc=new MyAccount(driver);
		String loginresult=acc.ConfirmLogin();
		if(exp.equals("Valid"))
		{
			if(loginresult.equals("Log out"))
			{
				acc.clicklogout();
				Assert.assertEquals(true, true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equals("Invalid"))
		{
			if(loginresult.equals("Log out"))
			{
				acc.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}

}
