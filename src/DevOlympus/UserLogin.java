package DevOlympus;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.o2.olympus.dev.BaseUtility.BaseClass;
import com.o2.olympus.dev.ObjHelper.Excel2edition;
import com.o2.olympus.dev.ObjHelper.LinkHelper;
import com.o2.olympus.dev.ObjHelper.TextBoxHelper;
import com.o2.olympus.dev.ObjHelper.Xls_Reader;

public class UserLogin extends BaseClass 
{
@Test
	public static void Alogin() throws Exception
	{
		String filePath = "D:\\Senthil\\Project\\Scrum\\Selenium_Auto\\Olympus_Dev\\Test Data\\olympus_input.xlsx";
		Xls_Reader ObjExcel = new Xls_Reader(filePath);
		
		String usrname = ObjExcel.getCellData("Login", 0, 2);
		String uPass= ObjExcel.getCellData("Login", 1, 2);
		//System.out.println(usrname);
		//System.out.println(uPass);
		Thread.sleep(2000);
		TextBoxHelper.type("Username", usrname);
		TextBoxHelper.type("Password", uPass);
		LinkHelper.Click("Login");
		/*Thread.sleep(2000);
		LinkHelper.Click("Pview");
		LinkHelper.Click("MProfile");
		LinkHelper.Click("MPbtn");
		LinkHelper.Click("UserDetail");
		String Pusrname = driver.findElement(By.xpath("//*[@id='ep']/div[2]/div[2]/table/tbody/tr[4]/td[2]")).getText();
		if(Pusrname.equalsIgnoreCase(usrname))
		{
			System.out.println("Login Successful");
		}
		
		else
		{
			System.out.println("Login Failed");
		}*/
	}
	
}
