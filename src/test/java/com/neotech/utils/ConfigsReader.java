package com.neotech.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

	
	private static Properties prop;
	
	public static void readProperties(String path) 
	{
		
		FileInputStream fis;
		try 
		{
		  fis= new FileInputStream(path);
		  prop=new Properties();
		  prop.load(fis);
		  fis.close();
		}catch(FileNotFoundException a) 
		{
			a.printStackTrace();
		}catch(IOException a) 
		{
			a.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	public static String getProperty(String key) 
	{
		return prop.getProperty(key);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
