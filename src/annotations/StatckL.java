package annotations;

import java.util.LinkedList;

public class StatckL<T> {
	
	private LinkedList<T> list = new LinkedList<>();
	
	public void push(T v){list.addFirst(v);}
	
	public T top(){return list.getFirst();}
	
	public T pop(){return list.removeFirst();}

}
