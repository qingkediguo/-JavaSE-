package az.List子类;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * List的子类特点：
 * 		ArrayList:
 * 			底层数据结构是数组，查询快，增删慢
 * 			线程不安全，效率高
 * 		Vector:
 * 			底层数据结构是数组，查询快，增删慢
 * 			线程安全，效率低
 * 		LinkedList:
 * 			 底层数据结构是链表，查询慢，增删快
 * 			线程不安全，效率高
 * 
 * 案例：
 * 		使用List的任何子类存储字符串或者存储自定义对象并遍历。
 * 
 * ArrayList的使用。	
 * 		存储字符串并遍历
 */
public class A_ArrayList简述_三个子类的区别 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// 创建集合对象
		ArrayList<String> array1 = new ArrayList<String>();	// 【再次强调这里的泛型后面会讲解(尖括号)】
		List<String> array = new ArrayList<>();	// 【可以这么写，但是不推荐】
		ArrayList<String> array2 = new ArrayList<String>();	// 【☆☆☆☆☆☆☆☆还可以省略后面的尖括号的内容】

		// 创建元素对象，并添加元素
		array.add("hello");
		array.add("world");
		array.add("java");

		// 遍历
		Iterator<String> it = array.iterator();
		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);
		}

		System.out.println("-----------");

		for (int x = 0; x < array.size(); x++) {
			String s = (String) array.get(x);
			System.out.println(s);
		}
	}
}