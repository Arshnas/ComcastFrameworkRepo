package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test1 {
	
	@Test(dataProvider="getData")
	public void createContact(String firstName, String lastName, long phoneNumber ) {
		System.out.println("FirstName:" +firstName + " LastName:" + lastName + " PhoneNumber:" +phoneNumber);
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr = new Object[3][3];
		objArr[0][0]="Tom";
		objArr[0][1]="Cat";
		objArr[0][2]=9889084328l;
		
		objArr[1][0]="Sam";
		objArr[1][1]="H.D";
		objArr[1][2]=9968713261l;
				
		
		objArr[2][0]="Jhon";
		objArr[2][1]="Stev";
		objArr[2][2]=9782378178l;
				
		return objArr;
	}

}
