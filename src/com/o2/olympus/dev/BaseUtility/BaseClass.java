package com.o2.olympus.dev.BaseUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.android.AndroidDriver;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.o2.olympus.dev.ObjHelper.Xls_Reader;


public class BaseClass 

{
	
	public static WebDriver driver;
	public static Xls_Reader datatable = null;
	public static String filePath = "D:\\Senthil\\Project\\Scrum\\Selenium_Auto\\Olympus_Dev\\Test Data\\olympus_input.xlsx";
	
	@BeforeSuite
	public static void launch() throws IOException
	{
		String browserName = readConfigFile("browser");
			if (browserName.equals("firefox"))
			{
				driver = new FirefoxDriver();
			} 
			else if (browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\Browserexe\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if (browserName.equals("ie")) 
			{
				System.setProperty("webdriver.ie.driver",
				System.getProperty("user.dir") + "\\Browserexe\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} 
			/*else if (browserName.equals("Android"))
			{
				driver = new AndroidDriver();
			}*/
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(readConfigFile("devUrl"));
		
		
	}

	public static String readConfigFile(String key) throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\com\\o2\\olympus\\dev\\ConfigUtility\\config.properties");
		
		prop.load(fs);
		return (String) prop.get(key);
	}

	public static String readORFile(String key) throws IOException
	
	{
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\com\\o2\\olympus\\dev\\ConfigUtility\\or.properties");
		prop.load(fs);
		return (String) prop.get(key);
	}

	public static WebElement readObject(String key) throws IOException
	{
		String[] identifier = readORFile(key).split(",");
		try
		{
			if (identifier[0].equals("xpath"))
			{
				return driver.findElement(By.xpath(identifier[1]));
			} 
			else if (identifier[0].equals("id"))
			{
				return driver.findElement(By.id(identifier[1]));
			} 
			else if (identifier[0].equals("name")) 
			{
				return driver.findElement(By.name(identifier[1]));
			}
			else if (identifier[0].equals("linkText")) 
			{
				return driver.findElement(By.linkText(identifier[1]));
			}
			else if (identifier[0].equals("class")) 
			{
				return driver.findElement(By.linkText(identifier[1]));
			}
			else if (identifier[0].equals("ClassName")) 
			{
				return driver.findElement(By.className(identifier[1]));
			}
			
		}
		catch(NoSuchElementException n)
		{
			System.err.println("Element could not be found "+ identifier[1]);
		}
		catch (Exception e)
		{
			
		}
		return null;
	}

	
	public static void takeScreenShot(String MethodName) throws IOException {
		File screenshot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(
				"D:\\Senthil\\Project\\Scrum\\Selenium_Auto\\Olympus_Dev\\Screen_output" + MethodName +".jpg"));
		
	}
	
	@AfterSuite(alwaysRun=true)
	public static void tearDown() {
		//driver.quit();
	}

	public static boolean loadController() {

		try {
			String strControllerPath = System.getProperty("user.dir")
					+ "\\Controller.xlsx";
			if (isFilePresent(strControllerPath)) {
				datatable = new Xls_Reader(strControllerPath);
				Reporter.log("The Controller sheet is successfully loaded");
				return true;
			} else {
				Reporter.log("The Controller sheet loading is failed");
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Some Exception occured in loading the Configuration file");
			Assert.fail("Some Exception occured in loading the Configuration file");
			return false;
		}
	}
	
	public static boolean isFilePresent(String strFilePath){
		
		try{
			if((strFilePath).trim() == ""){
				
				Reporter.log("The passed file path paramenter is blank");
				return false;
				
			}else{
				
				File file=new File(strFilePath);
				  boolean exists = file.exists();
				  
				  if(exists) {
					  
					  return true;
					  
				  }else{
					  
					  return false;
				  }
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			return false;
			
		}
		
	}

	public static void verifyPageLoad(String ExpHeader)
	{
		String Header = driver.findElement(By.xpath("/html/body/form/div[3]/div/div[4]/h1")).getText();
		
		Assert.assertEquals(Header, ExpHeader);
		if(Header.equals(ExpHeader))
		{
			System.out.println( ExpHeader + "Page Loaded Successfully");
		} 
		
		else 
		{
			System.out.println( ExpHeader + "Page Not Loaded Successfully");
		}
				
	}
}
