package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleTestForScreenShot {
	public ExtentReports report;
	

	@Test
	public void amazonTest() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		//Step-1 : Create an object to take Screenshot
		TakesScreenshot ss = (TakesScreenshot)driver;
		
		//Step-2 : Use getScreenshotAs method to get file type of Screenshot
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		
		//Step-3 : Store Screen on local driver
		FileUtils.copyFile(srcFile, new File("./Screenshot/test.png"));
				
	}
	
	
	@BeforeSuite
	public void configBS() {
				//Spark report Config
				ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReport/report.html");
				spark.config().setDocumentTitle("CRM Test Suite Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				
				//add Env information and create Test
				report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS", "Windows-10");
				report.setSystemInfo("BROWSER", "Chrome-100");
		
	}
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	
	@Test
	public void createcontactTest() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://49.249.28.218:8888/");
		TakesScreenshot eDriver = (TakesScreenshot)driver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test= report.createTest("createContactTest");
		
		test.log(Status.INFO,"Login to App");
		test.log(Status.INFO,"Navigate to contact Page");
		test.log(Status.INFO,"Create contact");
		if("HDFdd".equals("HDFC")) {
			test.log(Status.INFO,"Contact is Created");
		}else {
			test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
		}
		driver.close();
	}
}
