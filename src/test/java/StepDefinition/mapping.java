package StepDefinition;

import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.relevantcodes.extentreports.LogStatus;

import Utitlities.ExtentReportListners;
import Utitlities.ReadConfig;
import io.cucumber.java.en.When;

public class mapping   {
	 
	//initialise logger
	Logger log = LogManager.getLogger("StepDef");
	ExtentReportListners es = new ExtentReportListners();
	@When("Test one")
	public void test_one() throws Exception {
//		 FileInputStream inputStream = new FileInputStream("./src/test/resource/testdata.xlsx");
//	     XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
//	     XSSFSheet sheet = workbook.getSheetAt(4);
//
//	     for (Row row : sheet) {
//	         for (Cell cell : row) {
//	             switch (cell.getCellType()) {
//	                 case Cell.CELL_TYPE_STRING:
//	                     System.out.println("Cell value: " + cell.getStringCellValue() + ", Format: String");
//	                     es.test.log(LogStatus.INFO, "Cell value: " + cell.getStringCellValue() + ", Format: String");
//	                     break;
//	                 case Cell.CELL_TYPE_NUMERIC:
//	                     System.out.println("Cell value: " + cell.getNumericCellValue() + ", Format: Numeric");
//	                     es.test.log(LogStatus.INFO, "Cell value: " + cell.getNumericCellValue() + ", Format: Numeric");
//	                     break;
//	                 // Add cases for other cell types (BOOLEAN, FORMULA, etc.)
//	             }
//	         }
//	     }
//	     workbook.close();
//	     inputStream.close();
		
		this.log.info("chrome browser test_one");
	}

	@When("Test two")
	public void test_two() {
//		es.test.log(LogStatus.INFO, "test_two ");
		this.log.info("chrome browser test_two");
	}

	@When("Test three")
	public void test_three() {
//		es.test.log(LogStatus.INFO, "test_three ");
		this.log.info("chrome browser test_three");
	}

}
