package com.o2.olympus.dev.ObjHelper;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;

import com.o2.olympus.dev.BaseUtility.BaseClass;

public class RadioBoxHelper extends BaseClass
{

	public static void select(String identifier)
	{

		{
			try
			{
				readObject(identifier).click();
			} catch(IOException e) 
			{
				e.printStackTrace();
				System.out.println("Failed to select" + identifier);
			}
		}
	}
	
}
