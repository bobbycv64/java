package cv64.streamsFiles;

import java.io.*;

public class Stdin {
    public static void main(String[] args) {
	InputStream is = System.in;
	try {
	    int c;
	    while((c = is.read()) != -1) {
		System.out.print((char)c);
	    }
	}
	catch(IOException exception) {
	    System.err.println("Problem reading");
	    exception.printStackTrace(System.err);
	}
    }
}
