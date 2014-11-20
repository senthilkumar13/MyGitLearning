package com.o2.olympus.dev.ObjHelper;



import java.io.IOException;

import com.o2.olympus.dev.BaseUtility.BaseClass;


public class ButtonHelper extends BaseClass
{
public static void button(String identifier)
	{
	try
	{
		readObject(identifier).click();
	} catch(IOException e) 
	{
		e.printStackTrace();
		System.out.println("Failed to do action with button" + identifier);
	}
}
}