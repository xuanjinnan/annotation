package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
	public static void main(String[] args) throws Exception {
		args = new String[]{"annotation.Member"};
		if(args.length <1 ) {
			System.out.println("arguments: annotated classes");
			System.exit(0);
		}
		for(String className : args) {
			Class<?> cl = Class.forName(className);
			DBTable dbTable = cl.getAnnotation(DBTable.class);
			if(dbTable == null) {
				System.out.println("No DBTable annotations in class " + className);
				continue;
			}
			String tableName = dbTable.name();
			//if the name is empty,use the Class name
			if(tableName.length() < 1)
				tableName = cl.getName().toUpperCase();
			List<String> columnDefs = new ArrayList<String>();
			for(Field field : cl.getDeclaredFields()) {
				Annotation[] anns = field.getAnnotations();
				if(anns.length < 1)
					continue;
				String columnName = null;
				if(anns[0] instanceof SQLInteger) {
					SQLInteger sInt = (SQLInteger) anns[0];
					// Use field name if name not specified
					if(sInt.name().length() < 1) {
						columnName = field.getName().toUpperCase();
					}else {
						columnName = sInt.name();
					}
					columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
				}
				if(anns[0] instanceof SQLString) {
					SQLString sStr = (SQLString) anns[0];
					columnName = sStr.name();
					if(columnName.length() < 1)
						columnName = field.getName().toUpperCase();
					columnDefs.add(columnName + " VARCHAR(" + sStr.value() +")" + getConstraints(sStr.constraints()));
				}
				StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
				for(String columnDef : columnDefs)
					createCommand.append("\n	" + columnDef + ",");
				String tableCreate = createCommand.substring(0, createCommand.length() - 1 ) + ")";
				System.out.println("Table.Creation SQL for " + className +" is:\n" + tableCreate);
			}
		}

	}

	private static String getConstraints(Constraints con) {
		String contraints = "";
		if(!con.allowNull()) {
			contraints += " NOT NULL";
		}
		if(con.primaryKey())
			contraints += " PRAMARY KEY";
		if(con.unique())
			contraints += " UNIQUE";
		return contraints;
	}
}
