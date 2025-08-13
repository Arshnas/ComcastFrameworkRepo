package brokenlinks;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HandleCalender_Popup {
	
	@Test 
	public void handleCalender_test() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//div[@class='dojWrapper___cfd382']")).click();
		driver.findElement(By.xpath("//span[.='30']")).click();
	}



@Test
public void goibibo_test() {
	String monthAndYear = "December 2025";
	int Date=30;
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	WebDriver driver = new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	driver.get("https://www.goibibo.com/");
	driver.findElement(By.xpath("//span[@role='presentation']")).click();
	driver.findElement(By.xpath("//span[.='Departure']")).click();
	driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")).click();
	for(;;) {
		try {
			driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+Date+"']")).click();
			break;
		}catch(Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
	}

	driver.quit();
}

@Test
public void makemytrip_test() throws Throwable {
	
	//Step 1: Launch the browser 
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	
	//Step2 : Navigate to makemytrip 
	driver.get("https://www.makemytrip.com/");
	
	//Step 3: Close login popup
	driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
	
	//Step 4: From city
	driver.findElement(By.id("fromCity")).click();
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru");
	driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
	
	//Step 5: To city
	driver.findElement(By.xpath("//label[@for='fromCity']")).sendKeys(Keys.TAB);
	driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("New Delhi");
	//driver.findElement(By.xpath("//label[@for='toCity']")).click();
    driver.findElement(By.xpath("//p[.='New Delhi, India']")).click();
    
    //Step 6: Departure date
    //driver.findElement(By.id("departure")).click();
    driver.findElement(By.xpath("//div[.='August 2025']/../descendant::p[.='28']")).click();
    Thread.sleep(2000);
    
    //Step7: return date
   driver.findElement(By.xpath("//p[@data-cy='returnDefaultText']")).click();
  for(;;) {
	  
  try {
   driver.findElement(By.xpath("//div[text()='September']/../following-sibling::div[@class='DayPicker-Body']/descendant::div[@aria-label='Thu Sep 18 2025']")).click();
	break;
      }catch(Exception e) {
	  driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
      }
	}
    Thread.sleep(2000);
  driver.findElement(By.xpath("//span[@class='lbl_input appendBottom5']")).click();
  driver.findElement(By.xpath("//li[@data-cy='adults-2']")).click();
  driver.findElement(By.xpath("//li[@data-cy='children-2']")).click();
  driver.findElement(By.xpath("//li[.='Business']")).click();
  driver.findElement(By.xpath("//button[.='APPLY']")).click();
  driver.findElement(By.xpath("//a[.='Search']")).click();
  
  //driver.quit();
}

@Test
public void irctc_test() {
	
	//Step 1: Launch the browser 
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		//Step2 : Navigate to IRCTC 
		driver.get("https://www.irctc.co.in/");
		
		//Step 3: Handle pop up
		driver.findElement(By.xpath("//button[.='OK']")).click();
		
		//step4: enter origin
		//driver.findElement(By.xpath("//p-autocomplete[@id='origin']")).sendKeys("");
	
}


@Test
public void ksrtc_test(){
	
	//Step 1: Launch the browser 
		    WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();
			
			//Step2 : Navigate to KSRTC 
			driver.get("https://www.ksrtc.in/");
			driver.findElement(By.xpath("//span[.='Select Departure City']")).click();
			driver.findElement(By.xpath("//div[.='Or Select City']/following-sibling::ul/li[.='Bengaluru']")).click();
			driver.findElement(By.xpath("//span[.='Select Destination City']")).click();
			driver.findElement(By.xpath("//div[@id='toCity_chosen']/descendant::li[.='Shimoga']")).click();
			driver.findElement(By.xpath("//label[contains(.,'Departure')]")).click();
		
}
}