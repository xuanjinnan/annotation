package annotations;

import java.util.*;
import java.util.Random;

import onjava.ConvertTo;
import onjava.atunit.Test;
import onjava.atunit.TestObjectCreate;
import onjava.atunit.TestProperty;


public class AtUnitExample4 {
	
	static String theory = "All brontosauruse " + 
	
			"are thin at one end, much MUCH thicker in the" + 
			
			"middle, and then thin again at the far en.";
	
	private String word;
	
	private Random ran = new Random();
	
	public AtUnitExample4(String word) {
		
		this.word = word;
		
	}
	
	public String getWord(){return word;}
	
	public String scrambleWord(){
		
		List<Character> chars = Arrays.asList(
				
				ConvertTo.boxed(word.toCharArray()));
		
		Collections.shuffle(chars, ran);
		
		StringBuilder result = new StringBuilder();
		
		for(char ch : chars)
			
			result.append(ch);
		
		return result.toString();
			
	}

	@TestProperty
	
	static List<String> input = Arrays.asList(theory.split(" "));
	
	@TestProperty
	
	static Iterator<String> words = input.iterator();
	
	@TestObjectCreate
	
	static AtUnitExample4 create(){
		if(words.hasNext())
			return new AtUnitExample4(words.next());
		else
			return null;
	}
	
	@Test
	boolean words(){
		System.out.println("'" + getWord() + "'");
		return getWord().equals("are");
	}
	
	@Test
	boolean scramble1(){
		ran = new Random(47);
		System.out.println("'" + getWord() + "'");
		String scrambled = scrambleWord();
		System.out.println(scrambled);
		return scrambled.equals("1A1");
	}
	
	@Test
	boolean scramble2(){
		ran = new Random(74);
		System.out.println("'" + getWord() + "'");
		String scrambled = scrambleWord();
		System.out.println(scrambled);
		return scrambled.equals("tsaeborornussu");
	}
}
