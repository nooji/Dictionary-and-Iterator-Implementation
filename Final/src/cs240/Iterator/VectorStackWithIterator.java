package cs240.Iterator;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Vector;

import cs240.Hw2.*;

public class VectorStackWithIterator<T> implements StackInterface<T>{
	private Vector<T> bag;
	public VectorStackWithIterator(){
		bag = new Vector<T>();
	}
	public Vector<T> getBag(){
		return bag;
	}
	@Override
	public void push(T newEntry) {
		bag.addElement(newEntry);
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new EmptyStackException();
		}
		else{
			T temp = bag.lastElement();
			bag.remove(bag.indexOf(bag.lastElement()));
			//bag.remove(bag.capacity()-1);
			return temp;
		}
	}
	
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new EmptyStackException();
		else
			return bag.lastElement();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return bag.isEmpty();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		bag.clear();
	}
	
	public IteratorInterface<T> makeIterator(){
		return new Iterator();
	}
	
	private class Iterator implements IteratorInterface<T>{
		private int position;
		public Iterator(){
			position = 0;
		}
		@Override
		public boolean hasNext() {
			return position < bag.size();
		}
		@Override
		public T next() {
			if(hasNext()){
				T temp;
				temp = bag.get(position++);
				return temp;
			}
			else{
				throw new NoSuchElementException("Illegal call to next(); End of Stack.");
			}
		}
	}
}
