package practice.hometest;

import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {

	@Test
	public void homepageTest(Method mtd) {
		
		System.out.println(mtd.getName() + "Test Start");
		SoftAssert assertObj = new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertEquals("Home", "Home");
		System.out.println("Step-3");
		assertObj.assertEquals("Home-CRM", "Home");
		System.out.println("Step-4");
		assertObj.assertAll();
		System.out.println(mtd.getName() + " Test End");
	
		}
	
	@Test
	public void verifyLogoHomePageTest(Method mtd){
		
		System.out.println(mtd.getName() + "Test Start");
				
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertTrue(true);
		System.out.println("Step-3");
		System.out.println("Step-4");
		
		System.out.println(mtd.getName() + " Test End");
		
		}
}
