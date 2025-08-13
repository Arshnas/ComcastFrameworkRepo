package practicedatadriventesting;


import java.io.FileInputStream;
import java.io.FileReader;

import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ReadDataFromJsonFileTest {

	public static void main(String[] args) throws Throwable{
	
		//Step 1: Parse Json Physical file in to Java object using JsonParse class
		
		JSONParser parser = new JSONParser();
		Object obj=parser.parse(new FileReader(".\\src\\test\\resources\\appCommonData.json"));
		
		//Step 2: Convert java object to JsonObject using downcasting
		JSONObject map = (JSONObject)obj;
		
		
		//Step 3: get the values from Json file using key
		String URL= map.get("URL").toString();
		String BROWSER=map.get("Browser").toString();
		String USERNAME =(String) map.get("Username").toString();
		String PASSWORD=(String) map.get("Password").toString();
		

		//generate the random Number
		Random random = new Random();
		int randomInt = random.nextInt();
		
		//read testscript data from excel file
		FileInputStream fis =new FileInputStream("C:\\Users\\SYED KABIR AMMAR\\Desktop\\Data\\testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		String orgName = row.getCell(2).toString() + randomInt;
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
	
		driver.quit();
		

	}

}
