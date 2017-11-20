package az.List子类;

import java.util.LinkedList;

class Mystack {
	private LinkedList<Object> link;

	public Mystack() {
		link = new LinkedList<Object>();
	}

	public void add(Object obj) {
		link.addFirst(obj);
	}

	public Object get() {
		// return link.getFirst();
		return link.removeFirst();
	}

	public boolean isEmpty() {
		return link.isEmpty();
	}
}


/*
 * MyStack的测试
 */
public class E_自定义栈 {
	public static void main(String[] args) {
		// 创建集合对象
		Mystack ms = new Mystack();

		// 添加元素
		ms.add("hello");
		ms.add("world");
		ms.add("java");

		// System.out.println(ms.get());
		// System.out.println(ms.get());
		// System.out.println(ms.get());
		// NoSuchElementException
		// System.out.println(ms.get());
		
		while(!ms.isEmpty()){
			System.out.println(ms.get());
		}
	}
}