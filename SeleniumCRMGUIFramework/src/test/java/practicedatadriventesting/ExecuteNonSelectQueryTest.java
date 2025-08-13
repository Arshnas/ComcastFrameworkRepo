package practicedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQueryTest {

	public static void main(String[] args) throws SQLException {

		//Step 1 :Load/register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		
		
		//Step 2: Connect to Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		System.out.println("==============DONE============");
		
		//Step 3: Create SQL Statement
		Statement stat = conn.createStatement();
		
		//Step 4: Execute Non-Select query and get result
		int result = stat.executeUpdate("insert into project values('TY_PROJ_2025','Arshiya','03/7/2025','FB_09','On-Going','150');");
		System.out.println(result);
		
		//step 5: Close the Connection
		conn.close();
		

	}

}
