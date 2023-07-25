package testClasses;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomClasses.HomePage_POM;
import testUtility.BrowserWait;
import testUtility.CaptureScreenshot;
import testUtility.ReadExternalFile;


public class HomePage_TestClass extends BaseClass{
	
	HomePage_POM home;
	SoftAssert s = new SoftAssert();
	ReadExternalFile r;
	
	 @Test
	  public void enterDetailsForBooking() throws EncryptedDocumentException, InterruptedException, IOException {
		logger = report.createTest("Verify Home Page with all the details");
		
		 home = new HomePage_POM(driver);
		 home.clickOnRoundTripButton();
		 
		 r = new ReadExternalFile();
		 home.enterFromCity(r.fetchDataFromExcel(1, 0));
		 home.enterToCity(r.fetchDataFromExcel(1, 1));
		 
		 home.passDepartureDate();
		 home.passReturnDate();
		 
		 String expectedHelpMessage = "You are booking for more than 30 days";
		 String actualHelpMessage = home.fetchHelpMessage();
		 s.assertEquals(actualHelpMessage, expectedHelpMessage);
		 s.assertAll();
		 Thread.sleep(1000);
		 CaptureScreenshot.capturePageScreenshot(driver);	
		 
		home.clickOnTravellersAndCLass1();
		CaptureScreenshot.capturePageScreenshot(driver);
		
		BrowserWait.waitForBrowser(1000, driver);
		home.clickOnTravellersAndCLass2();
		home.clickOnApplyButton();
		home.clickOnSearchButton();
	  }

	 
}
