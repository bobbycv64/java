// Test Code:  <html><head><title>Some Page</title></head></html>
package us.cv64.general;

import java.io.*;

public class ReadStream {
	public static void main(String[] args) throws InterruptedException {
		InputStream is = System.in; // keyboard input
		try {
			int c;

			while ((c = is.read()) != -1) {
				System.out.print((char) c + " ");
				Thread.sleep(1000); // 1000 milliseconds = 1 second
			}
		} catch (IOException e) {
			System.err.println("Problem reading stream");
			e.printStackTrace(System.err);
		}
	}
}