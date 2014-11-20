package com.o2.olympus.dev.ObjHelper;



import org.openqa.selenium.support.ui.Select;

import com.o2.olympus.dev.BaseUtility.BaseClass;

public class DropDownHelper extends BaseClass {
	
	public static void Select(String identifier, String ObjValue)
	
	{
		try {
		
			Select select = new Select(readObject(identifier));
			select.selectByVisibleText(ObjValue);	
			
		} catch (Exception e) {
			
			// e.printStackTrace();
			//System.out.println("Failed to do action with DropDown" + identifier);
		}
	}

}
