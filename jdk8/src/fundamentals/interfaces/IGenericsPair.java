package fundamentals.interfaces;

public interface IGenericsPair<K, V> {
	public K getKey();
	public V getValue();
	public void setKey(K k);
	public void setValue(V v);
}
