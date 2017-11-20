package az.List子类;

import java.util.LinkedList;

/*
 * LinkedList的特有功能：
 * 		A:添加功能
 * 			public void addFirst(Object e)
 * 			public void addLast(Object e)
 * 		B:获取功能
 * 			public Object getFirst()
 * 			public Obejct getLast()
 * 		C:删除功能
 * 			public Object removeFirst()		// 【也就是说删除元素的时候他也会返回一个被删除的元素】
 * 			public Object removeLast()
 */
public class C_LinkedList简述 {
	public static void main(String[] args) {
		// 创建集合对象
		LinkedList<String> link = new LinkedList<String>();

		// 添加元素
		link.add("hello");
		link.add("world");
		link.add("java");
		link.add("qingke");

		// public void addFirst(Object e)
		// link.addFirst("javaee");
		// public void addLast(Object e)
		// link.addLast("android");

		// public Object getFirst()
		// System.out.println("getFirst:" + link.getFirst());
		// public Obejct getLast()
		// System.out.println("getLast:" + link.getLast());

		// public Object removeFirst()
		System.out.println("removeFirst:" + link.removeFirst());
		// public Object removeLast()
		System.out.println("removeLast:" + link.removeLast());

		// 输出对象名
		System.out.println("link:" + link);
	}
}