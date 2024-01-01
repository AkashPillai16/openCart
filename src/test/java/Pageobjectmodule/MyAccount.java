package Pageobjectmodule;

import static org.testng.Assert.assertSame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{

	public MyAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@class='ico-logout']")
	WebElement Logout;
	
	public  String ConfirmLogin()
	{
		
		String logouttext=Logout.getText();
		return logouttext;
		
	}
	public void clicklogout()
	{
		Logout.click();
	}

}
