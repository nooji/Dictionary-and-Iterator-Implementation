package cs240.Dictionary;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;


import cs240.hw3.VectorList;
public class VectorDictionary<K,V> implements DictionaryInterface<K,V>{
	private Vector<Node> dictionary;
	public VectorDictionary(){
		dictionary = new Vector<Node>();
	}
	@Override
	public void add(K key, V value) {
		if(!contains(key)){
			dictionary.add(new Node(key,value));
		}
		else{
			dictionary.elementAt(getIndex(key)).addValue(value);
		}
	}

	@Override
	public VectorList<V> remove(K key) {
		VectorList<V> temp = null;
		if(contains(key)){
			temp =dictionary.elementAt(getIndex(key)).getValue();
			dictionary.remove(getIndex(key));
		}
		return temp;
	}
	@Override
	public VectorList<V> getValue(K key) {
		if(contains(key)){
			return dictionary.elementAt(getIndex(key)).getValue();
		}
		else{
			throw new NoSuchElementException("That key does not exist.");
		}
	}

	@Override
	public boolean contains(K key) {
		
		boolean result = false;
		/*for(int i = 0; i < dictionary.size();i++){
			if(dictionary.elementAt(i).getKey() == key){
				result = true;
			}
		}
		*/
		Iterator<K> itr = getKeyIterator();
		while(itr.hasNext()){
			if(itr.next() == key){
				result = true;
			}
		}
		
		return result;
	}
	
	public int getIndex(K key){
		int result = 0;
		if(contains(key)){
			for(int i = 0; i < dictionary.size();i++){
				if(dictionary.elementAt(i).getKey() == key){
					result = i;
				}
			}
			return result;
		}
		else{
			throw new NoSuchElementException();
		}
	}

	@Override
	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	}
	private class KeyIterator implements Iterator<K>{
		int position;
		public KeyIterator(){
			position = 0;
		}

		@Override
		public boolean hasNext() {
			return position < dictionary.size();
		}

		@Override
		public K next() {
			K temp = dictionary.elementAt(position++).getKey();
			return temp;
		}
	}
	private class ValueIterator implements Iterator<V>{
		private int keyPosition;
		private int valuePosition;
		public ValueIterator(){
			keyPosition = 0;
			valuePosition = 0;
		}

		@Override
		public boolean hasNext() {
			return keyPosition < dictionary.size();
		}

		@Override
		public V next() {
			V temp;
			/*
			if((keyPosition+1)== dictionary.size() && (valuePosition+1)== dictionary.elementAt(keyPosition).getValue().checkCount()){
				return temp = dictionary.elementAt(keyPosition++).getValue().peekItem(valuePosition);
			}
			else if(!(valuePosition < dictionary.elementAt(keyPosition).getValue().checkCount())){
				keyPosition+=1;
				valuePosition =0;
			}
			if((keyPosition+1)== dictionary.size() && (valuePosition+1)== dictionary.elementAt(keyPosition).getValue().checkCount()){
				return temp = dictionary.elementAt(keyPosition++).getValue().peekItem(valuePosition);
			}
			*/
			if(!(valuePosition < dictionary.elementAt(keyPosition).getValue().checkCount())){
				keyPosition+=1;
				valuePosition =0;
			}
			if((keyPosition+1)== dictionary.size() && (valuePosition+1)== dictionary.elementAt(keyPosition).getValue().checkCount()){
				return temp = dictionary.elementAt(keyPosition++).getValue().peekItem(valuePosition);
			}
			temp = dictionary.elementAt(keyPosition).getValue().peekItem(valuePosition++);
			return temp;
		}
	}
	@Override
	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	}

	@Override
	public boolean isEmpty() {
		return dictionary.isEmpty();
	}

	@Override
	public int getSize() {
		return dictionary.size();
	}

	@Override
	public void clear() {
		dictionary.clear();
	}
	public void print(){
		for(int i = 0; i <dictionary.size();i++){
			System.out.print(dictionary.elementAt(i).getKey() + " : " );
			dictionary.elementAt(i).getValue().peekAll();
		}
	}
	private class Node{
		private K key;
		private VectorList<V> value;
		private Node(K key, V tempValue){
			value = new VectorList<V>();
			this.key = key;
			this.value.addItem(tempValue);
		}
		private K getKey(){
			return key;
		}
		private VectorList<V> getValue(){
			return value;
		}
		private void addValue(V temp){
			value.addItem(temp);
		}
	}
}
