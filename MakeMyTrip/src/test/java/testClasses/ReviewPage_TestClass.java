package testClasses;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomClasses.ReviewPage_POM;
import testUtility.CaptureScreenshot;

public class ReviewPage_TestClass extends BaseClass {

	ReviewPage_POM review;
	SoftAssert s = new SoftAssert();
	
	@Test
	public void validateDatesOnReviewPage() throws IOException, InterruptedException {
		
		logger = report.createTest("Verify Review Page with all booking details");
		
		review = new ReviewPage_POM(driver);
		
		CaptureScreenshot.capturePageScreenshot(driver);
		String actualDepartureDate = review.getDepartureDate();
		String expectedDepartureDate = "Tue, 1 Aug";
		s.assertEquals(actualDepartureDate, expectedDepartureDate);
		
		String actualReturnDate = review.getReturnDate();
		String expectedReturnDate = "Sun, 5 Nov";
		s.assertEquals(actualReturnDate, expectedReturnDate);
		s.assertAll();

		
	}

	
}
