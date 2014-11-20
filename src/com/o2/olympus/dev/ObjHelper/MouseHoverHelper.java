package com.o2.olympus.dev.ObjHelper;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.o2.olympus.dev.BaseUtility.BaseClass;

public class MouseHoverHelper extends BaseClass {
	
	public static void MouseHover(String identifier)
	
	{
		try {
		
					
			WebElement Region = readObject(identifier);
			Actions Act = new Actions(driver);
			Act.moveToElement(Region).build().perform();
			
			
		} catch (Exception e) {
			
			// e.printStackTrace();
			//System.out.println("Failed to do action with DropDown" + identifier);
		}
	}

}
