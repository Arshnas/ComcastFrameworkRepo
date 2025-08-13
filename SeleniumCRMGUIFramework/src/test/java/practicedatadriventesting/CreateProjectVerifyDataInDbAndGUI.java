package practicedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class CreateProjectVerifyDataInDbAndGUI {
	
	public static void main(String[] args) throws SQLException, Exception {
		//Create Project in GUI
		final Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		String projectName = "Instagram_01";
		boolean flag=false;
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8091/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("Pro_Name19");
		driver.findElement(By.name("createdBy")).sendKeys("Ninja");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement webele = driver.findElement(By.name("teamSize"));
	    js.executeScript("arguments[0].value='100';",webele);
	    WebElement ele = driver.findElement(By.xpath("//label[.='Project Status* ']/following-sibling::select"));    
	   Thread.sleep(2000);
	 
	    Select selobj = new Select(ele);
	    
	   // ele.click();	
	    selobj.selectByIndex(1);
			driver.findElement(By.xpath("//input[@value='Add Project']")).click();
			
			//Verify the project in Backend DB using jdbc
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
			System.out.println("===========Done=========");
			Statement stat = conn.createStatement();
			ResultSet resultset = stat.executeQuery("Select * from project");
			String actProjectName=resultset.getString(4);
			if(projectName.equals(actProjectName)) {
				flag=true;
				System.out.println(projectName + "is available==Pass");
			}
			
			if(flag==false) {
				System.out.println(projectName + "is not available==Fail");
			}
			
				conn.close();
	}

}
