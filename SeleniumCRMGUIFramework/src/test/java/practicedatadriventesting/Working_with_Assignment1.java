package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Working_with_Assignment1{
	public static void main(String[] args) throws Throwable, IOException {
		
   FileInputStream fis = new FileInputStream("C:\\Users\\SYED KABIR AMMAR\\Desktop\\TP_31.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("TP_31");
		int rowcount = sh.getLastRowNum();
		
		for(int i=0;i<=rowcount;i++) {
			Row row = sh.getRow(i);
			String column1data = row.getCell(0).toString();
			String column2data = row.getCell(1).toString();
			String column3data = row.getCell(2).toString();
			String column4data = row.getCell(3).toString();
			System.out.println(column1data + "\t" + column2data + "\t" + column3data + "\t" + column4data);
		}
		
		
	}
	
	
	

}

