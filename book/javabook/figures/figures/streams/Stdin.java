
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
	catch(IOException e) {
	    System.err.println("Problem reading");
	    e.printStackTrace(System.err);
	}
    }
}
