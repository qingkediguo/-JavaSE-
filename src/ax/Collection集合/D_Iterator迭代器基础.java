package ax.Collection集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * Iterator iterator():迭代器，集合的专用遍历方式
 * 		Object next():获取元素,并移动到下一个位置。
 * 			// NoSuchElementException：没有这样的元素，因为你已经找到最后了。
 * 		boolean hasNext():如果仍有元素可以迭代，则返回 true。（
 */
public class D_Iterator迭代器基础 {
	public static void main(String[] args) {
		// 创建集合对象
		Collection<String> c = new ArrayList<String>();

		// 创建并添加元素
		// String s = "hello";
		// c.add(s);
		c.add("hello");
		c.add("world");
		c.add("java");

		// Iterator iterator():迭代器，集合的专用遍历方式
		Iterator<String> it = c.iterator(); // 实际返回的肯定是子类对象，这里是多态☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
											// 【在这里复习多态】
											// iterator是个接口，这里就相当于是直接有了一个iterator对象

		
		// Object obj = it.next();
		// System.out.println(obj);
		// System.out.println(it.next());
		// System.out.println(it.next());
		// System.out.println(it.next());
		// System.out.println(it.next());
		// 最后一个不应该写，所以，我们应该在每次获取前，如果有一个判断就好了
		// 判断是否有下一个元素，有就获取，没有就不搭理它

		// if (it.hasNext()) {
		// System.out.println(it.next());
		// }
		// if (it.hasNext()) {
		// System.out.println(it.next());
		// }
		// if (it.hasNext()) {
		// System.out.println(it.next());
		// }
		// if (it.hasNext()) {
		// System.out.println(it.next());
		// }
		// if (it.hasNext()) {
		// System.out.println(it.next());
		// }

		// 最终版代码
		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);
			// Object s = it.next();
			// System.out.println((String)s);
		}
		System.out.println("=============");
		// 【究极版】不过上面的能应对更多的情况，通过对象来弄得
		Iterator<String> it1 = c.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
	}
}