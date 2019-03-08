package us.cv64.fundamentals.interfce;

public class GenericsPair<K, V> implements IGenericsPair<K, V> {

	private K k;
	private V v;
	
	public GenericsPair(K k, V v) {
		this.k = k;
		this.v = v;
	}
	
	@Override
	public K getKey() {
		return k;
	}
	
	@Override
	public void setKey(K k) {
		this.k = k;
	}

	@Override
	public V getValue() {
		return v;
	}
	
	@Override
	public void setValue(V v) {
		this.v = v;
	}

    public static <K, V> boolean compare(IGenericsPair<K, V> pair1, IGenericsPair<K, V> pair2) {
        return pair1.getKey().equals(pair2.getKey()) &&
        		pair1.getValue().equals(pair2.getValue());
    }
	
	public static void main(String[] args) {
		IGenericsPair<String, Integer> pair1 = new GenericsPair<>("String", 64);
		IGenericsPair<String, Integer> pair2 = new GenericsPair<>("String", 64);
		IGenericsPair<String, Integer> pair3 = new GenericsPair<>("String", 13);
		IGenericsPair<String, String>  pair4 = new GenericsPair<>("String1", "String2");
		
		System.out.println("pair 1: " + pair1.getKey() + ":" + pair1.getValue());
		System.out.println("pair 2: " + pair2.getKey() + ":" + pair2.getValue());
		System.out.println("pair 3: " + pair3.getKey() + ":" + pair3.getValue());
		System.out.println("pair 4: " + pair4.getKey() + ":" + pair4.getValue());
		
		System.out.println("pair 1 and pair 2 a match: " + GenericsPair.compare(pair1, pair2));
		System.out.println("pair 1 and pair 3 a match: " + GenericsPair.compare(pair1, pair3));
		//System.out.println("pair 2 and pair 3 a match: " + GenericsPair.compare(pair1, pair4));
	}
}
