package Pageobjectmodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeRegistration extends BasePage{
	
	public HomeRegistration(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//*[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//*[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//*[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//*[@id='input-password']")
	WebElement password;
	
	//@FindBy(xpath="//*[@name='agree']")
	@FindBy(xpath="//*[@id='form-register']/div/div/div/input")
	WebElement Policy;

	@FindBy(xpath="//*[@class='btn btn-primary']")
	WebElement submit;
	
	public void FirstName(String Fname)
	{
		firstName.sendKeys(Fname);
	}
	
	public void LastName(String Lname)
	{
		lastName.sendKeys(Lname);
	}
	public void email(String Myemail)
	{
		email.sendKeys(Myemail);
	}
	public void password(String psw)
	{
		password.sendKeys(psw);
	}
	public void  clickagree()
	{
		Policy.click();
	}
	public void clickSubmit()
	{
		submit.click();
	}
}
