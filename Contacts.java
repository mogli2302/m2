package VtigerCRM;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Commonutils.Excelutil;
import Commonutils.Javautils;
import Commonutils.PropertyFileUtil;
import Commonutils.Webdriverutil;

public class Contacts {
	
	
	PropertyFileUtil putil=new PropertyFileUtil();
	Webdriverutil wutil=new Webdriverutil();
	Excelutil eutil=new Excelutil();
	Javautils jutil=new Javautils();
     
	@Test
	public void ContactsTest() throws IOException, InterruptedException {
		//to launch the empty browser
		WebDriver d=new ChromeDriver();
		wutil.maximize(d);
		wutil.implicitwait(d);
		//TO read Data From Property File.
		String URL=putil.getDataPropertyFile("url");
		String USERNAME=putil.getDataPropertyFile("Username");
		String PASSWORD=putil.getDataPropertyFile("Password");
		//TO read data from excel
		String Name=eutil.getDataFromExcel("Contact", 0, 1);
		String Lname=eutil.getDataFromExcel("Contact", 1, 1);
		String Assig=eutil.getDataFromExcel("Contact", 2, 1);
		String indx=eutil.getDataFromExcel("Contact", 3, 1);
		d.get(URL);
		d.findElement(By.name("user_name")).sendKeys(USERNAME);
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		d.findElement(By.id("submitButton")).click();		
		Thread.sleep(2000);
		//To click on Contacts.
		d.findElement(By.xpath("//a[text()='Contacts']")).click();
		//TO click on Create (+).....
		d.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		//Enter a firstname.
		d.findElement(By.name("firstname")).sendKeys(Name);
		//Emter  last name.
		d.findElement(By.name("lastname")).sendKeys(Lname);
		
		//To fail the testScript:
		String acturalurl=d.getCurrentUrl();
		String expectedurl="http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=\\\\r\\\\n";
		Assert.assertEquals(acturalurl,expectedurl);
		
		//Click on radio Group
		d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		//For Dropdown.
		WebElement element=d.findElement(By.name("assigned_group_id"));
		wutil.handledropdown(element,Assig);
		
		//Click on select Organization(+)
		d.findElement(By.xpath("( //img[@alt='Select'])[1]")).click();
		
		//TO check how many tab or windows is present
		wutil.switchwindow(d, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=\\r\\n");
		
		d.findElement(By.id("search_txt")).sendKeys(indx);
		Thread.sleep(4000);
		d.findElement(By.cssSelector("input[name='search']")).click();
		Thread.sleep(4000);
		
		//Click on Organization name
		d.findElement(By.xpath("//a[text()='Intel5']")).click();
		Thread.sleep(2000);
		wutil.switchwindow(d, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		//Click on Save Button
		d.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		Thread.sleep(2000);
		//To takes Screenshot of contact.
		wutil.screenshot(d, "Contact");
		
		WebElement Admin=d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mousehover(d, Admin);
		Thread.sleep(2000);
		//Click on Sign Out
		d.findElement(By.linkText("Sign Out")).click();
	}


	
		  
		 
	}
	


