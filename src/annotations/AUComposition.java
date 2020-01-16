package annotations;

import onjava.atunit.Test;

public class AUComposition {
	AtUnitExample1 testObject = new AtUnitExample1();
	@Test
	boolean tMethodOne() {
		return testObject.methodOne().equals("This is methodOne");
	}
	@Test
	boolean tMethodTwo() {
		return testObject.methodTwo() == 2;
	}
}
