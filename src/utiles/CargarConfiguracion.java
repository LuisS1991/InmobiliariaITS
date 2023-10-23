package utiles;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class CargarConfiguracion {

	public static HashMap<String, String> LoadConfigApp() {
		HashMap<String, String> config = new HashMap<String, String>();
		File archivo = new File("src/configuraciones.properties");
		Properties prop = new Properties();

		InputStream inputStream;
		try {
			inputStream = new FileInputStream(archivo);
			prop = new Properties();
			try {
				prop.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			config.put("JAVA_NAME", prop.getProperty("JAVA_NAME"));		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return config;

	}//

	public static HashMap<String, String> LoadConfigDataBase() {
		
		HashMap<String, String> config = new HashMap<String, String>();
		File archivo = new File("src/configuraciones.properties");
		Properties prop = new Properties();

		InputStream inputStream;
		try {
			inputStream = new FileInputStream(archivo);
			prop = new Properties();
			try {
				prop.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			config.put("JAVA_DB", prop.getProperty("JAVA_DB"));
			config.put("JAVA_USER", prop.getProperty("JAVA_USER"));
			config.put("JAVA_PASS", prop.getProperty("JAVA_PASS"));
			config.put("JAVA_URL_MYSQL_8.0", prop.getProperty("JAVA_URL_MARIA_DB"));
			config.put("JAVA_DRIVER_8.0", prop.getProperty("JAVA_DRIVER_MARIA_DB"));
			config.put("JAVA_CONFIG_TIME_ZONE", prop.getProperty("JAVA_CONFIG_TIME_ZONE"));			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return config;

	}//

}
