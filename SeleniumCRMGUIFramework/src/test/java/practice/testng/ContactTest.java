package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {
	
	@Test//(priority = 1)
	public void createContactTest() {
		System.out.println("Execute createContactTest with -->HDFC");
	}

	@Test(dependsOnMethods="createContactTest")//(priority = 2)
	public void modifyContactTest() {
		//System.out.println("Create Contact ICICI");
		//System.out.println("Execute query insert contact in DB==>ICICI");
		//System.out.println("Execute modifyContactTest-->ICICI=>ICICI_1");
		System.out.println("Execute modifyContactTest-->HDFC=>ICICI");
	}
	
		@Test(dependsOnMethods="modifyContactTest")//(priority = 3)
		public void deleteContactTest() {
			//System.out.println("Create Contact UPI"); As creation of account will take longer
			//System.out.println("Execute query insert contact in DB==>UPI");
			//System.out.println("Execute deleteContactTest --> UPI");	
			System.out.println("Execute deleteCOntactTest-->ICICI");
	}
}
