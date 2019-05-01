package interfaceExample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Random rand = new Random();
		
		testAll();

		Location hogwarts = new Location("Hogwarts");
		Location ministry = new Location("Ministry of Magic");

		Message[] messages = new Message[5];
		try {
			Scanner scan = new Scanner(new File("HarryPotterQuotes.txt"));
			int i = 0;
			while (scan.hasNext() && i < 5) {
				Message msg = new Message("Message" + i, scan.nextLine(), rand.nextBoolean(), rand.nextBoolean());
				messages[i] = msg;
				i++;
			}
			scan.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not Found!");
			System.exit(1);
		}
		/*
		 * RandomUtility ru = new RandomUtility(); Owl[] owls = new Owl[5]; for (int i =
		 * 0; i < 5; i++) { Owl owl = new Owl ("Owl" + i, messages[i],
		 * ru.randomLocation(hogwarts, ministry), ru.randomDistance(), ru.randomSpeed(),
		 * ru.randomWingSpan()); owls[i] = owl; }
		 * 
		 * for (int i = 0; i < 24 * 60; i++) { for (int j = 0; j < owls.length; j++) {
		 * owls[j].fly(10); } }
		 * 
		 */
		testAll();

	}

	public static void testAll() {
		System.out.println("***************** TESTING EVERYTHING *****************");
		testLocation();
		testMessage();
		// testOwl();
	}

	/*
	 * public static void testOwl() { System.out.println("=====> Owl testing");
	 * Message m = new Message("m1", "Message", false, false); Location loc = new
	 * Location ("Test");
	 * 
	 * Owl owl1 = new Owl("owl", m, loc, 100, 60, 30); Owl owl2 = new Owl();
	 * owl2.setName("owl2"); owl2.setMessage(m); owl2.setDestination(loc);
	 * owl2.setWingSpan(25); owl2.setFlyingSpeed(40);
	 * owl2.setDistanceToDestination(200);
	 * 
	 * System.out.println("Owl1: " + owl1); System.out.println("Owl2: " + owl2);
	 * 
	 * System.out.println("name: " + owl1.getName()); System.out.println("message: "
	 * + owl1.getMessage()); System.out.println("destination: " +
	 * owl1.getDestination()); System.out.println("speed: " +
	 * owl1.getFlyingSpeed()); System.out.println("distance: " +
	 * owl1.getDistanceToDestination()); System.out.println("wing span: " +
	 * owl1.getWingSpan());
	 * 
	 * owl2.setDistanceToDestination (-5); System.out.println("distance: " +
	 * owl2.getDistanceToDestination()); owl2.setFlyingSpeed(-5);
	 * System.out.println("speed (should be 0): " + owl2.getFlyingSpeed());
	 * owl2.setFlyingSpeed(50); System.out.println("speed (should be 50): " +
	 * owl2.getFlyingSpeed()); owl2.setFlyingSpeed(101);
	 * System.out.println("speed (should be 0): " + owl2.getFlyingSpeed());
	 * owl2.setName(""); System.out.println("name: (should be default:" +
	 * owl2.getName()); owl2.setWingSpan(0);
	 * System.out.println("wing span (should be 20): " + owl2.getWingSpan());
	 * owl2.setWingSpan(30); System.out.println("wing span (should be 30): " +
	 * owl2.getWingSpan()); owl2.setWingSpan(61); System.out.println
	 * ("wing span (should be 20): " + owl2.getWingSpan());
	 * 
	 * 
	 * Owl owl1dup = new Owl ("owl", m, loc, 100, 60, 30);
	 * System.out.println("owl1 and owl1dup should not be ==: " + (owl1 ==
	 * owl1dup)); System.out.println("owl1 and owl1dup should be .equal: " +
	 * owl1.equals(owl1dup)); System.out.println("owl1 and owl2 should not be ==: "
	 * + (owl1 == owl2)); System.out.println("owl1 and owl2 should not be .equal: "
	 * + owl1.equals(owl2));
	 * 
	 * System.out.println ("Speed: " + owl1.getFlyingSpeed() + " distance: " +
	 * owl1.getDistanceToDestination()); owl1.fly(10); System.out.println ("Speed: "
	 * + owl1.getFlyingSpeed() + " distance: " + owl1.getDistanceToDestination());
	 * 
	 * System.out.println ("Deliver message: " ); owl1.setDistanceToDestination(5);
	 * owl1.fly(10); System.out.println ("Speed: " + owl1.getFlyingSpeed() +
	 * " distance: " + owl1.getDistanceToDestination());
	 * 
	 * }
	 * 
	 */

	public static void testMessage() {
		System.out.println("=====> Message testing");
		Message m1 = new Message("m1", "Not a howler", false, false);
		Message m2 = new Message("m2", "Howler", true, false);
		Message m1dup = new Message("m1", "Not a howler", false, false);

		System.out.println("m1: " + m1);
		System.out.println("m2: " + m2);

		System.out.println("id: " + m1.getId());
		System.out.println("message: " + m1.getMessage());
		System.out.println("howler? " + m1.getIsHowler());
		System.out.println("return receipt? " + m1.getReturnReceipt());

		System.out.println("m1 and m1dup should not be ==: " + (m1 == m1dup));
		System.out.println("m1 and m1dup should be .equal: " + m1.equals(m1dup));
		System.out.println("m1 and m2 should not be ==: " + (m1 == m2));
		System.out.println("m1 and m2 should not be .equal: " + m1.equals(m2));

		Message m3 = new Message();
		m3.setId("m3");
		m3.setMessage("message3");
		m3.setIsHowler(true);
		m3.setReturnReceipt(true);
		System.out.println(m3);

		System.out.println("m1 shouldn't howl: ");
		m1.howl();
		System.out.println("m2 should howl: ");
		m2.howl();

	}

	public static void testLocation() {

		System.out.println("=====> Location testing");
		Location loc1 = new Location("abc");
		Location loc2 = new Location("xyz");
		Location loc1dup = new Location("ABC");
		System.out.println("Loc1: " + loc1);
		System.out.println("Loc2: " + loc2);
		System.out.println("Loc 1 name: " + loc1.getName());
		System.out.println("Loc 2 name: " + loc2.getName());
		System.out.println("Loc1 and Loc2 should not be ==: " + (loc1 == loc2));
		System.out.println("Loc1 and Loc2 should not .equal: " + loc1.equals(loc2));
		System.out.println("Loc1 and Loc1dup should not be ==: " + (loc1 == loc1dup));
		System.out.println("Loc1 and loc1dup should be .equal: " + loc1.equals(loc1dup));

		System.out.println("*** Receive a message without return receipt");
		System.out.println("Should print the message, but not create a new one!");
		Message m = new Message("test", "message", false, false);
		
		Messenger messenger = new Bird(loc1, 50, 50);
		loc1.receiveMessage(m, messenger);

		m.setIsHowler(true);
		System.out.println("*** Receive a message without return receipt - Make sure it Howls");
		System.out.println("Should print the message, but not create a new one!");
		loc1.receiveMessage(m, null);

		System.out.println("*** Receive a message with return receipt");
		System.out.println("Should print the message, and create a new one!");
		Message m2 = new Message("test", "message2", false, true);
		loc1.receiveMessage(m2, null);

	}

}