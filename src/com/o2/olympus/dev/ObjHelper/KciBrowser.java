package com.o2.olympus.dev.ObjHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.o2.olympus.dev.BaseUtility.BaseClass;

public class KciBrowser extends BaseClass
{
	public static void Browser2() throws InterruptedException
	{
		try
		{
		WebDriver driver2 = new ChromeDriver();
		driver2.manage().window().maximize();
		driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver2.get(readConfigFile("kciUrl"));
		/*for (String winHandle : driver2.getWindowHandles()) 
		  {
			driver.switchTo().window(winHandle);// switch focus of WebDriver to the next found window handle (that's your newly opened window)
			Xls_Reader ObjExcel = new Xls_Reader(filePath);
			String usrname = ObjExcel.getCellData("Login", 0, 2);
			String uPass= ObjExcel.getCellData("Login", 1, 2);
			Thread.sleep(2000);
			TextBoxHelper.type("Username", usrname);
			TextBoxHelper.type("Password", uPass);
			LinkHelper.Click("Login");
		  } */
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Failed to do launch kci browser");
		}
	}
}
