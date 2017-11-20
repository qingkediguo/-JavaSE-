package at.StringBuffer;

/*
 * 线程安全(将会在多线程讲解)
 * 安全 -- 同步 -- 数据是安全的
 * 不安全 -- 不同步 -- 效率高一些
 * 安全和效率问题是永远困扰我们的问题。
 * 安全：医院的网站，银行网站
 * 效率：新闻网站，论坛之类的
 * 
 * StringBuffer:
 * 		线程安全的可变字符串。
 * 
 * StringBuffer和String的区别?
 * 前者长度和内容可变，后者不可变。
 * 如果使用前者做字符串的拼接，不会浪费太多的资源。
 * 
 * StringBuffer的构造方法：
 * 		public StringBuffer():无参构造方法
 *		public StringBuffer(int capacity):指定容量的字符串缓冲区对象
 *		public StringBuffer(String str):指定字符串内容的字符串缓冲区对象
 *
 * StringBuffer的方法：
 *		public int capacity()：返回当前容量。	理论值
 *		public int length():返回长度（字符数）。 实际值
 */

// 【这里要注意：方法的length()和普通的length取长度】

//【补充！！】
//StringBuilder与 StringBuffer
//StringBuilder：线程非安全的
//StringBuffer：线程安全的
//当我们在字符串缓冲去被多个线程使用是，JVM不能保证StringBuilder的操作是安全的，虽然他的速度最快，
//但是可以保证StringBuffer是可以正确操作的。当然大多数情况下就是我们是在单线程下进行的操作，
//所以大多数情况下是建议用StringBuilder而不用StringBuffer的，就是速度的原因。


//对于三者使用的总结： 
//1.如果要操作少量的数据用 = String
//2.单线程操作字符串缓冲区 下操作大量数据 = StringBuilder
//3.多线程操作字符串缓冲区 下操作大量数据 = StringBuffer


public class A_StringBuffer概念_以及三种String缓存区简述 {
	public static void main(String[] args) {
		// public StringBuffer():无参构造方法
		StringBuffer sb = new StringBuffer();
		System.out.println("sb:" + sb);
		System.out.println("sb.capacity():" + sb.capacity());
		System.out.println("sb.length():" + sb.length());
		System.out.println("--------------------------");

		// public StringBuffer(int capacity):指定容量的字符串缓冲区对象
		StringBuffer sb2 = new StringBuffer(50);
		System.out.println("sb2:" + sb2);
		System.out.println("sb2.capacity():" + sb2.capacity());
		System.out.println("sb2.length():" + sb2.length());
		System.out.println("--------------------------");

		// public StringBuffer(String str):指定字符串内容的字符串缓冲区对象
		StringBuffer sb3 = new StringBuffer("hello");
		System.out.println("sb3:" + sb3);
		System.out.println("sb3.capacity():" + sb3.capacity());
		System.out.println("sb3.length():" + sb3.length());
	}
}