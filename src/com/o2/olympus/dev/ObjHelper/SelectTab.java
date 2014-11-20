package com.o2.olympus.dev.ObjHelper;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.o2.olympus.dev.BaseUtility.BaseClass;

public class SelectTab extends BaseClass {
	
	public static void Select (String TabName)
	
	{
		try {
		
			WebElement tab = driver.findElement(By.className("tabs"));
			List<WebElement> TabCnt = tab.findElements(By.tagName("li"));
			
			for(int i=0; i<=TabCnt.size(); i++)
			{
				String tabName = TabCnt.get(i).getText();
				System.out.println(tabName);
				if (tabName.equals(TabName))
				{
					TabCnt.get(i).click();
					break;
				}
				
			}
				
			
		} catch (Exception e) {
			
			// e.printStackTrace();
			//System.out.println("Failed to do action with DropDown" + identifier);
		}
	}

}
