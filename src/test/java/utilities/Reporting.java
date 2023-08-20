package utilities;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Reporting extends TestListenerAdapter {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public void onStart(ITestContext testContext) {
		
	
	}
}
