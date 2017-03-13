package cs240.Iterator;

public class TestIterator {
	public static void main(String[] args){
		VectorStackWithIterator<String> myStack = new VectorStackWithIterator<String>();
		IteratorInterface<String> itrStack = myStack.makeIterator();
		SLQueueWithIterator<String> myQueue = new SLQueueWithIterator<String>();
		VectorListWithIterator<Integer> myList = new VectorListWithIterator<Integer>();
		IteratorInterface<Integer> itrList = myList.makeIterator();
		myStack.push("A");
		myStack.push("B");
		myStack.push("C");
		myStack.push("D");
		myStack.push("E");
		myStack.push("F");
		myStack.push("G");
		myStack.push("H");
		myStack.push("I");
		myStack.push("J");
		for(int i = 0; i < 10; i++){
			myQueue.enqueue("A" +i);
		}
		for(int i = 0;i < 10;i++){
			myList.addItem(i);
		}
		IteratorInterface<String> itrQueue = myQueue.makeIterator();
		
		while(itrStack.hasNext()){
			System.out.println(itrStack.next());
		}
		while(itrQueue.hasNext()){
			System.out.println(itrQueue.next());
		}
		while(itrList.hasNext()){
			System.out.println(itrList.next());
		}	
	}
}
