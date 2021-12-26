package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {


	public static Properties userData = loadProperties(System.getProperty("user.dir")+"\\src\\main\\resources\\app.properties");
	
	/**
	 * This method is used to load properties for the keyword driven.
	 * 
	 * @param path the property path for the "app.properties" file.
	 * @return return the property value.
	 */
	
	private static Properties loadProperties(String path) {

		Properties pro = new Properties();

		try {

			FileInputStream stream = new FileInputStream(path);
			pro.load(stream); 

		} catch (FileNotFoundException e) {
			System.out.println("Error occurred: "+ e.getMessage());
		} catch (IOException e) {
			System.out.println("Error occurred: "+ e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Error occurred: "+ e.getMessage());
		}

		return pro;

	}

}
