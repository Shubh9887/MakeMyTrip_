package testUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExternalFile {

	public static String fetchDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException{
	String data = "";
	String path = "src" + File.separator + "test" + File.separator +"resources" + File.separator + "TestData" +File.separator + "TestData.xlsx";
	FileInputStream file = new FileInputStream(path);
	Cell c= WorkbookFactory.create(file).getSheet("City Name").getRow(row).getCell(cell); //sheetName - Name of sheet present in excel file
	
	CellType type = c.getCellType();
	
	if(type==CellType.STRING) {
		data = c.getStringCellValue();
	}
	else if (type==CellType.NUMERIC) {
		double number = c.getNumericCellValue();	//Converting numeric data into String
		data= Double.toString(number);			
	}
	else if(type==CellType.BLANK) {
		data ="";
	}
	
	return data;									//Taking excel data in form of String as output
	}
}
