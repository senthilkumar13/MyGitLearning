package com.o2.olympus.dev.ObjHelper;

import java.io.IOException;

import com.o2.olympus.dev.BaseUtility.BaseClass;

public class ImageHelper extends BaseClass 
{

	public static void image(String identifier) 
	
	{

		{
			try
			{
				readObject(identifier).click();
			} catch(IOException e) 
			{
				e.printStackTrace();
				System.out.println("Failed to do action with image" + identifier);
			}
		}

	}
}
