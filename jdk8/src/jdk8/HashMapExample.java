package jdk8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapExample {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("PostgreSQL", "Free Open Source Enterprise Database");
		map.put("DB2", "Enterprise Database , It's expensive");
		map.put("Oracle", "Enterprise Database , It's expensive");
		map.put("MySQL", "Free Open SourceDatabase (no more, try MariaDB)");

		// Get
		System.out.println(map.get("PostgreSQL")); // Free Open Source Enterprise Database

		// Update
		map.put("PostgreSQL", "Still the best!");
		System.out.println(map.get("PostgreSQL")); // Still the best!

		// @Since 1.8
		map.replace("PostgreSQL", "Still the best! 2");
		System.out.println(map.get("PostgreSQL")); // Still the best! 2

		// Remove
		map.remove("PostgreSQL");
		System.out.println(map.get("PostgreSQL")); // null

		// Size
		System.out.println(map.size()); // 3

		// loop
		System.out.println("Iterator loop...");
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
		}

		System.out.println("for loop...");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
		}

		// Java 8
		System.out.println("forEach loop...");
		map.forEach((key, value) -> System.out.println("[Key] : " + key + " [Value] : " + value));

		// clear everything
		map.clear();

		// nothing
		map.forEach((key, value) -> System.out.println("[Key] : " + key + " [Value] : " + value));

	}

}
