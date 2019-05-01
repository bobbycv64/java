
import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/java-util-dictionary-class-java/
// look at this example on the Internet, showing the Dictionary class in Java
public class Game {
	public static void main(String[] args) {
		System.out.println("Game Start");
		
		Map<Integer, String> map = new HashMap<>();
		map.put(0, "X");
		System.out.println(map.get(0));
		
		// DictionaryInterface is the design, with no implementation
		// Board Class is where the implementation is developed
		DictionaryInterface<Integer, String> board = new Board<>();
		board.add(2, "Y");
		System.out.println(board.getValue(2));

		System.out.println("Game End");
	}
}
