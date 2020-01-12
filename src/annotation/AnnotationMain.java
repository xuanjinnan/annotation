package annotation;

import net.mindview.util.OSExecute;

public class AnnotationMain {

	public AnnotationMain() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		OSExecute.command("javac -processor annotation.SimpleProcessor annotation.SimpleTest.java");
	}
}
