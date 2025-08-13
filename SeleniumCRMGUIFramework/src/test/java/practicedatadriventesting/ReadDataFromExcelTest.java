package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {
	
	public static void main(String[] args) throws Exception, IOException {
		
//		step 1 : get the Excel path location & java object of the physical Excelfile
		FileInputStream fis = new FileInputStream("C:\\Users\\SYED KABIR AMMAR\\Desktop\\testScriptdata.xlsx");
		
//		step 2 : open WorkBook in read mode
	    Workbook wb = WorkbookFactory.create(fis);
	    
//		step 3 : get the control of the "org" sheet
	    Sheet sh = wb.getSheet("org");
	
//		step 4 : get the control of the "1st" Row
	    Row row = sh.getRow(1);
		
//		step 5 : get the control of the "2nd" cell & read the string data
	  //  Cell cel = row.getCell(1);
        //String data = cel.getStringCellValue();
	    String data = row.getCell(3).getStringCellValue(); //convert numeric cell data to string by just adding ' before number so that you will get it on console
        System.out.println(data);
        
//		step 6 : close the workbook
        wb.close();
	}

}
