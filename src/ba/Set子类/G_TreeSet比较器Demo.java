package ba.Set子类;

import java.util.TreeSet;

/*
 * 需求：请按照姓名的长度排序
 */
public class G_TreeSet比较器Demo {
	public static void main(String[] args) {
		// 创建集合对象
		TreeSet<G_TreeSet比较器> ts = new TreeSet<G_TreeSet比较器>();

		// 创建元素
		G_TreeSet比较器 s1 = new G_TreeSet比较器("linqingxia", 27);
		G_TreeSet比较器 s2 = new G_TreeSet比较器("zhangguorong", 29);
		G_TreeSet比较器 s3 = new G_TreeSet比较器("wanglihong", 23);
		G_TreeSet比较器 s4 = new G_TreeSet比较器("linqingxia", 27);
		G_TreeSet比较器 s5 = new G_TreeSet比较器("liushishi", 22);
		G_TreeSet比较器 s6 = new G_TreeSet比较器("wuqilong", 40);
		G_TreeSet比较器 s7 = new G_TreeSet比较器("fengqingy", 22);
		G_TreeSet比较器 s8 = new G_TreeSet比较器("linqingxia", 29);

		// 添加元素
		ts.add(s1);
		ts.add(s2);
		ts.add(s3);
		ts.add(s4);
		ts.add(s5);
		ts.add(s6);
		ts.add(s7);
		ts.add(s8);

		// 遍历
		for (G_TreeSet比较器 s : ts) {
			System.out.println(s.getName() + "---" + s.getAge());
		}
	}
}