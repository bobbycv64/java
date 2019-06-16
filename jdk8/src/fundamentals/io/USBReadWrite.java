package fundamentals.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class USBReadWrite {

	private Scanner scanner = new Scanner(System.in);
	private BufferedReader bufferedReader = null;
	private BufferedWriter bufferedWriter = null;

	public USBReadWrite() {

		System.out.println("Do you want to read or write (R - Read or W - Write): ");
		String readWrite = scanner.next();

		if (readWrite.equalsIgnoreCase("r")) {
			readUSB();
		} else {
			writeUSB();
		}
	}

	private void readUSB() {

		String record = "";

		try {
			System.out.println("Enter USB Path including the file name:, e.g. /media/rwe001/4C3D-170D/readFile.in :");
			String usbFilename = scanner.next();
			FileReader fileReader = new FileReader(usbFilename);

			bufferedReader = new BufferedReader(fileReader);

			while ((record = bufferedReader.readLine()) != null) {
				System.out.println(record);
			}

			bufferedReader.close();

		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * C:\\users\\bobby\\writeFile.out
	 */
	private void writeUSB() {
		try {
			System.out.println("Enter USB Path including the file name:, e.g. /media/rwe001/4C3D-170D/writeFile.out :");
			String usbFilename = scanner.next();
			System.out.println("Enter text to write to the file: ");
			String content = scanner.next();
			FileWriter fileWriter = new FileWriter(usbFilename);

			bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(content);
			bufferedWriter.close();

		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		new USBReadWrite();
	}
}
