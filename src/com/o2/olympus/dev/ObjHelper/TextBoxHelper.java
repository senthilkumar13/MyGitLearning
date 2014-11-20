package com.o2.olympus.dev.ObjHelper;


import java.io.IOException;

import com.o2.olympus.dev.BaseUtility.BaseClass;

public class TextBoxHelper extends BaseClass {
	
	public static void type(String identifier, String value){
		try {
			readObject(identifier).clear();
			readObject(identifier).sendKeys(value);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to do action with TextBox" + identifier);
		}
	}

}
