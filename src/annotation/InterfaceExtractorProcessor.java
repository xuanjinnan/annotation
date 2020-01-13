package annotation;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

public class InterfaceExtractorProcessor implements AnnotationProcessor {
	private final AnnotationProcessorEnvironment env = null;
	private ArrayList<MethodDeclaration> interfaceMethods = 
			new ArrayList<MethodDeclaration>();
	@Override
	public void process() {
		Collection<TypeDeclaration> typeDecs = env.getSpecifiedTypeDeclarations();
		for (TypeDeclaration typeDec1 : typeDecs) {
			ExtractInterface annot = typeDec1.getAnnotation(ExtractInterface.class);
			if(annot == null)
				break;
			Collection<? extends MethodDeclaration> methods = typeDec1.getMethods();
			for (MethodDeclaration m : methods) {
				if(m.getModifiers().contains(Modifier.PUBLIC)&&
						!(m.getModifiers().contains(Modifier.STATIC)))
					interfaceMethods.add(m);
			}
			if(interfaceMethods.size() > 0) {
				env.getf
			}
		}
	}

}
