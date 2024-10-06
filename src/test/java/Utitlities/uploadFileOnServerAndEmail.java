package Utitlities;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class uploadFileOnServerAndEmail {
	static WebDriver driver = base.driver;

	public static void uploadFileOnSITServerAndEmail() throws Exception
	{
		base BS =  new base();

		System.out.println("-----------------afterAllScenarioFinish-----------------");
		BS.reports.endTest(BS.test);
		BS.reports.flush();
		Thread.sleep(5000);
		driver = base.openTerminal("https://webserver-vil-sit.lfr.cloud/");
		driver.navigate().refresh();
		//Login Page
		driver.findElement(By.xpath("//input[@id='_com_liferay_login_web_portlet_LoginPortlet_login']")).sendKeys("test@liferay.com");
		//OTP
		driver.findElement(By.xpath("//a[@class='otps']")).click();
		Thread.sleep(500);
		for(int i = 1 ; i<=4 ;i++)
		{
			Thread.sleep(200);
			driver.findElement(By.xpath("//input[@class='otp']["+i+"]")).sendKeys("1");

		}
		driver.findElement(By.xpath("//a[@id='submit-otp-button']")).click();
		driver.navigate().to("https://webserver-vil-sit.lfr.cloud/group/vil/~/control_panel/manage?p_p_id=com_liferay_document_library_web_portlet_DLAdminPortlet&p_p_lifecycle=0&p_p_state=maximized&_com_liferay_document_library_web_portlet_DLAdminPortlet_mvcRenderCommandName=%2Fdocument_library%2Fedit_file_entry&_com_liferay_document_library_web_portlet_DLAdminPortlet_cmd=add&_com_liferay_document_library_web_portlet_DLAdminPortlet_redirect=%2Fgroup%2Fvil%2F%7E%2Fcontrol_panel%2Fmanage%3Fp_p_id%3Dcom_liferay_document_library_web_portlet_DLAdminPortlet%26p_p_lifecycle%3D0%26p_p_state%3Dmaximized%26p_p_mode%3Dview%26_com_liferay_document_library_web_portlet_DLAdminPortlet_mvcRenderCommandName%3D%252Fdocument_library%252Fview_folder%26_com_liferay_document_library_web_portlet_DLAdminPortlet_redirect%3Dhttps%253A%252F%252Fwebserver-vil-sit.lfr.cloud%252Fgroup%252Fvil%252F%257E%252Fcontrol_panel%252Fmanage%253Fp_p_id%253Dcom_liferay_document_library_web_portlet_DLAdminPortlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dmaximized%2526p_p_mode%253Dview%2526p_p_auth%253DM9MXNcE5%26_com_liferay_document_library_web_portlet_DLAdminPortlet_folderId%3D33151957%26p_p_auth%3DM9MXNcE5&_com_liferay_document_library_web_portlet_DLAdminPortlet_portletResource=com_liferay_document_library_web_portlet_DLAdminPortlet&_com_liferay_document_library_web_portlet_DLAdminPortlet_fileEntryTypeId=0&_com_liferay_document_library_web_portlet_DLAdminPortlet_folderId=33151957&_com_liferay_document_library_web_portlet_DLAdminPortlet_repositoryId=57725&p_p_auth=M9MXNcE5");
		//driver.findElement(By.xpath("//button[normalize-space()='Select File']")).click();

		// Locate the file input element
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));

		// Construct the relative path to your file inside the Eclipse project
		String relativeFilePath = ExtentReportListners.reportName;

		// Get the absolute path of the file
		File file = new File(relativeFilePath);
		String absoluteFilePath = file.getAbsolutePath();
		System.out.println("absoulte: "+absoluteFilePath);
		System.out.println("conical: "+file.getCanonicalPath());
		System.out.println("path: "+file.getPath());

		// Upload the file
		fileInput.sendKeys(absoluteFilePath);

		driver.findElement(By.xpath("//span[normalize-space()='Publish']")).click();
		Thread.sleep(6000);

		System.out.println(ExtentReportListners.reportName);
		driver.quit();
	}

}
