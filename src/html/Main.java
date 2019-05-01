package html;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

	public static String getEntireRequestHeader(Scanner scanner) {

		String entireRequestHeader = "";

		while (true) {
			String line = scanner.nextLine();

			if (line.equals("")) { // if the header ends (we reach a blank line)
				break;
			} else {
				entireRequestHeader += line;
			}
		}
		return entireRequestHeader;
	}

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(8080);

		System.out.println("Listening for connection on port 8080...");

		// Main server loop (runs until program ends)

		while (true) {

			Socket clientSocket = serverSocket.accept(); // blocking method, does not proceed until client requests

			// Getting message from client browser

			Scanner scanner = new Scanner(clientSocket.getInputStream()); // get data from socket

			String entireRequestHeader = getEntireRequestHeader(scanner); // parse data we just got

			HTTPRequest httpRequest = new HTTPRequest(entireRequestHeader);

			File fileRequested = httpRequest.makeFileObject();

			// Create file object out of the file and use getLength() method

			PrintWriter headerPrintwriter = new PrintWriter(clientSocket.getOutputStream());

			if (!fileRequested.exists() || fileRequested.isDirectory()) {
				headerPrintwriter.write(("HTTP/1.1 404 not found\r\n"));
				headerPrintwriter.write("does not exist");
				headerPrintwriter.flush();
				clientSocket.close();
				return;
			}

			HTTPResponse httpResponse = new HTTPResponse(fileRequested);

			httpResponse.sendHttpResponseHeader(headerPrintwriter);

			// Getting requested data

			OutputStream htmlOutputStream = clientSocket.getOutputStream();

			httpResponse.sendHttpResponseBody(htmlOutputStream, fileRequested);

			clientSocket.close(); // response sent, so connection with client can end
			
			serverSocket.close();
		}
		

	}
}
