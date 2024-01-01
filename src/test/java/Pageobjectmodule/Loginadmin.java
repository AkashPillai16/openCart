package Pageobjectmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginadmin extends BasePage {
	
	public Loginadmin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[contains(@class,'ico-login')]")
	WebElement loginbutton1;
//	@FindBy(xpath="//input[(contains(@class,'oxd-input oxd-input--active')) and (contains(@name,'username'))]")
//	WebElement userid;
	@FindBy(xpath="//*[contains(@class,'email')]")
	WebElement userid;
	//WebElement userid=driver.findElement(By.xpath("//div[contains(@class,'desktop-query')]/input"));
	
	
	@FindBy(xpath="//*[contains(@class,'password')]")
	WebElement password;
		
	
	@FindBy(xpath="//*[contains(@class,'button-1 login-button')]")
	WebElement loginButton;
	
	@FindBy(xpath="//*[contains(@id,'RememberMe')]")
	WebElement Rememberme;
	
//	@FindBy(xpath="//form[@class='oxd-form']/div[3]/button")
//	WebElement loginButton;
//	WebElement loginButton=driver.findElement(By.xpath("//form[@class='oxd-form']/div[3]/button"));
//	
	public void  enterUsername(String  userName)
	{
		userid.sendKeys(userName);
	}
	public void  enterPassword(String passwords)
	{
		
		password.sendKeys(passwords);
		
	}
	public void  clicklogin()
	{
		loginbutton1.click();
	}
	
	public void clicksubmit()
	{
		Rememberme.click();
		loginButton.click();
	}
}
