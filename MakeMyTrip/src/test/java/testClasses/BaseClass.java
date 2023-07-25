package testClasses;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testUtility.BrowserWait;
import testUtility.CaptureScreenshot;
import testUtility.StaticBrowser;

public class BaseClass {
	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest logger;
	static ExtentHtmlReporter extent;

	@Parameters({"browser"})
	
	@BeforeTest
	public void beforeTest(String browser) throws InterruptedException {
		
		report = new ExtentReports();
		extent = new ExtentHtmlReporter("test-output"+File.separator+"Reports"+File.separator+System.currentTimeMillis()+".html");
		report.attachReporter(extent);
		
		WebDriver driver = StaticBrowser.openBrowser(browser, "https://www.makemytrip.com/");
		this.driver=driver;
		driver.navigate().refresh();
		BrowserWait.waitForBrowser(10, driver);
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		Thread.sleep(1000);
		if(result.getStatus()==ITestResult.FAILURE) {
			String path =CaptureScreenshot.capturePageScreenshot(driver);
			logger.fail("Test case is failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		logger.pass("Test case is passed");
		report.flush();
	}
	
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
