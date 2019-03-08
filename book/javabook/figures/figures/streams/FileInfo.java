
import java.io.File;
import java.util.Date;

public class FileInfo {

    public static void main(String[] args) {
	String pathname = "."; // default
	if(args.length > 0) {
	    pathname = args[0];
	}
	
	File file = new File(pathname);
	String filename = file.getName();
	System.out.println();
	System.out.print("FileInfo: " + filename);
	if (!file.exists()) {
	    System.out.println(": No such file or directory");
	    System.exit(1);
	}
	
	System.out.println();
	System.out.println("Readable: " + file.canRead());
	System.out.println("Writable: " + file.canWrite());
	System.out.println("Absolute Path: " + file.isAbsolute());
	System.out.println("File: " + file.isFile());
	System.out.println("Directory: " + file.isDirectory());
	System.out.println("Hidden: " + file.isHidden());
	System.out.println("Last Modified: " + new Date(file.lastModified()));
	System.out.println("Length: " + file.length());
    }
}
