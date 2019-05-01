package html;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.activation.MimetypesFileTypeMap;
//import javafx.scene.shape.Path;
import java.io.*;

public class JavaHTTPServer {

	public static void main(String[] args) throws IOException {

		// Creating server socket at port 8080

		ServerSocket serverSocket = new ServerSocket(8080);
		System.out.println("Listening for connection on port 8080...");

		// Main server loop (runs until program quit)

		while (true) {
			Socket clientSocket = serverSocket.accept(); // blocking method, does not proceed until client requests

			// Getting message from client browser

			Scanner scanner = new Scanner(clientSocket.getInputStream());
			String line = scanner.nextLine();

			// Filename string parsing from client request

			String entireString = "";

			while (true) {
				String temp = scanner.nextLine();
				if (temp.equals("")) {
					break;
				} else {
					entireString += temp;
					System.out.println(entireString);
				}
			}

			String splitStr[] = line.split(" ");
			String resource = splitStr[1];
			System.out.println(resource);

			// Create file object out of the file and use getLength() method

			String filename = "resources/" + resource;
			File file = new File(filename); // resource?
			PrintWriter headerOuts = new PrintWriter(clientSocket.getOutputStream());

			if (!file.exists() || file.isDirectory()) {
				headerOuts.println("HTTP/1.1 404 ok");
				headerOuts.println();
				headerOuts.flush();
				headerOuts.close();
				clientSocket.close();
			}

			headerOuts.write("HTTP1.1/200 OK\r\n");
			headerOuts.write("Server: CS 6011 KROBINSON\r\n");
			headerOuts.write("Content-Length: " + file.length() + "\r\n");
			headerOuts.write("Content-Type: text/html\r\n");
			headerOuts.write("\r\n"); // blank line to indicate end of header
			headerOuts.flush();

			// Getting requested data from html file

			FileInputStream htmlIns = new FileInputStream(filename);
			OutputStream htmlOuts = clientSocket.getOutputStream();

			// Reading data into byte array, then from byte array to client output stream

			byte[] byteArray = new byte[1000];

			while (htmlIns.available() > 0) {
				int read = htmlIns.read(byteArray); // read() returns the next byte of data, or -1 if the end of the
													// file is reached
				htmlOuts.write(byteArray, 0, read);
			}

			htmlOuts.flush();

			clientSocket.close(); // response sent, so connection with client can end
		}
	}
}