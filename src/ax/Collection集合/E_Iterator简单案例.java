package ax.Collection集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * 问题1:能用while循环写这个程序，我能不能用for循环呢?
 * 问题2:不要多次使用it.next()方法，因为每次使用都是访问一个对象。
 */
public class E_Iterator简单案例 {
	public static void main(String[] args) {
		// 创建集合对象
		Collection<Student> c = new ArrayList<Student>();

		// 创建学生对象
		Student s1 = new Student("林青霞", 27);
		Student s2 = new Student("风清扬", 30);
		Student s3 = new Student("令狐冲", 33);
		Student s4 = new Student("武鑫", 25);
		Student s5 = new Student("刘晓曲", 22);

		// 把学生添加到集合中
		c.add(s1);
		c.add(s2);
		c.add(s3);
		c.add(s4);
		c.add(s5);
		
		c.add(new Student("孙尚香", 18)); 			// 【匿名对象】

		// 遍历
		Iterator<Student> it = c.iterator();
		while (it.hasNext()) {
			Student s = (Student) it.next();
			System.out.println(s.getName() + "---" + s.getAge());

			// NoSuchElementException 不要多次使用it.next()方法	【取一个对象就使用一次，不要一边取对象，一边使用】
			// System.out.println(((Student) it.next()).getName() + "---" + ((Student) it.next()).getAge());
			// 林青霞---30	令狐冲---25

		}
		// System.out.println("----------------------------------");

		
		// for循环改写
		// for(Iterator it = c.iterator();it.hasNext();){
		// Student s = (Student) it.next();
		// System.out.println(s.getName() + "---" + s.getAge());
		// }
	}
}