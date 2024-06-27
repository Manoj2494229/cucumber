package Utitlities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadConfig {

	Properties properties;

	String path = "config.properties";

	//constructor
	public ReadConfig() {
		System.out.println("This is Git");
		System.out.println("This is Dev ");
		try {
			properties = new Properties();
			//to open config .properties file in input mode and load the file
			FileInputStream  fis = new FileInputStream(path);
			properties.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public String getBrowser()
	{
		String value = properties.getProperty("browser");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}
	
	public static void getExcelData() throws Exception
	{
		 FileInputStream inputStream = new FileInputStream("./src/test/resource/testdata.xlsx");
	     XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	     XSSFSheet sheet = workbook.getSheetAt(4);

	     for (Row row : sheet) {
	         for (Cell cell : row) {
	             switch (cell.getCellType()) {
	                 case Cell.CELL_TYPE_STRING:
	                     System.out.println("Cell value: " + cell.getStringCellValue() + ", Format: String");
	                     break;
	                 case Cell.CELL_TYPE_NUMERIC:
	                     System.out.println("Cell value: " + cell.getNumericCellValue() + ", Format: Numeric");
	                     break;
	                 // Add cases for other cell types (BOOLEAN, FORMULA, etc.)
	             }
	         }
	     }
	     workbook.close();
	     inputStream.close();
	 }
public static void main(String[] args) throws Exception {
	ReadConfig.getExcelData();
}

}
