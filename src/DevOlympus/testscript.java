package DevOlympus;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.o2.olympus.dev.BaseUtility.BaseClass;
import com.o2.olympus.dev.ObjHelper.ButtonHelper;
import com.o2.olympus.dev.ObjHelper.DropDownHelper;
import com.o2.olympus.dev.ObjHelper.ImageHelper;
import com.o2.olympus.dev.ObjHelper.KciBrowser;
import com.o2.olympus.dev.ObjHelper.LinkHelper;
import com.o2.olympus.dev.ObjHelper.RadioBoxHelper;
import com.o2.olympus.dev.ObjHelper.TextBoxHelper;
import com.o2.olympus.dev.ObjHelper.Xls_Reader;



public class testscript extends BaseClass
{
	
	@Test
	public static void OrProv() throws InterruptedException, IOException 
	{
		/*WebElement test;
		driver.navigate().to("https://c.cs18.visual.force.com/apex/ProvisioningViewConfiguration?id=a201100000071Sq&sfdc.override=1");
		//String OrderStatus=driver.findElement(By.id("//*[@id='ep_j_id0_j_id1']/div[2]/div[2]/table/tbody/tr[2]/td[2]")).getText();
		String OrderStatus=readObject("OrStatus").getText();
		System.out.println(OrderStatus);
		if(OrderStatus.equals("In Provisioning"))
		{
			ButtonHelper.button("OrSubmit");
			ButtonHelper.button("OrConfirm");
			String Cims=readObject("OrCims").getText();
			if(Cims.equals(""))
			{
				System.out.println("Order not submitted successfully");
			}
		}*/
		
		/*Xls_Reader ObjExcel = new Xls_Reader(filePath);
		KciBrowser.Browser2();
		String usrname = ObjExcel.getCellData("Login", 0, 2);
		String uPass= ObjExcel.getCellData("Login", 1, 2);
		Thread.sleep(2000);
		TextBoxHelper.type("Username", usrname);
		TextBoxHelper.type("Password", uPass);
		LinkHelper.Click("Login");*/
		//WebElement kci=driver.findElement(By.xpath("//*[@id='01r110000000QYZ_Tab']/a"));
		//Thread.sleep(1000);
		//Actions oAction = new Actions(driver);
		//oAction.moveToElement(kci);
		//oAction.contextClick(kci).sendKeys(Keys.ARROW_RIGHT).build().perform(); /* this will perform right click */
		
		//File resultScr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    //FileUtils.copyFile(resultScr, new File("c:\\tmp\\screenshot.png"));
	    
	    /*String filePath = "D:\\Senthil\\Project\\Scrum\\Selenium_Auto\\Olympus_Dev\\Test Data\\olympus_input.xlsx";
		Xls_Reader ObjExcel = new Xls_Reader(filePath);*/
		
		//Excel path is declared in BaseClass
		Xls_Reader ObjExcel = new Xls_Reader(filePath);
	
		WebElement Stage;
		String ContExist0, ContExist1, ContExist2, ContExist3;
		driver.navigate().to("https://cs18.salesforce.com/006110000073yC1");
		//Checking whether contact is already exist or not
		String ConRoleCount=readObject("Oconrolecount").getText();
		if(ConRoleCount.equals("Contact Roles[0]"))
		{
			ButtonHelper.button("Ocnewrole");
		
			ContExist0=readObject("Ocontact0").getAttribute("value");
			
			//ContExist.clear();
			//String ContExist1 = ContExist.getAttribute("value");
			System.out.println(ContExist0);
			if(ContExist0.equals(""))
			{
				/*String parentHandle = driver.getWindowHandle(); // get the current window handle
				ImageHelper.image("Ocsearch");// click some link that opens a new window

				for (String winHandle : driver.getWindowHandles()) 
				{
				    driver.switchTo().window(winHandle);// switch focus of WebDriver to the next found window handle (that's your newly opened window)
				    
				    
				    String d = driver.getCurrentUrl();
				    
				    System.out.println(d);
				    File resultScr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				    FileUtils.copyFile(resultScr, new File("c:\\tmp\\screenshot.png"));
				    LinkHelper.Click("Ocname");
				    driver.findElement(By.id("lksrch")).sendKeys("Contact_1");
				    ButtonHelper.button("Ocgo");*/
				
				String Contact0 = ObjExcel.getCellData("Contact", 0, 2);
				TextBoxHelper.type("Ocontact0", Contact0);
				
			}
			RadioBoxHelper.select("Oprimary0");
			String ConRole=ObjExcel.getCellData("Contact", 2, 2);
			DropDownHelper.Select("Ocrole0", ConRole);
			ButtonHelper.button("Ocsave");
		}
		else
		{
			String BillRole = readObject("Ocbilling").getText();
			System.out.println(BillRole);
			if(BillRole.contains("Billing"))
			{
			System.out.println("Billing role already available in Contact");	
			}
			else
			{
				
				ButtonHelper.button("Ocnewrole");
				ContExist0 =readObject("Ocontact0").getAttribute("value");
				ContExist1=readObject("Ocontact1").getAttribute("value");
				ContExist2=readObject("Ocontact2").getAttribute("value");
				ContExist3=readObject("Ocontact3").getAttribute("value");
						
				System.out.println(ContExist1);
				if(ContExist0.equals(""))
				{
					String Contact1 = ObjExcel.getCellData("Contact", 0, 2);
					TextBoxHelper.type("Ocontact0", Contact1);
					RadioBoxHelper.select("Oprimary0");
					String ConRole=ObjExcel.getCellData("Contact", 2, 2);
					DropDownHelper.Select("Ocrole0", ConRole);
					ButtonHelper.button("Ocsave");
				}
				else if(ContExist1.equals(""))
				{
					String Contact1 = ObjExcel.getCellData("Contact", 0, 2);
					TextBoxHelper.type("Ocontact1", Contact1);
					RadioBoxHelper.select("Oprimary1");
					String ConRole=ObjExcel.getCellData("Contact", 2, 2);
					DropDownHelper.Select("Ocrole1", ConRole);
					ButtonHelper.button("Ocsave");
				}
				else if(ContExist2.equals(""))
				{
					String Contact1 = ObjExcel.getCellData("Contact", 0, 2);
					TextBoxHelper.type("Ocontact2", Contact1);
					RadioBoxHelper.select("Oprimary2");
					String ConRole=ObjExcel.getCellData("Contact", 2, 2);
					DropDownHelper.Select("Ocrole2", ConRole);
					ButtonHelper.button("Ocsave");
				}
				else
				{
					String Contact1 = ObjExcel.getCellData("Contact", 0, 2);
					TextBoxHelper.type("Ocontact3", Contact1);
					RadioBoxHelper.select("Oprimary3");
					String ConRole=ObjExcel.getCellData("Contact", 2, 2);
					DropDownHelper.Select("Ocrole3", ConRole);
					ButtonHelper.button("Ocsave");
				}
			}
			
		}
		
		String OrderStatus = readObject("OppOrder").getText();
	
		Stage=readObject("Opstage");
		Actions sAction = new Actions(driver);
		sAction.moveToElement(Stage);
		sAction.doubleClick().build().perform();
		String Ostage=ObjExcel.getCellData("Opportunity", 3, 2);
		DropDownHelper.Select("Ostage", Ostage);
		ButtonHelper.button("Ook");
		ButtonHelper.button("Osave");
		/*String OppURL=driver.getCurrentUrl();
		boolean wrfile = ObjExcel.isSheetExist("Opportunity");
		wrfile = ObjExcel.setCellData("Opportunity", "E", 2, OppURL, OppURL);*/
		
		//waiting the page get refresh automatically
		WebElement OpEdit = (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.name("edit")));
		//Thread.sleep(15000);
		//driver.navigate().refresh();
		
		String OrderStatus1 = readObject("OppOrder").getText();
		//String NewOrderCount=OrderStatus1.getText();
		System.out.println(OrderStatus1);
		if(OrderStatus1.equalsIgnoreCase(OrderStatus))
		{
			System.out.println("Order not created successfully");
		}
		else
		{
			System.out.println("Order created successfully");
		}
		
		/*OppOrder = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[3]/a[5]/span"));
		OppOrder.click();
		OrderNavigate=driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[9]/div[1]/div/div[2]/table/tbody/tr[2]/th/a"));
		OrderNavigate.click();*/
		LinkHelper.Click("OppOrder");
		LinkHelper.Click("OrderNav");
	    
	}
		
}


