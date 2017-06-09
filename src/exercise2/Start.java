package exercise2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Start {

	public static void main(String[] args) {
		//Getting Test.class
		Class myTestClass = Test.class;

		try {
			//getting constructor of Test.class
			Constructor<Test> myTestConstructor = Test.class.getConstructor();

			//instantiating Test.class
			Test test = (Test) myTestConstructor.newInstance();

			//geting method to invoke
			Method method = myTestClass.getMethod("test", boolean.class);

			//Invoking method
			// will print 'Private String: privateString'
			method.invoke(test, true);

			// will print 'Public String: publicString'
			method.invoke(test, false);
			
			//accessing private field from Test.class object
			Field privateStringField = Test.class.getDeclaredField("privateString");
			privateStringField.setAccessible(true);
			
			String privateValue = (String) privateStringField.get(test);
			System.out.println(privateValue);
			
			//accessing public field from Test.class object
			Field publicStringField = Test.class.getField("publicString");

			String publicValue = (String) publicStringField.get(test);
			System.out.println(publicValue);

		} catch (NoSuchMethodException e) {
			System.out.println("No Such Method");
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("Security");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
