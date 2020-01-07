package annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UseCaseTracker {

	public UseCaseTracker() {
		// TODO Auto-generated constructor stub
	}
	public static void trackUseCases(List<Integer> useCases,Class<?> cl){
		Method[] methods = cl.getDeclaredMethods();
		for (Method method : methods) {
			UseCase us = method.getAnnotation(UseCase.class);
			if(us != null){
				System.out.println("Found Use Case:" + us.id() + " " + us.description());
				useCases.remove(new Integer(us.id()));
			}
		}
		for(int i : useCases)
			System.out.println("Warning: Missing use case-" + i);
	}
	public static void main(String[] args) {
		trackUseCases(Arrays.asList(47,48,49,50), PasswordUtils.class);
	}
}
