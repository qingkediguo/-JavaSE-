package bz.Java反射_很重要_里面有个配置文件_很重要;

import java.lang.reflect.Constructor;

/*
 * 需求：通过反射去获取该构造方法并使用：
 * public Person(String name, int age, String address)
 * 
 * Person p = new Person("林青霞",27,"北京");
 * System.out.println(p);
 */
public class D_反射机制获得指定参数的构造方法 {
	public static void main(String[] args) throws Exception {
		// 获取字节码文件对象
		Class<?> c = Class.forName("bz.Java特性_很重要.Person");

		// 获取带参构造方法对象
		// public Constructor<T> getConstructor(Class<?>... parameterTypes)			// 【...是不定参数，有可能有不同个数的参数】
		Constructor<?> con = c.getConstructor(String.class, int.class, String.class);	// 【一定是有.class的】

		// 通过带参构造方法对象创建对象
		// public T newInstance(Object... initargs)
		Object testObj = con.newInstance("林青霞", 27, "北京");

		System.out.println(testObj);
	}
}