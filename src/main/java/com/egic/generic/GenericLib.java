package com.egic.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GenericLib 

	{
		public static String dir= System.getProperty("user.dir");
		public static String osName = System.getProperty("os.name");
		
		public static String getValue(String filepath, String key)
		{
			String value = null;
			
			try 
			{
				Properties prop= new Properties();
				FileInputStream fis = new FileInputStream(new File(filepath));
				prop.load(fis);
				value = prop.getProperty(key);
					
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			return value;
		}
	}

