package Pageobjectmodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//@FindBy(xpath="//*[@id='top']//*[contains(@class,'fas fa-caret-down')]")
	@FindBy(xpath="//*[@id='top']/div[2]/div[2]/ul/li[2]/div/a/i[2]")
	WebElement lnkMyAccount;
	
	//@FindBy(xpath="//*[@id=\"top\"]//a[contains(@class,\"dropdown-item\") and text()='Register']")
	@FindBy(xpath="//*[@id='top']/div[2]/div[2]/ul/li[2]/div/ul/li[1]/a")
	WebElement Register;
	
	public void  clickMyaccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickRegister()
	{
		Register.click();
	}
}
