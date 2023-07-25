package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomUtility.ElementWait;

public class SelectFlight_POM {
	WebDriver driver;
	
	@FindBy(xpath="//button[text()='OKAY, GOT IT!']")
	private WebElement okGotItButton;
	
	@FindBy(xpath="(//input[@type='radio'])[10]")
	private WebElement departureFlight;
	
	@FindBy(xpath="(//input[@type='radio'])[50]")
	private WebElement returnFlight;
	
	@FindBy(xpath="//button[text()='Book Now']")
	private WebElement applyButton; 
	
	public SelectFlight_POM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnOkGotItButton(){
		
		ElementWait.waitForElement("//button[text()='OKAY, GOT IT!']", 10, driver);
		okGotItButton.click();
	}
	
	public void selectDepartureFlight() throws InterruptedException {
		Actions act = new Actions(driver);
		act.scrollToElement(departureFlight).perform();
		ElementWait.waitForElement("(//input[@type='radio'])[10]", 10, driver);
		departureFlight.click();
	}
	
	public void selectReturnFlight() throws InterruptedException {
		Actions act = new Actions(driver);
		act.scrollToElement(returnFlight).perform();
		ElementWait.waitForElement("(//input[@type='radio'])[50]", 10, driver);
		returnFlight.click();
	}
	
	public void clickApplyButton() {
		ElementWait.waitForElement("//button[text()='Book Now']", 5, driver);
		applyButton.click();
		
	}
	
	
}
