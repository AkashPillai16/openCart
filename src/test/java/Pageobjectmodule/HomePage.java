package Pageobjectmodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[contains(@class,'oxd-input oxd-input--active')]")
	WebElement Login;
	
	//@FindBy(xpath="//*[@id=\"top\"]//a[contains(@class,\"dropdown-item\") and text()='Register']")
	@FindBy(xpath="//*[contains(@class,'ico-register')]")
	WebElement Register;
	
	public void  Login()
	{
		Login.click();
	}
	
	public void clickRegister()
	{
		Register.click();
	}
}
