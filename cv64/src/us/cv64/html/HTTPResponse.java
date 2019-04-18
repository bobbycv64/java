package us.cv64.html;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLConnection;

public class HTTPResponse {

	private String httpVersionHeader;

	private String serverNameHeader;

	private String contentLengthHeader;

	private String contentTypeHeader;

	public HTTPResponse(File fileRequested) { // constructor
		String mimeType = URLConnection.guessContentTypeFromName(fileRequested.getName());

		this.httpVersionHeader = "HTTP1.1/200 OK\r\n";
		this.serverNameHeader = "Server: CS 6011 KROBINSON\r\n";
		this.contentLengthHeader = "Content-Length: " + fileRequested.length() + "\r\n";
		this.contentTypeHeader = "Content-Type: " + mimeType + "\r\n";
	}

	public void sendHttpResponseHeader(PrintWriter printwriter) {
		printwriter.write(this.httpVersionHeader);
		printwriter.write(this.serverNameHeader);
		printwriter.write(this.contentTypeHeader);
		printwriter.write(this.contentLengthHeader);
		printwriter.write("\r\n"); // new line to indicate end of header
		printwriter.flush();
	}

	public void sendHttpResponseBody(OutputStream outputToClient, File fileRequested)  {
		FileInputStream retrieveDataRequested = null;
		try {
			retrieveDataRequested = new FileInputStream(fileRequested);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] byteArray = new byte[1000]; // Reading data into byte array

		try {
			while (retrieveDataRequested.available() > 0) {
				int read = retrieveDataRequested.read(byteArray);
				outputToClient.write(byteArray, 0, read); // Reading from byte array to client output stream
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//outputToClient.flush(); // makes sure nothing is left in the stream
		//retrieveDataRequested.close();
	}

}