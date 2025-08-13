package practicedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckProjectInBackEnd {

	@Test
	public void projectCheckTest() throws SQLException {
		String expectedProjectName = "FB_09";
		boolean flag = false;
		
		//Step 1 : Load /register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2:  Connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		System.out.println("================Done==============");
		
		//Step 3: Create SQL statement
		Statement stat = conn.createStatement();
		
		//Step 4: Execute Select query and get Result
	     ResultSet resultset = stat.executeQuery("Select * from project");
	   	 resultset.next();
	   	 while(resultset.next()) {
	     String actProjectName=resultset.getString(4);
	    if(expectedProjectName.equals(actProjectName)) {
	    	flag=true;
	    	System.out.println(expectedProjectName + "is available==Pass");
	    }
	   	 }
	   	 if(flag==false) {
	   		 System.out.println(expectedProjectName + " is not available==Fail");
	   		 Assert.fail();
	   	 }
	   	 
	   	 
	 //Step 5 : Close Connection
	  conn.close();

	}
}
