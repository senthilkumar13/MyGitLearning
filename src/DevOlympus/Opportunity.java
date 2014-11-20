package DevOlympus;

//import java.awt.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.o2.olympus.dev.BaseUtility.BaseClass;
import com.o2.olympus.dev.ObjHelper.ButtonHelper;
import com.o2.olympus.dev.ObjHelper.DropDownHelper;
import com.o2.olympus.dev.ObjHelper.LinkHelper;
import com.o2.olympus.dev.ObjHelper.TextBoxHelper;
import com.o2.olympus.dev.ObjHelper.Xls_Reader;

public class Opportunity extends BaseClass
{
	@Test
	public static void oppCreation()
	{
		String filePath = "D:\\Senthil\\Project\\Scrum\\Selenium_Auto\\Olympus_Dev\\Test Data\\olympus_input.xlsx";
		String Opname,Aname,AccValue,CurrPage,OcreRef=null;
		 
		WebElement AccName;
		Xls_Reader ObjExcel = new Xls_Reader(filePath);
		
		CurrPage = driver.getTitle();
				
		//creating opportunity in sequence of Account & Contact
		if(CurrPage.startsWith("Business Account") || CurrPage.startsWith("Contact"))
		{
		ButtonHelper.button("OppSeq");
		}
		else
		{
		LinkHelper.Click("OppDirect");
		ButtonHelper.button("Newbtn");
		}
		DropDownHelper.Select("Otype","Configurator");
		ButtonHelper.button("ContinueSavebtn");
		Opname=ObjExcel.getCellData("Opportunity", 0, 2);
		TextBoxHelper.type("Oname",Opname);
		AccName=driver.findElement(By.xpath("//*[@id='opp4']"));
		AccValue= AccName.getAttribute("value");
		if(AccValue.equals(""))
		{
			Aname=ObjExcel.getCellData("Opportunity", 1, 2);
			TextBoxHelper.type("Oaname",Aname);
		}
		DropDownHelper.Select("Ostage", "Awareness of Needs");
		LinkHelper.Click("Ocdate");
		
		// Date picker code - will work after
		/*DateFormat dateFormat2 = new SimpleDateFormat("dd"); 
        Date date2 = new Date();

        String strToday = dateFormat2.format(date2); 
        int temptoday = Integer.parseInt(strToday); 
        String today =  String.valueOf(temptoday).toString();

        //find the calendar
        WebElement dateWidget = driver.findElement(By.id("datePickerCalendar"));  
        List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  

        //comparing the text of cell with today's date and clicking it.
        for (WebElement cell : columns) {
        if (cell.getText().equals(today)) {
        cell.click();
        break;
        }*/
		
		OcreRef=ObjExcel.getCellData("Opportunity", 2, 2);
		TextBoxHelper.type("OcreditRef", OcreRef);
		DropDownHelper.Select("OcreditStatus", "Accepted");
		LinkHelper.Click("OcreditDate");
		ButtonHelper.button("ContinueSavebtn");
		
		}
	}


	
