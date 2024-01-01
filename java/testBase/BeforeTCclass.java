package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.apache.logging.log4j.LogManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BeforeTCclass {
	public WebDriver driver;
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		logger=LogManager.getLogger(this.getClass());
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	public  String randomString()
	{
		String generateString=RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}

}
