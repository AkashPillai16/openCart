package testBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BeforeTCclass {
	public static WebDriver driver;
	public Logger logger;
	////public Logger log;
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"Sanity","Regression"})
	public void setup() throws InterruptedException
	{
		rb=ResourceBundle.getBundle("config");
		
		
		logger=LogManager.getLogger(this.getClass());
		
		//WebDriverManager.chromedriver().setup();
		 System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(rb.getString("baseURL"));
		//driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		
	}
	@AfterClass(groups= {"Sanity","Regression"})
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	public  String randomString()
	{
		String generateString=RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}
	public String captureScreen(String  tname) throws IOException
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takeScreenshot=(TakesScreenshot) driver;
		File source=takeScreenshot.getScreenshotAs(OutputType.FILE);
		//String destination=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		System.out.print("Inside  the capture  screen");
		String destination="C:\\Users\\akapilla\\eclipse-workspace\\openCart\\screenshots\\"+tname+"_"+timeStamp+".png";
		//logger.info("***  Name  of  screen  shot  ***"+destination);
		FileUtils.copyFile(source, new File(destination));
		try
		{
			//FileUtils.copyFile(source, new File(destination));
			System.out.print("Inside  the Try");
		}
		catch(Exception e)
		{
			System.out.print("Inside  the catch");
			e.getMessage();
		}
		
		
		return destination;
	}

}
