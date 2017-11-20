package ba.Set子类;

import java.util.HashSet;

/*
 * HashSet集合存储自定义对象并遍历。如果对象的成员变量值相同即为同一个对象
 * 
 * 注意了：
 * 		你使用的是HashSet集合，这个集合的底层是哈希表结构。
 * 		而哈希表结构底层依赖:hashCode()和equals()方法。
 * 		如果你认为对象的成员变量值相同即为同一个对象的话，你就应该重写这两个方法。
 * 		如何重写呢?不同担心，自动生成即可。			// 【在Source里的Generate hashcode() and equals()】
 */
public class D_HashSet案例_DogDemo {
	public static void main(String[] args) {
		// 创建集合对象
		HashSet<D_HashSet案例_Dog> hs = new HashSet<D_HashSet案例_Dog>();

		// 创建狗对象
		D_HashSet案例_Dog d1 = new D_HashSet案例_Dog("秦桧", 25, "红色", '男');
		D_HashSet案例_Dog d2 = new D_HashSet案例_Dog("高俅", 22, "黑色", '女');
		D_HashSet案例_Dog d3 = new D_HashSet案例_Dog("秦桧", 25, "红色", '男');
		D_HashSet案例_Dog d4 = new D_HashSet案例_Dog("秦桧", 20, "红色", '女');
		D_HashSet案例_Dog d5 = new D_HashSet案例_Dog("魏忠贤", 28, "白色", '男');
		D_HashSet案例_Dog d6 = new D_HashSet案例_Dog("李莲英", 23, "黄色", '女');
		D_HashSet案例_Dog d7 = new D_HashSet案例_Dog("李莲英", 23, "黄色", '女');
		D_HashSet案例_Dog d8 = new D_HashSet案例_Dog("李莲英", 23, "黄色", '男');

		// 添加元素
		hs.add(d1);
		hs.add(d2);
		hs.add(d3);
		hs.add(d4);
		hs.add(d5);
		hs.add(d6);
		hs.add(d7);
		hs.add(d8);

		// 遍历
		for (D_HashSet案例_Dog d : hs) {
			System.out.println(d.getName() + "---" + d.getAge() + "---"
					+ d.getColor() + "---" + d.getSex());
		}
	}
}