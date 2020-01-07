package annotation;

public class Testable {

	public void excute(){
		System.out.println("Executing...");
	}
	@Test void testExecute(){excute();}
	public static void main(String[] args) {
		new Testable().testExecute();
	}

}
