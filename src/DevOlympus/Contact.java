package DevOlympus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.o2.olympus.dev.BaseUtility.BaseClass;
import com.o2.olympus.dev.ObjHelper.ButtonHelper;
import com.o2.olympus.dev.ObjHelper.DropDownHelper;
import com.o2.olympus.dev.ObjHelper.TextBoxHelper;
import com.o2.olympus.dev.ObjHelper.Xls_Reader;

public class Contact extends BaseClass
{
	@Test
public static void contactCreation() //Seq & Direct till to work on

	{
		String filePath = "D:\\Senthil\\Project\\Scrum\\Selenium_Auto\\Olympus_Dev\\Test Data\\olympus_input.xlsx";
		Xls_Reader ObjExcel = new Xls_Reader(filePath);
		WebElement AccName;
		String AccValue, Aname,Cname;
		ButtonHelper.button("Ncontact");
		//DropDownHelper.Select("Ctype", "Default"); admin role
		Cname=ObjExcel.getCellData("Contact", 0, 2);
		TextBoxHelper.type("Clastname", Cname);
		AccName=driver.findElement(By.id("con4"));
		AccValue= AccName.getAttribute("value");
		if(AccValue.equals(""))
		{
			Aname = ObjExcel.getCellData("Contact", 1, 2);
			TextBoxHelper.type("Caname", Aname);
		}
		
		DropDownHelper.Select("Crole", "COP - Centre of Power");
		ButtonHelper.button("ContinueSavebtn");
		
	}	

}
