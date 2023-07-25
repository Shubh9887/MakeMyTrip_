package pomUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshotOfWebElement {

	public static String captureElementScreenshot(WebElement elementLocation, WebDriver driver) throws IOException {
		String currentDirectory = System.getProperty("user.dir");
		
		String path = currentDirectory + File.separator + "test-output" + File.separator + "Screenshots" + File.separator +  System.currentTimeMillis() + ".png";  
		
		File fileSource = elementLocation.getScreenshotAs(OutputType.FILE);
		
		File destination = new File(path);
		
		FileHandler.copy(fileSource, destination);
		
		return path;
	}
}
