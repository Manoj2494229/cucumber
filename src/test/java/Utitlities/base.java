package Utitlities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.relevantcodes.extentreports.LogStatus;

public class base {

	public static void log(String logs)
	{
		Logger log = LogManager.getLogger("StepDef");
		log.info(logs);
	}
	public static void report(String report)
	{
		ExtentReportListners es = new ExtentReportListners();
		es.test.log(LogStatus.PASS, report);
	}

}
