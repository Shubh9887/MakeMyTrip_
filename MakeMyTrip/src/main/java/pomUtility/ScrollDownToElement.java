package pomUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollDownToElement {

public static void scrollIntoView(WebDriver driver, WebElement Element) {
		
        JavascriptExecutor js = (JavascriptExecutor) driver;	
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
	}
}
