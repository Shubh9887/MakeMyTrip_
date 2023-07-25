package pomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomUtility.CaptureScreenshotOfWebElement;
import pomUtility.ElementWait;

public class HomePage_POM {

	WebDriver driver;
	
	@FindBy(xpath="//li[@data-cy='roundTrip']") 
	private WebElement roundTripButton;
	
	@FindBy(xpath = "//input[@id='fromCity']")
	private WebElement fromCity;

	@FindBy(xpath = "//input[@placeholder='From']")
	private WebElement fromTextbox;
	
	@FindBy(xpath="(//p[text()='New Delhi, India'])[1]")
	private WebElement fromCityName;
	
	@FindBy(xpath="//label[@for='toCity']")
	private WebElement toCity;
	
	@FindBy(xpath = "//input[@placeholder='To']")
	private WebElement toTextbox;
	
	@FindBy(xpath = "//p[text()='Mumbai, India']")
	private WebElement toCityName;
	
	@FindBy(xpath = "//div[@aria-label='Tue Aug 01 2023']")
	private WebElement departureDate;
	
	@FindBy(xpath="//span[@aria-label='Next Month']")
	private WebElement nextMonthButton;
	
	@FindBy(xpath = "//div[@aria-label='Sun Nov 05 2023']")
	private WebElement returnDate;
	
	@FindBy(xpath="//p[@id='range_error']")
	private WebElement helpMessage;
	
	@FindBy(xpath = "//label[@for='travellers']")
	private WebElement travellersAndClass;
	
	@FindBy(xpath = "//li[@data-cy='adults-9']")
	private WebElement adults1;
	
	@FindBy(xpath = "//li[@data-cy='children-3']")
	private WebElement children1;
	
	@FindBy(xpath = "//li[@data-cy='adults-2']")
	private WebElement adults2;
	
	@FindBy(xpath = "//li[@data-cy='children-2']")
	private WebElement children2;
	
	@FindBy(xpath = "//button[text()='APPLY']")
	private WebElement applyButton;
	
	@FindBy(xpath = "//a[text()='Search']")
	private WebElement searchButton;
	
	public HomePage_POM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}	
	
	public void clickOnRoundTripButton() {
		ElementWait.waitForElement("//li[@data-cy='roundTrip']", 10, driver);
		
		if(roundTripButton.isSelected()==false) {
			roundTripButton.click();
		}
	}
	
	public void enterFromCity(String cityName) throws InterruptedException {
		fromCity.click();
		Thread.sleep(1000);
		fromTextbox.click();
		fromTextbox.sendKeys(cityName);
		Thread.sleep(1000);
		fromCityName.click();
	}
	
	public void enterToCity(String cityName) throws InterruptedException {
		toCity.click();
		Thread.sleep(1000);
		toTextbox.click();
		toTextbox.sendKeys(cityName);
		Thread.sleep(1000);
		toCityName.click();
		
	}
	
	public void passDepartureDate() {
		departureDate.click();
	}
	
	public void passReturnDate() {
		for(int i=0; i<=2; i++) {
			nextMonthButton.click();
		}
		returnDate.click();
	}
	
	public String fetchHelpMessage() throws IOException {
		CaptureScreenshotOfWebElement.captureElementScreenshot(helpMessage, driver);
		String actualHelpMessage = helpMessage.getText();
		return actualHelpMessage;
	}
	
	public void clickOnTravellersAndCLass1() {
		travellersAndClass.click();
		ElementWait.waitForElement("//li[@data-cy='adults-9']", 5, driver);
		adults1.click();
		children1.click();
		
	}
	
	public void clickOnTravellersAndCLass2() {
		ElementWait.waitForElement("//li[@data-cy='children-2']", 5, driver);
		adults2.click();
		children2.click();
	}
	
	public void clickOnApplyButton() {
		applyButton.click();
	}
	
	public void clickOnSearchButton() {
		ElementWait.waitForElement("//a[text()='Search']", 5, driver);
		searchButton.click();
	}
	

}
