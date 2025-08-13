package practice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException {
		//Read Common data from 
		FileInputStream fis = new FileInputStream("C:\\Users\\SYED KABIR AMMAR\\Desktop\\Data\\Commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String BROWSER = pObj.getProperty("Browser");
		String URL= pObj.getProperty("URL");
		String USERNAME= pObj.getProperty("Username");
		String PASSWORD = pObj.getProperty("Password");
		
		//Generate Random Number
		Random random = new Random();
		int randomInt=random.nextInt(100000);
		
		//Read Test Script Data
		FileInputStream fis1 = new FileInputStream("C:\\Users\\SYED KABIR AMMAR\\Desktop\\Data\\testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		String orgName = row.getCell(2).toString() + randomInt;
		wb.close();
		
		WebDriver driver = null;
		
		if(BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		//Step 1 : Login to app
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 2 : Navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 3: Create new Project by clicking on + button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Enter details
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Verify Header msg Expected Result
		String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header.contains(orgName)) {
			System.out.println(orgName + "is created==PASS");
		}else
		{
			System.out.println(orgName + " is not created==FAIL");
		}
		//Verify Header orgName Info
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + "is Created==PASS");
		}else {
			System.out.println(orgName + "is not Created==Fail");
		}
		
		//Step : Logout
		driver.quit();
	}

}
