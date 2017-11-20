package bz.Java反射_很重要_里面有个配置文件_很重要;

/*
 * 反射：就是通过class文件对象，去使用该文件中的成员变量，构造方法，成员方法。
 * 
 * Person p = new Person();
 * p.使用
 * 
 * 要想这样使用，首先你必须得到class文件对象，其实也就是得到Class类的对象。
 * Class类：
 * 		成员变量	Field
 * 		构造方法	Constructor
 * 		成员方法	Method
 * 
 * 获取class文件对象的方式：
 * A:Object类的getClass()方法
 * B:数据类型的静态属性class
 * C:Class类中的静态方法
 * 		public static Class forName(String className)
 * 
 * 一般我们到底使用谁呢?
 * 		A:自己玩	任选一种，第二种比较方便
 * 		B:开发	第三种
 * 			为什么呢?因为第三种是一个字符串，而不是一个具体的类名。这样我们就可以把这样的字符串配置到配置文件中。
 */
public class B_反射机制入门 {
	public static void main(String[] args) throws ClassNotFoundException {
		// 方式1
		Person p = new Person();
		Class<? extends Person> c = p.getClass();

		Person p2 = new Person();
		Class<? extends Person> c2 = p2.getClass();

		System.out.println(p == p2);// false
		System.out.println(c == c2);// true				// 【因为返回值都是一个class的字节码类型的，都是Person的字节码类型的，所以返回值是true】

		System.out.println("------------");
		// 方式2
		Class<Person> c3 = Person.class;
		// int.class;
		// String.class;
		System.out.println(c == c3);//true

		System.out.println("------------");
		// 方式3
		// ClassNotFoundException
		Class<?> c4 = Class.forName("bz.Java特性_很重要.Person");		// 【这个方法很重要，因为可以在内存里实例化出一片空间】
		System.out.println(c == c4);//true
	}
}