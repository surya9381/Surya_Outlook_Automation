package org.genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {

	public String getPropertyKeyValue(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(ipathconstant.PROPERTYFILE_PATH);
		Properties pro=new Properties();
		pro.load(fis);
		String value=pro.getProperty(key);
		return value;
	}
}
