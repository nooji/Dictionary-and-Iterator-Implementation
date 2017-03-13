package cs240.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

import cs240.hw3.ListInterface;
public class VectorListWithIterator<T> implements ListInterface<T> {
private Vector<T> list;
	
	public VectorListWithIterator(){
		list = new Vector<T>();
	}
	@Override
	public void addItem(T newEntry) {
		list.addElement(newEntry);
	}

	@Override
	public void addItem(T newEntry, int index) {
		list.add(index, newEntry);
	}

	@Override
	public T removeItem(int index) {
		return list.remove(index);
	}

	@Override
	public void removeAll() {
		list.clear();
	}

	@Override
	public T replaceItem(T newEntry, int index) {
		return list.set(index, newEntry);
	}

	@Override
	public T peekItem(int index) {
		return list.get(index);
	}

	@Override
	public void peekAll() {
		for(int i = 0; i < list.size();i++){
			System.out.println(list.get(i));
		}
	}

	@Override
	public boolean checkItem(T newEntry) {
		return list.contains(newEntry);
	}

	@Override
	public int checkCount() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	public IteratorInterface<T> makeIterator(){
		return new Iterator();
	}
	public class Iterator implements IteratorInterface<T>{
		private int position;
		public Iterator(){
			position = 0;
		}
		@Override
		public boolean hasNext() {
			return position < list.size();
		}

		@Override
		public T next() {
			if(hasNext()){
				T temp;
				temp = list.get(position++);
				return temp;
			}
			else{
				throw new NoSuchElementException("Illegal call to next(); End of List.");
			}
		}
		
	}
}
