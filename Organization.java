package VtigerCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Commonutils.Excelutil;
import Commonutils.Javautils;
import Commonutils.ListenerImplementation;
import Commonutils.PropertyFileUtil;
import Commonutils.Webdriverutil;

@Listeners(ListenerImplementation.class)
public class Organization {
	
	
	
PropertyFileUtil putil=new PropertyFileUtil();
Webdriverutil wutil=new Webdriverutil();
Excelutil eutil=new Excelutil();
Javautils jutil=new Javautils();

@Test
public void OrganizationTest() throws IOException, InterruptedException {
	
	WebDriver driver=new ChromeDriver();
	//to maximize the window
      wutil.maximize(driver);
	wutil.implicitwait(driver);
	//to read data from property file
	  String URL= putil.getDataPropertyFile("Url");
	  String USERNAME= putil.getDataPropertyFile("Username");
	  String PASSWORD= putil.getDataPropertyFile("Password");
	  //to read the data from Excel file
	  String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
	  String GROUP = eutil.getDataFromExcel("Organizations", 1, 1);
	  
	  driver.get(URL);
	  
	  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	  driver.findElement(By.id("submitButton")).click();
	  
	  //click on organization
	  Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//click on + button
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		//click on 
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
		
		//in assignto click on group
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
	
		//Identify targeted element webelement-month
		WebElement dropdown=driver.findElement(By.name("assigned_group_id"));
		
		wutil.handledropdown(dropdown, GROUP);
		
		//click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		Thread.sleep(2000);
		
		//Mousehover on image
		WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mousehover(driver, image);
		Thread.sleep(2000);
		//Click on Signout
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	
	
	
}
}
