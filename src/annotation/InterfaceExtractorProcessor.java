package annotation;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.ParameterDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

public class InterfaceExtractorProcessor implements AnnotationProcessor {
	private final AnnotationProcessorEnvironment env;
	private ArrayList<MethodDeclaration> interfaceMethods = 
			new ArrayList<MethodDeclaration>();
	
	public InterfaceExtractorProcessor(AnnotationProcessorEnvironment env) {
		this.env = env;
	}

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
				try {
					PrintWriter writer = env.getFiler().createSourceFile(annot.value());
					writer.println("package " + typeDec1.getPackage().getQualifiedName() + ";");
					writer.println("public interface " + annot.value() + " {");
					for(MethodDeclaration m : methods){
						writer.print(" public ");
						writer.print(m.getReturnType() + " ");
						writer.print(m.getSimpleName() + " (");
						int i = 0;
						for(ParameterDeclaration parm : m.getParameters()){
							writer.print(parm.getType() + " " + parm.getSimpleName());
							if(i++ < m.getParameters().size())
								writer.print(", ");
						}
						writer.println(");");
					}
					writer.println("}");
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
