package cb.Java设计模式_极难度_慢慢理解_都很重要;

/*
	单例模式（Singleton）：
		是一种常用的设计模式。在Java应用中，单例对象能保证在一个JVM中，该对象只有一个实例存在。
	好处主要有：
		1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
		2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力。
	单例模式主要有两种实现方式：
		1、懒汉式；2、饿汉式
	缺点：这种做法在多线程环境下，不安全
*/

class 懒汉式 {
	private static 懒汉式 懒汉式 = null; // 【持有私有静态变量(也称类变量)，防止被引用 此处赋值为null，目的是实现延迟加载 (因为有些类比较庞大，所以延迟加载有助于提升性能)】

	private 懒汉式() { // 【私有构造方法，防止被实例化】
	}

	public static 懒汉式 get懒汉式() { // 【静态工厂方法，创建实例 --只不过这里是创建自己，而且只能创建一个】
		if (懒汉式 == null) {
			懒汉式 = new 懒汉式();
		}
		return 懒汉式;
	}
}

class 饿汉式 {
	private static 饿汉式 饿汉式 = new 饿汉式();

	private 饿汉式() {
	}

	public static 饿汉式 get饿汉式() {
		return 饿汉式;
	}
}

// 【如果考虑多线程，那么getInstance()方法要加同步synchronized，这时饿汉式比懒汉式要好，尽管资源利用率要差，但是不用同步。】
class 多线程饿汉式 {

	private static 多线程饿汉式 多线程饿汉式 = null;

	private 多线程饿汉式() {
	}
	
	private static synchronized void syncInit() {		// 【无所谓用不用分开写】
		多线程饿汉式 = new 多线程饿汉式();
	}

	public static 多线程饿汉式 get多线程饿汉式() {
		if (多线程饿汉式 == null) {
			syncInit();
		}
		return 多线程饿汉式;
	}
}

public class A_1单例设计模式_很重要 {
	public static void main(String[] args) {
		// 【调用懒汉式】
		懒汉式 s1 = 懒汉式.get懒汉式();
		懒汉式 s2 = 懒汉式.get懒汉式();
		System.out.println(s1 == s2); // 【运行结果为true，说明s1、s2这两个类变量都指向内存中的同一个对象】

		饿汉式 s3 = 饿汉式.get饿汉式();
		饿汉式 s4 = 饿汉式.get饿汉式();
		System.out.println(s3 == s4); // 【运行结果为true，说明s1、s2这两个类变量都指向内存中的同一个对象】
		
		多线程饿汉式 s5 = 多线程饿汉式.get多线程饿汉式();
		多线程饿汉式 s6 = 多线程饿汉式.get多线程饿汉式();
		System.out.println(s5 == s6); // 【运行结果为true，说明s1、s2这两个类变量都指向内存中的同一个对象】
	}
}
