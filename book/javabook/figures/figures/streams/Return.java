
import java.io.*;
    
public class Return {
    // command line usage
    public static void main(String[] args) {
	int returnValue = Return.Main(args);
	System.exit(returnValue);
    }

    // call directly from java program as shown above
    public static int Main(String[] args) {
	int returnValue = 0;
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
	    returnValue = 1;
	}
	return returnValue;
    }
}
