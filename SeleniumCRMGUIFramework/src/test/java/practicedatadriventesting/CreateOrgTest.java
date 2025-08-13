package practicedatadriventesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {
	
	public static void main(String[] args) throws Throwable {
		//Read data from properties file
		FileInputStream fis = new FileInputStream("./src/test/resources/Commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String BROWSER =pObj.getProperty("Browser");
		String URL = pObj.getProperty("URL");
		String USERNAME =pObj.getProperty("Username");
		String PASSWORD = pObj.getProperty("Password");
		
//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter a Browser");
//		String browser = s.next();
//		Automation should not have and manual intervention so will not use above approach
		//SO IN CONDITION INSTEAD OF browser we use BROWSER variable
		
		//Generate Random Number
		Random random = new Random();
		 int randomInt = random.nextInt(10000);
				 
		FileInputStream fis1 = new FileInputStream("./src/test/resources/testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		String orgName=row.getCell(2).toString() + randomInt ;
		System.out.println(orgName);
		wb.close();
		
		
		
		
		WebDriver driver= null;
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		//WebDriver driver = new ChromeDriver();
		
		//Step 1 : login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 2:Navigate to Organization module
		driver.findElement(By.linkText("Organizations")).click();
	
	   // Step 3 : Click on "Create Organization" Button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 4: Enter all details and Create Organization
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 5 : logout
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
			}
	

}
