package Utitlities;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readExcelConfig {
	
	public static String getBaseURI(int apinumber ,int dataHead) throws Exception
	{	
		FileInputStream fis = new FileInputStream("./src/test/resource/excel/testdata.xlsx");
		//Create workbook object by using workbookfacory
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 = wb.getSheet("API");
		HashMap<Integer, String> dxlApi = new HashMap<Integer, String>();
		for(int i= 0;i<=s1.getLastRowNum();i++)
		{
			for(int j = 1 ; j<=dataHead;j++)
			{
				try
				{
					dxlApi.put(i, s1.getRow(i).getCell(j).getStringCellValue());
				}catch(Exception e)
				{
					
				}
			}	
		}
		return dxlApi.get(apinumber).trim();
	}

}
