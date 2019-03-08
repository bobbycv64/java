package cv64.streamsFiles;

import java.io.*;

public class LineRead {
    public static void main(String[] args) {
	try {
	    FileReader fr = new FileReader("linetext.txt");
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    while((line = br.readLine()) != null) { // null for EOF
		System.out.println(line);
	    }
	}
	catch(IOException exception) {
	    System.err.println("Problem reading");
	    exception.printStackTrace(System.err);
	}
    }
}
