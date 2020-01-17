package annotations;

import onjava.atunit.Test;
import onjava.atunit.TestObjectCreate;

public class AtunitExample3 {
	private int n;
	public AtunitExample3(int n) {
		this.n = n;
	}
	public int getN(){
		return n;
	}
	public String methodOne(){
		return "This is methodOne";
	}
	public int methodTwo(){
		System.out.println("This is methodTwo");
		return 2;
	}
	@TestObjectCreate
	static AtunitExample3 creat(){
		return new AtunitExample3(47);
	}
	@Test
	boolean initialization(){
		return n == 47;
	}
	@Test
	boolean methodOneTest(){
		return methodOne().equals("This is methodOne");
	}
	@Test
	boolean m2(){
		return methodTwo() == 2;
	}

}
