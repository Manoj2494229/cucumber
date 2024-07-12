package Utitlities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

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

	public static String getLeadData(int sr ,int dataHead) throws Exception
	{	
		FileInputStream fis = new FileInputStream("./src/test/resource/excel/leadData.xlsx");
		//Create workbook object by using workbookfacory
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 = wb.getSheet("Sheet1");
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
		return dxlApi.get(sr);
	}

	public static ArrayList<String> getData(String Query , String Key , String filePath) {
		String DATA = null ;
		String CIR = Query;
		ArrayList<String> listdata = new ArrayList<String>();
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(filePath);
			Recordset APSET = connection.executeQuery(CIR);
			while (APSET.next()) 
			{
				listdata.add(APSET.getField(Key));
			}
			APSET.close();
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listdata;
	}
	public static void updateData(String Query ,  String filePath) {
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(filePath);
			connection.executeUpdate(Query);
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


}
