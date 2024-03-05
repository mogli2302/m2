


package Commonutils;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Webdriverutil {
	
	
 
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void handledropdown(WebElement element,String targetedelement) {
		Select a=new Select(element);
		a.selectByVisibleText(targetedelement);
	}
	public void mousehover(WebDriver driver,WebElement element) {
		
		Actions a=new Actions(driver);
		a.moveToElement(element);
		a.perform();
	}
	
	public void switchwindow(WebDriver driver,String expectedurl) {
		Set<String> ids = driver.getWindowHandles();
		
		for(String e:ids) {
			 String actualurl = driver.switchTo().window(e).getCurrentUrl();
			 
			 if(actualurl.contains(expectedurl)) {
			
		}
	}
	
	}
	public File screenshot(WebDriver driver,String ScreenshotName ) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile=new File(ScreenshotName);
		return destinationFile;
	}
	}

