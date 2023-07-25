package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomUtility.ElementWait;

public class ReviewPage_POM {

	WebDriver driver;
	
	@FindBy(xpath="//p[text()='Tue, 1 Aug']")
	private WebElement departureDate;
	
	@FindBy(xpath="(//div[@class='multifareContentLeft'])[2]//ancestor::p[text()='Sun, 5 Nov']")
	private WebElement returnDate;	
	
	@FindBy(xpath="//button[text()='Continue']")
	private WebElement continueButton;
	
	public ReviewPage_POM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getDepartureDate() {
		String actualDepartureDate =departureDate.getText();
		return actualDepartureDate;
	}
	
	public String getReturnDate() throws InterruptedException {
       ElementWait.waitForElement("(//div[@class='multifareContentLeft'])[2]//ancestor::p[text()='Sun, 5 Nov']", 10, driver);
		String actualReturnDate =returnDate.getText();
		return actualReturnDate;
	}
	
//	public void clickContinueButton() {
//		continueButton.click();
//	}
}
