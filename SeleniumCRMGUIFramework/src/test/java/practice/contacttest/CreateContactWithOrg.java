package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrg {
	public static void main(String[] args) throws IOException {
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
		Sheet sh = wb.getSheet("contacts");
		Row row = sh.getRow(3);
		String orgName = row.getCell(2).toString() + randomInt;
		String lastname = row.getCell(3).toString()+ randomInt;
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
		
		//step 4:Enter details
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
		
		//Step 5 : Navigate to Contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 6: Create new Project by clicking on + button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Step 7: Enter details
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//Switch to child window
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String windowID=it.next();
			driver.switchTo().window(windowID);
           
			String acturl=driver.getCurrentUrl();
			if(acturl.contains("module=Accounts")) {
				break;
				
			}
		}
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		//Switch to Parent-Window
		 Set<String> set1 = driver.getWindowHandles();
		 Iterator<String> it1 = set1.iterator();
		 
		 while(it1.hasNext()) {
			 String windowID1 = it1.next();
			 driver.switchTo().window(windowID1);
			
			 String acturl1=driver.getCurrentUrl();
			 if(acturl1.contains("module=Contacts")) {
			 break;
			 }
		 }
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Verify Header msg Expected Result
		String header1 = driver.findElement(By.className("dvHeaderText")).getText();
		if(header1.contains(lastname)) {
			System.out.println(lastname + "is created==PASS");
		}else
		{
			System.out.println(lastname + " is not created==FAIL");
		}
		//Verify Header lastName Info
		String actLastName = driver.findElement(By.id("mouseArea_Last Name")).getText();
		if(actLastName.trim().equals(lastname)) {
			System.out.println(lastname + "information is Verified==PASS");
		}else {
			System.out.println(lastname + "information is not Verified==Fail");
		}
		
		
		
		
		//Step : Logout
		driver.quit();

		
	}

	
	}


