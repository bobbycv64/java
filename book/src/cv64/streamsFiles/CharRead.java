package cv64.streamsFiles;

import java.io.*;

public class CharRead {
    public static void main(String[] args) {
	try {
	    FileReader fr = new FileReader("linetext.txt");
	    int c;
	    while((c = fr.read()) != -1) { // -1 for EOF
		System.out.print((char)c);
	    }
	}
	catch(IOException exception) {
	    System.err.println("Problem reading");
	    exception.printStackTrace(System.err);
	}
    }
}
