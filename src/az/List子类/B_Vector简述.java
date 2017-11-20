package az.List子类;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/*
 * Vector的特有功能：
 * 1：添加功能
 * 		public void addElement(Object obj)		--	add()
 * 2：获取功能
 * 		public Object elementAt(int index)		--  get()
 * 
 * 		☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆	// 【经过测试，vector也是可以用iterator的】
 * 		public Enumeration elements()			--	Iterator iterator()
 * 				boolean hasMoreElements()		--	hasNext()
 * 				Object nextElement()			--	next()
 * 
 * JDK升级的原因：
 * 		A:安全
 * 		B:效率
 * 		C:简化书写
 */
public class B_Vector简述 {
	public static void main(String[] args) {
		// 创建集合对象
		Vector<String> v = new Vector<String>();

		// 添加功能
		v.addElement("hello");
		v.addElement("world");
		v.addElement("java");

		// 遍历
		for (int x = 0; x < v.size(); x++) {
			String s = (String) v.elementAt(x);
			System.out.println(s);
		}

		System.out.println("------------------");
		
		Iterator<String> it = v.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("------------------");
		
		Enumeration<String> en = v.elements(); // 返回的是实现类的对象
		while (en.hasMoreElements()) {
			String s = (String) en.nextElement();
			System.out.println(s);
		}
	}
}