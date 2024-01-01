package Pageobjectmodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomeRegistration extends BasePage{
	
	public HomeRegistration(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//*[contains(@id,'gender-male')]")
	WebElement Male;
	
	@FindBy(xpath="//input[contains(@id,'gender-female')]")
	WebElement Female;
	
	@FindBy(xpath="//*[contains(@id,'FirstName')]")
	WebElement firstName;
	
	@FindBy(xpath="//*[contains(@id,'LastName')]")
	WebElement lastName;
	
	@FindBy(xpath="//*[contains(@name,'DateOfBirthDay')]")
	WebElement birthDate;
	
	@FindBy(xpath="//*[contains(@name,'DateOfBirthMonth')]")
	WebElement birthMonth;
	
	@FindBy(xpath="//*[contains(@name,'DateOfBirthYear')]")
	WebElement birthYear;
	
	@FindBy(xpath="//*[contains(@class,'inputs')]/input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath="//*[contains(@id,'Password')]")
	WebElement password;
	
	@FindBy(xpath="//*[contains(@id,'ConfirmPassword')]")
	WebElement confirmpassword;
	
	@FindBy(xpath="//*[@id='register-button']")
	WebElement RegisterButton;
	
	@FindBy(xpath="//div[@class='result']")
	WebElement status;
	
	@FindBy(xpath="//*[contains(@class,'button-1 register-continue-button')]")
	WebElement continuebtn;
	
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
	public void  DOB(String date,String month,String year)
	{
		Select Date=new Select(birthDate);
		Date.selectByVisibleText(date);
		
		Select Month=new Select(birthMonth);
		Month.selectByVisibleText(month);
		
		Select Year=new Select(birthYear);
		Year.selectByVisibleText(year);
		
	}
	public void password(String psw)
	{
		password.sendKeys(psw);
	}
	public void confirmpassword(String psw)
	{
		confirmpassword.sendKeys(psw);
	}
	public void clickSubmit()
	{
		RegisterButton.click();
	}
	public String  RegistrationStatus()
	{
		try {
			return status.getText();
		}catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	public void continuebutton()
	{
		continuebtn.click();
	}
}
