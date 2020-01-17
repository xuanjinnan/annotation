package annotations;

import java.util.HashSet;

import onjava.atunit.Test;

public class HashSetTest {

	HashSet<String> testObject = new HashSet<>();
	@Test
	void initialization(){
		assert testObject.isEmpty();
	}
	@Test
	void _Contains(){
		testObject.add("one");
		assert testObject.contains("one");
	}
	@Test
	void _Remove(){
		testObject.add("one");
		testObject.remove("one");
		assert testObject.isEmpty();
	}
}
