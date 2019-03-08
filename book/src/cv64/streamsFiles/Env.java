package cv64.streamsFiles;

import java.util.Properties;

public class Env {

	public static void main(String[] args) {
		Properties properties = System.getProperties();
		properties.list(System.out);
	}
}
