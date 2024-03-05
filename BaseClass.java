package Commonutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	
	 WebDriver driver=new ChromeDriver();
	Pro[pertyfileUtil
	WebdriverUtil wutil=new WebdriverUtil();
	
	
	
	
	
	
	@BeforeSuite
	public void BS() {
		System.out.println("Connect to Data Base");
	}
	
	@BeforeClass
	public void Bc() throws IOException {
		//It is use to launch the application.
		String URL=putil.getDataFromPropertyFile("url");
		WebDriver d=new ChromeDriver();
		wutil.Maximize(d);
		wutil.implicitwait(d);
		d.get(URL);
		
	}
	
	@BeforeMethod
	public void BM() throws IOException, InterruptedException {
		//It is used to Login to the application.
		String USERNAME=putil.getDataFromPropertyFile("Username");
		String PASSWORD=putil.getDataFromPropertyFile("Password");
		//Login to the application.
		d.findElement(By.name("user_name")).sendKeys(USERNAME);
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		Thread.sleep(2000);
		d.findElement(By.id("submitButton")).click();
		
	}
	
	@AfterMethod
	public void AM() throws InterruptedException {
		Thread.sleep(2000);
		//It is used to sign out from the application.
		WebElement Admin=d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		//Click on Sign Out
		wutil.MouseHover(d, Admin);
		d.findElement(By.linkText("Sign Out")).click();
		
	}
	
	@AfterClass
	public void AC() {
		//It is used to close the browser.
		d.quit();
		
	}
	
	@AfterSuite
	public void AS() {
		
		System.out.println("Disconnect the data base.");
	}
}