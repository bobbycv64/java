package streamsFiles;

import java.io.InputStream;
import java.net.*;

public class UrlRead {
    public static void main(String[] args) {
	if (args.length < 1) {
	    System.out.println("Usage: java UrlRead {url}");
	    System.exit(1);
	}
	try {
	    URL url = new URL(args[0]);
	    URLConnection urlConn = url.openConnection();
	    InputStream in = urlConn.getInputStream();
	    byte[] buffer = new byte[1024];

	    int bytesRead; // bytes read
	    while((bytesRead = in.read(buffer)) >= 0) {
		System.out.write(buffer, 0, bytesRead);
	    }
	}
	catch(Exception exception) {
	    System.err.println("Some problem");
	    exception.printStackTrace(System.err);
	}
    }
}
