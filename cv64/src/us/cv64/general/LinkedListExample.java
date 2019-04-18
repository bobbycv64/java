package us.cv64.general;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {

	private static String FILENAME = "Hangman.txt";
	private LinkedList<String> linkedList = new LinkedList<String>();
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	private Timestamp[] timestampArray = new Timestamp[4];

	public LinkedListExample() {
		readFile();
		getLinkedList();
		iterateLinkedList();
		printTimestamps();
	}

	private void readFile() {

		String record = "";

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME))) {
			while ((record = bufferedReader.readLine()) != null) {
				linkedList.add(record);
			}

		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	private void getLinkedList() {
		timestampArray[0] = new Timestamp(System.currentTimeMillis());

		for (int i = linkedList.size() - 1; i != -1; i--) {
			System.out.print(linkedList.get(i) + "\t");

			if (i % 4 == 0)
				System.out.println();
		}

		timestampArray[1] = new Timestamp(System.currentTimeMillis());
	}

	private void iterateLinkedList() {
		timestampArray[2] = new Timestamp(System.currentTimeMillis());

		Iterator<String> iterator = linkedList.descendingIterator();
		int i = 0;
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + "\t");

			if (i++ % 4 == 0)
				System.out.println();
		}

		timestampArray[3] = new Timestamp(System.currentTimeMillis());
	}

	private void printTimestamps() {
		System.out.println();
		for (int i = 0; i < timestampArray.length; i++) {
			System.out.println(timestampArray[i]);
		}
	}

	public static void main(String[] args) {
		new LinkedListExample();
	}
}
