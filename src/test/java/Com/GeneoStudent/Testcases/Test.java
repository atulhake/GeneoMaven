package Com.GeneoStudent.Testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test {

	public static void main(String[] args)
	{
		ExtentTest logger;
		ExtentReports reports = new ExtentReports("C:\\eclipse\\Geneo_maven\\Extentreports\\HTMLreport.html");
		logger = reports.startTest("abc");
		logger.log(LogStatus.INFO, "1");
		logger.log(LogStatus.FAIL,"2");
		reports.endTest(logger);
		
		
		
		
	}

}
