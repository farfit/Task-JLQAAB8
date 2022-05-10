package qaautomation.march2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

public class Task1 {

	public static void main(String[] args) {

		// Task1 - TreeMap
		System.out.println("TASK 1 - TreeMap");
		System.out.println("=================");
		TreeMap<Integer, String> languages = new TreeMap<Integer, String>();
		languages.put(200, "Java");
		languages.put(88, "Python");
		languages.put(97, "JavaScript");
		languages.put(12, "C++");

		Set set = languages.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			System.out.print("key is: " + mentry.getKey() + " & Value is: ");
			System.out.println(mentry.getValue());

		}

		// Task1 - TreeSet
		System.out.println("\nTASK 1 - TreeSet");
		System.out.println("=================");
		TreeSet<Integer> numbers = new TreeSet<>();
		numbers.add(100);
		numbers.add(102);
		numbers.add(108);
		numbers.add(101);
		numbers.add(99);

		for (Integer item : numbers) {
			System.out.println(item);
		}

	}
}
