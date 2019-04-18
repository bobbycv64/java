package us.cv64.html;

import java.io.File;
import java.io.PrintWriter;
import java.net.Socket;

public class HTTPRequest {

	private String entireRequestHeader; // entire request header

	private String fileRequested; // path to file user requested

	private String httpMethod; // GET, POST, etc.

	public HTTPRequest(String entireRequestHeader) { // constructor
		String headerWord[] = entireRequestHeader.split(" ");
		this.httpMethod = headerWord[0];
		this.fileRequested = headerWord[1];
	}

	public File makeFileObject() {
		String filename = this.fileRequested;

		if (filename.equals("/")) {
			filename = "resources/index.html";
		} else {
			filename = "resources/" + filename;
		}

		return new File(filename);
	}

	// public void checkIfFileValid(PrintWriter printwriter, Socket clientSocket) {
	// this.fileRequested
	//
	// printwriter.write(("HTTP/1.1 404 not found\r\n"));
	// printwriter.write("does not exist");
	// printwriter.flush();
	// clientSocket.close();
	// }
}