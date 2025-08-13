package practicedatadriventesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelTest {
	
	public static void main(String[] args) throws Throwable {
		
	FileInputStream fis=new FileInputStream("C:\\Users\\SYED KABIR AMMAR\\Desktop\\Data\\testScriptdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	int rowcount = sh.getLastRowNum();
	for(int i=0;i<=rowcount;i++) {
	Row row = sh.getRow(i);
	String column1data = row.getCell(0).toString();
	String column2data = row.getCell(1).toString();
	System.out.println(column1data +"\t" + column2data);
	}
	wb.close();
	
	
	}

}
