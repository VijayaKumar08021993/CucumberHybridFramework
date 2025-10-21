package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class Utilities {
	public Utilities() {
		prop = new Properties();
	}
	public  Properties prop;
	

	public static String getTimeStamp() {
		Date date = new Date();
		String getDateTimeWithEmailId = date.toString().replace(" ", "_").replace(":", "_");
		return "1a" + getDateTimeWithEmailId + "@gmail.com";
	}

	public  Properties getProperty() throws IOException  {
		try (InputStream input = Utilities.class.getClassLoader()
				.getResourceAsStream("config/correctConfig.properties")) {
			if (input == null) {
				throw new FileNotFoundException("Property file not found in classpath");
			}
			prop.load(input);
		}
		return prop;
	}



}
