package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DataProvider_Test {

	@Test(dataProvider="getData")
	public void createContact(String firstName, String lastName) {
		System.out.println("FirstName:" +firstName + " LastName:" + lastName);
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr = new Object[3][2];
		objArr[0][0]="Tom";
		objArr[0][1]="Cat";
		
		objArr[1][0]="Sam";
		objArr[1][1]="H.D";
		
		objArr[2][0]="Jhon";
		objArr[2][1]="Stev";
		return objArr;
	}
}
