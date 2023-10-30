package utiles;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

public class CargarConfiguracion {

	public static HashMap<String, String> LoadConfigApp() {
		HashMap<String, String> config = new HashMap<String, String>();

		Thread currentThread = Thread.currentThread();
		ClassLoader contextClassLoader = currentThread.getContextClassLoader();
		URL resource = contextClassLoader.getResource("configuraciones.properties");

		if (resource == null) {
			System.out.println("no existe");
		}
		Properties prop = new Properties();

		try (InputStream is = resource.openStream()) {
			prop = new Properties();
			try {
				prop.load(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			config.put("JAVA_NAME", prop.getProperty("JAVA_NAME"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return config;

	}//

	public static HashMap<String, String> LoadConfigDataBase() {

		HashMap<String, String> config = new HashMap<String, String>();
		Properties prop = new Properties();

		Thread currentThread = Thread.currentThread();
		ClassLoader contextClassLoader = currentThread.getContextClassLoader();
		URL resource = contextClassLoader.getResource("configuraciones.properties");

		if (resource == null) {
			System.out.println("no existe");
		}

		try (InputStream is = resource.openStream()) {
			prop = new Properties();
			try {
				prop.load(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			config.put("JAVA_DB", prop.getProperty("JAVA_DB"));
			config.put("JAVA_USER", prop.getProperty("JAVA_USER"));
			config.put("JAVA_PASS", prop.getProperty("JAVA_PASS"));
			config.put("JAVA_URL_MYSQL", prop.getProperty("JAVA_URL_MYSQL_8.0"));
			config.put("JAVA_DRIVER", prop.getProperty("JAVA_DRIVER_8.0"));
			config.put("JAVA_CONFIG_TIME_ZONE", prop.getProperty("JAVA_CONFIG_TIME_ZONE"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return config;

	}//

}
