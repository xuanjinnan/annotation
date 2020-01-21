package annotations;

import java.io.IOException;
import java.io.PrintWriter;

import onjava.atunit.Test;
import onjava.atunit.TestObjectCleanup;
import onjava.atunit.TestObjectCreate;
import onjava.atunit.TestProperty;

public class AtUnitExample5 {
	private String text;
	
	public AtUnitExample5(String text) {
		this.text = text;
	}
	@Override
	public String toString(){return text;}
	
	@TestProperty
	static PrintWriter output;

	@TestProperty
	int counter;
	
	@TestObjectCreate
	static AtUnitExample5 create(){
		String id = Integer.toBinaryString(1);
		try{
			output = new PrintWriter("Test" + id + ".txt");
		}catch(IOException e){
			throw new RuntimeException(e);
		}
		return new AtUnitExample5(id);
	}
	
	@TestObjectCleanup
	static void cleanup(AtUnitExample5 tobj){
		System.out.println("Running cleanup");
		output.close();
	}
	
	@Test 
	boolean test1(){
		output.print("test1");
		System.out.println(counter);
		return true;
	}
	
	@Test
	boolean test2(){
		output.print("test2");
		return true;
	}
	
	@Test
	boolean test3(){
		output.print("test3");
		return true;
	}
}
