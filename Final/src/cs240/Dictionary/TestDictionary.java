package cs240.Dictionary;
import java.util.Iterator;
public class TestDictionary {
	public static void main(String[] args){
		VectorDictionary<String,Integer> myDic = new VectorDictionary<String,Integer>();
		Iterator<String> keyItr = myDic.getKeyIterator();
		Iterator<Integer> valueItr = myDic.getValueIterator();
		myDic.add("one", 1);
		myDic.add("two", 2);
		myDic.add("three",3);
		myDic.add("one", 1);
		myDic.add("four",4);
		myDic.add("two", 2);
		myDic.add("one", 12);
		myDic.add("four",4);
		myDic.add("five",5);
		myDic.add("five",5);
		myDic.add("five",5);
		myDic.add("six",6);
		myDic.add("seven",7);
		myDic.add("seven", 7);
		myDic.removeValue("one", 2);
		
		while(keyItr.hasNext()){
			System.out.println(keyItr.next());
		}
		System.out.println("*****************************************************");
		while(valueItr.hasNext()){
			System.out.println(valueItr.next());
		}
		System.out.println("*****************************************************");
		System.out.println(myDic.getValue("one").peekItem(0));
		System.out.println(myDic.getValue("two").peekItem(1));
		myDic.remove("one");
		myDic.remove("two");
		System.out.println("*****************************************************");
		valueItr = myDic.getValueIterator();
		while(valueItr.hasNext()){
			System.out.println(valueItr.next());
		}
		myDic.clear();
		myDic.print();
	}
}
