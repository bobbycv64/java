// https://www.mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-example/
package fundamentals.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileExample1 {

	public static void main(String[] args) {

		String content = "This is the content to write into file\n";

		// If the file doesn't exists, create and write to it
		// If the file exists, truncate (remove all content) and write to it
		try (FileWriter fileWriter = new FileWriter("src\\fundamentals\\io\\FileExample1.txt");
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

			bufferedWriter.write(content);

		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
	}
}
