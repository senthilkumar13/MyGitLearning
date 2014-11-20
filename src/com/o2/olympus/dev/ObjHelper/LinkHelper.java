package com.o2.olympus.dev.ObjHelper;



import java.io.IOException;

import com.o2.olympus.dev.BaseUtility.BaseClass;
public class LinkHelper extends BaseClass {
	
	public static void Click(String identifier){
		try {
			
			readObject(identifier).click();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to do action with Link" + identifier);
		}
	}
	
	public static String GetText(String identifier){
		try
		{
			
			String LnkName = readObject(identifier).getText();
			
			return LnkName;
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Failed to do action with Link" + identifier);
		}
		return identifier;
		
	}

}
