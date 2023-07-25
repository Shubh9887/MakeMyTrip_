package testUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {

	public static String capturePageScreenshot(WebDriver driver) throws IOException {
		String currentDirectory = System.getProperty("user.dir");
		
		String path = currentDirectory + File.separator + "test-output" + File.separator + "Screenshots" + File.separator +  System.currentTimeMillis() + ".png";  
		
		File fileSource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File(path);
		
		FileHandler.copy(fileSource, destination);
		
		return path;
	}

}
