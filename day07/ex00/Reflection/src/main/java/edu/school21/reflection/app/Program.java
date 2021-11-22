package edu.school21.reflection.app;
import edu.school21.reflection.user.User;
import edu.school21.reflection.car.Car;

import com.thoughtworks.qdox.JavaDocBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.thoughtworks.qdox.model.JavaSource;

import java.lang.reflect.*;
import java.util.Scanner;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public class Program {
	public static void main(String[] args) throws FileNotFoundException {
		JavaDocBuilder	jpb = new JavaDocBuilder();
		jpb.addSource(new FileReader("./day07/ex00/Reflection/src/main/java/edu/school21/reflection/app/Program.java"));
		Integer			sizeOfImports = 0;

		JavaSource	src = jpb.getSources()[0];
		String[]	srcImports = src.getImports();
		for ( ; sizeOfImports < srcImports.length; ++sizeOfImports) {
			if (srcImports[sizeOfImports].compareTo("com.thoughtworks.qdox.JavaDocBuilder") == 0)
				break ;
		}
		if (sizeOfImports == 0) {
			System.out.println("There is no classes to work with, exit...");
			System.exit(0);
		}
		System.out.println("Classes:");
		String[]		dealWith = new String[sizeOfImports];
		for (int i = 0; i < sizeOfImports; ++i) {
			String[]	tmp = srcImports[i].split("\\u002e");
			dealWith[i] = tmp[tmp.length - 1];
			System.out.println(dealWith[i]);
		}
		String	delimeter = "---------------------";
		System.out.println(delimeter);

		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\\u000a");
		System.out.println("Enter class name");
		boolean	loopHero = true;
		Class	objWeNeed = null;
		while (loopHero) {
			String	target = sc.next();
			for (int i = 0;  i < sizeOfImports; ++i) {
				if (dealWith[i].compareTo(target) == 0 ||
					srcImports[i].compareTo(target) == 0) {
					loopHero = false;
					try {
						objWeNeed = Class.forName(srcImports[i]);
					} catch (ClassNotFoundException exc) { exc.printStackTrace(); }
					break ;
				}
			}
			if (loopHero == true)
				System.out.println("There is no such class in list above, try again...");
		}
		if (objWeNeed == null) {
			System.err.println("Error: class object was not fetched, session is going to be terminated...");
			System.exit(-1);
		}
		System.out.println(delimeter);
		Field[]		objWeNeedFields = objWeNeed.getDeclaredFields();
		System.out.println("fields: ");
		for (Field subj : objWeNeedFields) {
			String[]	tmp = subj.getType().toString().split("\\u002e");
			System.out.println('\t' + tmp[tmp.length - 1]+ ' ' + subj.getName());
		}
		System.out.println("methods: ");
		Method[]	objWeNeedMethods = objWeNeed.getDeclaredMethods();
		for (Method subj : objWeNeedMethods) {
			String 		returnType = subj.getGenericReturnType().getTypeName();
			String[]	tmp = returnType.split("\\u002e");
			if (returnType.compareTo("void") != 0)
				System.out.print('\t' + tmp[tmp.length - 1] + ' ' + subj.getName() + '(');
			Class[]	parameterType = subj.getParameterTypes();
			String	parameters = "";
			for (Class jObj : parameterType) {
				String[]	secTmp = jObj.getName().split("\\u002e");
				parameters += secTmp[secTmp.length - 1] + ", ";
			}
			if (!parameters.isEmpty())
				parameters = parameters.substring(0, parameters.length() - 2);
			System.out.println(parameters + ')');
		}
		System.out.println(delimeter);
		System.out.println("Let's create an object:");
		Class[]		params = new Class[objWeNeedFields.length];
		Object[]	values = new Object[objWeNeedFields.length];
		for (int i = 0; i < objWeNeedFields.length; ++i) {
			params[i] = objWeNeedFields[i].getType();
			System.out.println(objWeNeedFields[i].getName() + ':');
			String	parse;
			parse = sc.next();
			String	typeParse = params[i].getName();
			if (params[i].getName().compareTo("int") == 0)
				values[i] = Integer.parseInt(parse);
			else if (params[i].getName().compareTo("double") == 0)
				values[i] = Double.parseDouble(parse);
			else if (params[i].getName().compareTo("float") == 0)
				values[i] = Float.parseFloat(parse);
			else if (params[i].getName().compareTo("java.lang.String") == 0)
				values[i] = parse;
			else if (params[i].getName().compareTo("boolean") == 0)
				values[i] = Boolean.parseBoolean(parse);
			else
				values[i] = null;
		}
		Constructor cons = null;
		try {
			cons = objWeNeed.getConstructor(params);
		} catch (NoSuchMethodException exc) { exc.printStackTrace(); System.exit(-1);}
		Object	newInstance = null;
		try {
			newInstance = cons.newInstance(values);
		} catch (InstantiationException | IllegalAccessException
			| IllegalArgumentException | InvocationTargetException exc) {
			exc.printStackTrace();
			System.exit(-1);
		}
		System.out.println("Object created: " + newInstance.toString());
		System.out.println(delimeter);
		System.out.println("Enter name of field for changing: ");
		loopHero = true;
		while (loopHero) {
			String	paramToChange = sc.next();
			for (int i = 0; i < objWeNeedFields.length; ++i) {
				if (paramToChange.compareTo(objWeNeedFields[i].getName()) == 0) {
					loopHero = false;
					String		type = objWeNeedFields[i].getType().toString();
					String[]	tmp = objWeNeedFields[i].getType().toString().split("\\u002e");
					System.out.println("Enter " + tmp[tmp.length - 1] + " value:");
					Object		replace = null;
					String		strParse = sc.next();
					Field		fieldToSet = null;
					if (type.compareTo("int") == 0)
						replace = Integer.parseInt(strParse);
					else if (type.compareTo("double") == 0)
						replace = Double.parseDouble(strParse);
					else if (params[i].getName().compareTo("float") == 0)
						replace = Float.parseFloat(strParse);
					else if (params[i].getName().compareTo("java.lang.String") == 0)
						replace = strParse;
					else if (params[i].getName().compareTo("boolean") == 0)
						replace = Boolean.parseBoolean(strParse);
					try {
						fieldToSet = newInstance.getClass().getDeclaredField(paramToChange);
					} catch (NoSuchFieldException | SecurityException exc) { exc.printStackTrace(); System.exit(-1);}
					fieldToSet.setAccessible(true);
					try { fieldToSet.set(newInstance, replace); }
					catch (IllegalArgumentException | IllegalAccessException exc) { exc.printStackTrace(); System.exit(-1); }
				}
			}
			if (loopHero == false)
				break ;
			System.out.println("Error: " + paramToChange + ": there is no such field in " + objWeNeed.getName());
		}
		System.out.println("Object updated: " + newInstance.toString());
		System.out.println(delimeter);
		System.out.println("Enter name of the method to call:");
		loopHero = true;
		String	returnType = null;
		Object	methodResult = null;
		while (loopHero) {
			String	methodToCall = sc.next();
			for (int i = 0; i < objWeNeedMethods.length; ++i) {
				String methodToCallCompare = "";
				methodToCallCompare += objWeNeedMethods[i].getName() + "(";
				Class[]	parameterTypes = objWeNeedMethods[i].getParameterTypes();
				for (Class jObj : parameterTypes) {
					String[]	secTmp = jObj.getName().split("\\u002e");
					methodToCallCompare += secTmp[secTmp.length - 1] + ",";
				}
				if (!methodToCallCompare.isEmpty())
					methodToCallCompare = methodToCallCompare.substring(0,
						methodToCallCompare.length() - 1);
				methodToCallCompare += ')';
				if (methodToCall.compareTo(methodToCallCompare) == 0) {
					loopHero = false;
					returnType = objWeNeedMethods[i].getReturnType().getName();
					Integer		paramArgsLength = parameterTypes.length;
					Object[]	paramValues = new Object[paramArgsLength];
					for (int j = 0; j < paramArgsLength; ++j) {
						String	pTypeTmp = parameterTypes[j].getName();
						System.out.println("Enter " + pTypeTmp + " value:");
						String	tmp = sc.next();
						if (pTypeTmp.compareTo("int") == 0)
							paramValues[j] = Integer.parseInt(tmp);
						else if (pTypeTmp.compareTo("double") == 0)
							paramValues[j] = Double.parseDouble(tmp);
						else if (pTypeTmp.compareTo("float") == 0)
							paramValues[j] = Float.parseFloat(tmp);
						else if (pTypeTmp.compareTo("java.lang.String") == 0)
							paramValues[j] = tmp;
						else if (pTypeTmp.compareTo("boolean") == 0)
							paramValues[i] = Boolean.parseBoolean(tmp);
					}
					Method method = null;

					try {
						method = newInstance.getClass().getDeclaredMethod(objWeNeedMethods[i].getName(), parameterTypes);
					} catch (SecurityException | NoSuchMethodException exc) { exc.printStackTrace(); System.exit(-1);}
					method.setAccessible(true);
					try {
						if (returnType.compareTo("void") != 0)
							methodResult = method.invoke(newInstance, paramValues);
					}
					catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException exc) {
						exc.printStackTrace(); System.exit(-1); }
				}
			}
			if (loopHero == false)
				break ;
			System.out.println("Error: " + methodToCall + ": there is no such method in " + objWeNeed.getName());
		}
		if ( methodResult == null )
			System.out.println("Method does return nothing");
		else System.out.println("Method returned: ");
			System.out.println(methodResult.toString());
		}
	}
