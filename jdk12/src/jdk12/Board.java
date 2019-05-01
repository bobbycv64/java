package jdk12;

import java.util.Iterator;

public class Board<K, V> implements DictionaryInterface<K, V> {
	
	private Board<K, V> dictionary = null;
	private K key = null;
	private V value = null;

	public Board() {
	}

	@Override
	public V add(K key, V value) {
		dictionary.add(key, value);
		return value;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V getValue(K key) {
		return dictionary.getValue(key);
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<K> getKeyIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<V> getValueIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}
