package generics;

//Set OrderedPair Class as a Generic Pair implementing a Generic Pair Interface
public class OrderedPair<K, V> implements Pair<K, V> {

	// T - type parameters
	private K key = null;
	private V value = null;

	// T - type arguments
	public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
		System.out.println("OrderedPair.set:  key: " + key + " value: " + value);
	}

	// T - return a Type
	public K getKey() {
		System.out.println("OrderedPair.getKey: " + key);
		return key;
	}

	// T - return a Type
	public V getValue() {
		System.out.println("OrderedPair.getValue: " + key);
		return value;
	}
}