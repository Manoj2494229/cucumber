package Utitlities;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReportListners  implements ITestListener {


	private static WebDriver driverFinal;
	public static ExtentReports reports;
	public static ExtentTest test;


	private static String resultpath = getResultPath();


	public static void deleteDirectory(File directory) 
	{
		if (directory.exists()) {
			File[] files = directory.listFiles();
			if (null != files) {
				for (int i = 0; i < files.length; i++) {
					//System.out.println(files[i].getName());
					if (files[i].isDirectory()) {
						deleteDirectory(files[i]);
					} else {
						files[i].delete();
					}
				}
			}
		}
	}

	private static String getResultPath() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
		String date = simpleformat.format(cal.getTime());
		String date1 = date.replace(" ", "_");
		String date2 = date1.replace(":", "_");
		System.out.println("Today's date and time = "+simpleformat.format(cal.getTime()));

		resultpath ="";
		// simpleformat.format(cal.getTime());//new SimpleDateFormat("yyyy-MM-dd hh-mm.ss").format(new Date(0000));
		if (!new File(resultpath).isDirectory()) 
		{
			new File(resultpath);
		}
		return resultpath;
	}

	String ReportLocation = "Report/" + resultpath + "/";
	//String ReportLocation = "test-output/Report/" + resultpath + "/";


	public void onTestStart(ITestResult result) {

		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO,"Test Start");
		test.log(LogStatus.INFO, result.getMethod().getMethodName());	
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, "Test is pass");
		try {
			//Thread.sleep(1000);
			sscapture();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("");
		}




	}

	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, "Test is fail");
		//test.addBase64ScreenShot(sss.capturescreenshot(login_SmokeTest.driver));
		try {
			//Thread.sleep(1000);
			sscapture();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("");
		}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, "Test is skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
		String date = simpleformat.format(cal.getTime());
		String date1 = date.replace(" ", "_");
		String date2 = date1.replace(":", "_");
		System.out.println(ReportLocation + "  ReportLocation");
		reports = new ExtentReports(ReportLocation + "Vi_Marketplace_And_Ecom_Automation_Report_"+date2+".html");
		//test = reports.startTest("");	
	}

	public void onFinish(ITestContext context) {
		test.log(LogStatus.INFO, "Test End");
		reports.endTest(test);
		reports.flush();
	}
	public static  void sscapture() throws Exception
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/propertiesFile/login.properties");
		Properties prop = new Properties();
		prop.load(fis);
		Thread.sleep(500);
		String screenshotPath = getScreenshot(driverFinal, "testing");
		//System.out.println(screenshotPath);
		test.log(LogStatus.PASS,test.addBase64ScreenShot(screenshotPath));
	}

	public static  String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//String destination = System.getProperty("user.dir")+"./FailedTestsScreenshots/"+screenshotName+dateName+".png";
		String destination = System.getProperty("user.dir")+screenshotName+dateName+".png";
		System.out.println(destination);
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		String encodedBase64 = null;
		FileInputStream fi =new FileInputStream(destination);
		byte[] bytes =new byte[(int)finalDestination.length()];
		fi.read(bytes);
		encodedBase64 = new String(Base64.getEncoder().encodeToString(bytes));
		return "data:image/png;base64,"+encodedBase64;
	}
}