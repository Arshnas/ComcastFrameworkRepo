package practicedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteSelectQueryUsingTryCatchBlock {
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn=null;
		try{
	   //Step 1 : Load /register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2:  Connect to database
	  conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		System.out.println("================Done==============");
		
		//Step 3: Create SQL statement
		Statement stat = conn.createStatement();
		
		//Step 4: Execute Select query and get Result
	     ResultSet resultset = stat.executeQuery("Select * from projects");
	   	 resultset.next();
	   	 while(resultset.next()) {
	     System.out.println(resultset.getString(1) + "\t" + resultset.getString(2) +"\t" +resultset.getString(3) + "\t" + resultset.getString(4) +"\t" + resultset.getString(5) +"\t" + resultset.getInt(6));
	   	 }
		}catch(Exception e) {
			System.out.println("handle Exception");
		}finally {
	 //Step 5 : Close Connection
	  conn.close();
	  System.out.println("============Close The Connection==========");
		}
	}

}
