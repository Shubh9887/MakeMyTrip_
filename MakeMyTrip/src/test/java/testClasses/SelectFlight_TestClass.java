package testClasses;

import org.testng.annotations.Test;

import pomClasses.SelectFlight_POM;

public class SelectFlight_TestClass extends BaseClass {

	SelectFlight_POM flight;
	
	@Test
	public void selectFlights() throws InterruptedException {
		logger = report.createTest("Verify SelectFlights Page");
		
		flight = new SelectFlight_POM(driver);
		
		flight.clickOnOkGotItButton();
	
		flight.clickApplyButton();
	}
}
