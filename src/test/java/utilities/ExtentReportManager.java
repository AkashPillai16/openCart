package utilities;

import java.util.Date;
import java.util.logging.Logger;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BeforeTCclass;

public class ExtentReportManager implements  ITestListener{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String  repname;
	public void onStart(ITestContext testContext)
	{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repname="TestReport"+timeStamp+".html";
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repname);
		sparkReporter.config().setReportName("nopcommerce Functional Testing");
		sparkReporter.config().setDocumentTitle("nopcommerce Testing Report");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "nopcommerce");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module","Customer");
		extent.setSystemInfo("Operating  System", System.getProperty("os.name"));
		extent.setSystemInfo("Environment", "QA");
		System.out.println("On Test  Start");
	}
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
	
		test.log(Status.PASS, "Pass");
		System.out.println("On Test  PASS");
	}
	
	public void  onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test  Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		System.out.println("On Test  FAIL");
		try
		{
			String imgpath=new BeforeTCclass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		}
		catch(IOException e)
		{
			e.printStackTrace(); 
		}
		System.out.println("On Test  FAIL");
	}
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
		System.out.println("On Test  SKIPPED");
	}
	public  void  onFinish(ITestContext testContext)
	{
		System.out.println("On Test  FINISHED");
		extent.flush();
	}
}
