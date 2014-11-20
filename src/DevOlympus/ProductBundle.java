package DevOlympus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.o2.olympus.dev.BaseUtility.BaseClass;
import com.o2.olympus.dev.ObjHelper.ButtonHelper;
import com.o2.olympus.dev.ObjHelper.DropDownHelper;
import com.o2.olympus.dev.ObjHelper.ImageHelper;
import com.o2.olympus.dev.ObjHelper.LinkHelper;
import com.o2.olympus.dev.ObjHelper.TextBoxHelper;
import com.o2.olympus.dev.ObjHelper.Xls_Reader;

public class ProductBundle extends BaseClass 
{
	@Test
	
	public static void CreateProductBundle() throws InterruptedException
	{
		String filePath = "D:\\Senthil\\Project\\Scrum\\Selenium_Auto\\Olympus_Dev\\Test Data\\olympus_input.xlsx";
		Xls_Reader ObjExcel = new Xls_Reader(filePath);
		String Bundlename,ProdCategory,Prodname;
		ButtonHelper.button("Pbnew");
		driver.findElement(By.xpath("//*[@id='productbundlebuilder:j_id0:BundlePageBlock:j_id34:j_id35']")).clear();
		Bundlename=ObjExcel.getCellData("Prod_Bundle", 0, 2);
		TextBoxHelper.type("BundleName", Bundlename);
		ButtonHelper.button("Pbsave");
		ButtonHelper.button("Pbnewconfig");
		ProdCategory=ObjExcel.getCellData("Prod_Bundle", 1, 2);
		DropDownHelper.Select("Pbprodtype",ProdCategory);
		Prodname=ObjExcel.getCellData("Prod_Bundle", 2, 2);
		DropDownHelper.Select("Pbprodname",Prodname);
		ImageHelper.image("Pbadd");
		WebElement imgWait = (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='productbundlebuilder:j_id0:ConfigPageBlock:j_id75:ConfigRequestsDetailsSection:ConfigRequests:0:editConfigurationOn']")));
		//Thread.sleep(2000);
		//ImageHelper.image("Pbundle");
		imgWait.click();
	}
	
	@Test
	
	public static void CreateProductConfig() throws InterruptedException
	{
		String filePath = "D:\\Senthil\\Project\\Scrum\\Selenium_Auto\\Olympus_Dev\\Test Data\\olympus_input.xlsx";
		Xls_Reader ObjExcel = new Xls_Reader(filePath);
		String RouterOption,o2mob,OrderType,MacKey,PackType,IpAdd,IpUsage,CarePack,Landline,Bbinstal,City,Pcode;
		String Title,Fname,Lname,Landno,Mobno,Email;
		
		// Getting input values from Excel 
		RouterOption=ObjExcel.getCellData("Prod_Config", 0, 2);
		o2mob=ObjExcel.getCellData("Prod_Config", 1, 2);
		OrderType=ObjExcel.getCellData("Prod_Config", 2, 2);
		MacKey=ObjExcel.getCellData("Prod_Config", 3, 2);
		PackType=ObjExcel.getCellData("Prod_Config", 4, 2);
		IpAdd=ObjExcel.getCellData("Prod_Config", 5, 2);
		IpUsage=ObjExcel.getCellData("Prod_Config", 6, 2);
		CarePack=ObjExcel.getCellData("Prod_Config", 7, 2);
		Landline=ObjExcel.getCellData("Prod_Config", 8, 2);
		Bbinstal=ObjExcel.getCellData("Prod_Config", 9, 2);
		City=ObjExcel.getCellData("Prod_Config", 10, 2);
		Pcode=ObjExcel.getCellData("Prod_Config", 11, 2);
		Title=ObjExcel.getCellData("Prod_Config", 12, 2);
		Fname=ObjExcel.getCellData("Prod_Config", 13, 2);
		Lname=ObjExcel.getCellData("Prod_Config", 14, 2);
		Landno=ObjExcel.getCellData("Prod_Config", 15, 2);
		Mobno=ObjExcel.getCellData("Prod_Config", 16, 2);
		Email=ObjExcel.getCellData("Prod_Config", 17, 2);
		DropDownHelper.Select("Pcrouter", RouterOption);
		
		// Passing the value
		DropDownHelper.Select("Pcrouter", RouterOption);
		DropDownHelper.Select("Pco2", o2mob);
		DropDownHelper.Select("Pcorder", OrderType); //If transfer the condition is available in end of this method
		DropDownHelper.Select("Pcpackage", PackType);
		DropDownHelper.Select("Pcipadd", IpAdd);//If Static IP the condition is available in end of this method
		DropDownHelper.Select("Pccare", CarePack);
		TextBoxHelper.type("Pclandline", Landline);
		DropDownHelper.Select("Pcbbinstal", Bbinstal);
		if(Bbinstal!="At Company Address")
		{
			TextBoxHelper.type("Pccity", City);
			TextBoxHelper.type("Pcpostcode", Pcode);
		}
		TextBoxHelper.type("Pctitle", Title);
		TextBoxHelper.type("Pcfname", Fname);
		TextBoxHelper.type("Pclname", Lname);
		TextBoxHelper.type("Pclandno", Landno);
		TextBoxHelper.type("Pcmobno", Mobno);
		TextBoxHelper.type("Pcemail", Email);
		
		// if order type is transfer, MAC key need to be provided
		if(OrderType.equals("Transfer"))
		{
			//Thread.sleep(2000);
			System.out.println(OrderType);
			WebElement PcMac = (new WebDriverWait(driver,20)).until(ExpectedConditions.visibilityOfElementLocated(By.id("MAC_Key_0")));
			PcMac.sendKeys(MacKey);
		}
		
		//if IP is Static, IP usage need to be provided need to be provided
		if(IpAdd!="Dynamic")
		{
			WebElement Pcipusage = (new WebDriverWait(driver,20)).until(ExpectedConditions.visibilityOfElementLocated(By.id("IP_Address_Usage_0")));
			Pcipusage.sendKeys(IpUsage);
		}
		
		ButtonHelper.button("Pcfinish");
			
	}
			
		
}
	
	
	
	
	
		

