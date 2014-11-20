package DevOlympus;

import org.testng.annotations.Test;

import com.o2.olympus.dev.BaseUtility.BaseClass;
import com.o2.olympus.dev.ObjHelper.ButtonHelper;
import com.o2.olympus.dev.ObjHelper.DropDownHelper;
import com.o2.olympus.dev.ObjHelper.LinkHelper;
import com.o2.olympus.dev.ObjHelper.TextBoxHelper;
import com.o2.olympus.dev.ObjHelper.Xls_Reader;

public class Account extends BaseClass
{
	@Test
	public static void AccountCreation() throws InterruptedException
	{
		Thread.sleep(1000);
		String cellData;
		String filePath = "D:\\Senthil\\Project\\Scrum\\Selenium_Auto\\Olympus_Dev\\Test Data\\olympus_input.xlsx";
		Xls_Reader ObjExcel = new Xls_Reader(filePath);
		int accRow = ObjExcel.getRowCount("Account");
		for(int row=2;row<=accRow;row++)
		{
			String Temp=null;
			int accCol = ObjExcel.getColumnCount("Account");
			for(int column=0;column<accCol;column++)
			{
				cellData= ObjExcel.getCellData("Account", column, row);
				Temp=Temp+";"+cellData;
				
			}
			System.out.println(Temp);
			
			String excelInput[] = Temp.split(";");
			LinkHelper.Click("CAccount");
			ButtonHelper.button("Newbtn");
			DropDownHelper.Select("RecordType", "Customer Account");
			ButtonHelper.button("ContinueSavebtn");
			TextBoxHelper.type("Aname", excelInput[1]);
			TextBoxHelper.type("BillStreet",excelInput[2]);
			TextBoxHelper.type("BillCity",excelInput[3]);
			TextBoxHelper.type("BillState",excelInput[4]);
			TextBoxHelper.type("Postcode", excelInput[5]);
			TextBoxHelper.type("BillCountry", excelInput[6]);
			TextBoxHelper.type("Description", excelInput[7]);
			TextBoxHelper.type("DiseAccount", excelInput[8]);
			ButtonHelper.button("ContinueSavebtn");
				
		}
		
		
		
		
		
	}
}
