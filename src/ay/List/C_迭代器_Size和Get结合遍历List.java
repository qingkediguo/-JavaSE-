package ay.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * List集合的特有遍历功能：
 * 		size()和get()方法结合使用
 */
public class C_迭代器_Size和Get结合遍历List {
	public static void main(String[] args) {
		// 创建集合对象
		List<String> list = new ArrayList<String>();

		// 添加元素
		list.add("hello");
		list.add("world");
		list.add("java");

		// Object get(int index):获取指定位置的元素
		// System.out.println(list.get(0));
		// System.out.println(list.get(1));
		// System.out.println(list.get(2));
		// IndexOutOfBoundsException
		// System.out.println(list.get(3));

		// 用循环改进
		// for (int x = 0; x < 3; x++) {
		// System.out.println(list.get(x));
		// }
		// 如果元素过多，数起来就比较麻烦，所以我们使用集合的一个长度功能：size()
		// 最终的遍历方式就是：size()和get()
		for (int x = 0; x < list.size(); x++) {
			// System.out.println(list.get(x));

			String s = (String) list.get(x);
			System.out.println(s);
		}
		
		System.out.println("--------");
		
		// 迭代器遍历
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
	}
}