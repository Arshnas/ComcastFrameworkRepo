package practicedatadriventesting;

import java.io.FileInputStream;
import java.util.Properties;

public class SampleDDT {

	public static void main(String[] args) throws Throwable {
		
		
		//get the java reperesentation object of physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\SYED KABIR AMMAR\\Desktop\\Commondata.properties");
	 
		//Using properties class load all keys
		Properties pObj = new Properties();
		pObj.load(fis);
		
		//get the values based on keys
    	System.out.println(pObj.getProperty("Browser"));
		

	}

}
