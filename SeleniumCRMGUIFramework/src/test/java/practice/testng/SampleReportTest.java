package practice.testng;

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

public class SampleReportTest {
	
	public ExtentReports report;
	
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
		
		ExtentTest test= report.createTest("createContactTest");
		
		test.log(Status.INFO,"Login to App");
		test.log(Status.INFO,"Navigate to contact Page");
		test.log(Status.INFO,"Create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.INFO,"Contact is Created");
		}else {
			test.log(Status.INFO,"Contact is not created");
		}
	}
	
	@Test
	public void createContactWithOrg() {
		
		ExtentTest test= report.createTest("createContactWithOrg");
		
		test.log(Status.INFO,"Login to App");
		test.log(Status.INFO,"Navigate to contact Page");
		test.log(Status.INFO,"Create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.INFO,"Contact is Created");
		}else {
			test.log(Status.INFO,"Contact is not created");
		}
	}
	
	@Test
	public void createcontactWithPhoneNumber() {
		
		ExtentTest test= report.createTest("createcontactWithPhoneNumber");
		
		test.log(Status.INFO,"Login to App");
		test.log(Status.INFO,"Navigate to contact Page");
		test.log(Status.INFO,"Create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.INFO,"Contact is Created");
		}else {
			test.log(Status.INFO,"Contact is not created");
		}
	}
}
