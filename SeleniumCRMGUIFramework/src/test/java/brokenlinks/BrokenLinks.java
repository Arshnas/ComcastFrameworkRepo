package brokenlinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinks {
	@Test
	public void handleBrokenLinks_Test() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.onlinesbi.sbi/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println(allLinks.size());
		for(WebElement eachLink:allLinks) {
			String link=eachLink.getAttribute("href");
			try {
			URL url = new URL(link);
			HttpURLConnection conn= (HttpURLConnection)url.openConnection();
					int statusCode=conn.getResponseCode();
			if(statusCode>=400) {
				System.out.println(link+"==>"+statusCode);
			}
			}catch(Exception e) {}
			
		}
		driver.quit();
	}
	
}
