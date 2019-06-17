package fundamentals;

import java.util.Properties;

public class Environment {

	public static void main(String[] args) {
		Properties properties = System.getProperties();
		properties.list(System.out);
		
		String fs = properties.getProperty("file.separator");
		String javaVersion = properties.getProperty("java.version");
		
		System.out.println("File Separator: " + fs + " Java Version: " + javaVersion);
	}
}