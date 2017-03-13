package cs240.Iterator;
import java.util.NoSuchElementException;
import cs240.Hw2b.*;


public class SLQueueWithIterator<T> implements QueueInterface<T>{
	private Node firstNode;
	private Node lastNode;
	
	public SLQueueWithIterator(){
		firstNode = null;
		lastNode = null;
	}
	
	private class Node{
		private T data;
		private Node next;
		private Node(T dataPortion){
			this(dataPortion,null);
		}
		private Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
		@SuppressWarnings("unused")
		public void setData(T data){
			this.data = data;
		}
		@SuppressWarnings("unused")
		public void setNext(Node next){
			this.next = next;
		}
		public Node getNext(){
			return next;
		}
		public T getData(){
			return data;
		}
	}

	@Override
	public void enqueue(T newEntry) {
		// TODO Auto-generated method stub
		Node newNode = new Node(newEntry, null);
		if(isEmpty()){
			firstNode = newNode;
		}
		else{
			lastNode.next= newNode;
		}
		lastNode = newNode;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		T temp = null;
		if(!isEmpty()){
			temp = firstNode.getData();
			firstNode =(firstNode.getNext());
			if(firstNode == null){
				lastNode = null;
			}
		}
		return temp;
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		T temp = null;
		if(!isEmpty()){
			temp = firstNode.data;
		}
		return temp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (firstNode == null) && (lastNode == null);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		firstNode = null;
		lastNode = null;
	}
	public IteratorInterface<T> makeIterator(){
		return new Iterator();
	}
	private class Iterator implements IteratorInterface<T>{
		private Node itrNode = firstNode;
		
		@Override
		public boolean hasNext() {
			return itrNode != null;
		}
		@Override
		public T next() {
			if(hasNext()){
				T temp = itrNode.getData();
				itrNode= itrNode.getNext();
				return temp;
			}
			else{
				throw new NoSuchElementException("Illegal call to next(); End of Queue");
			}
		}
	}
	
}
