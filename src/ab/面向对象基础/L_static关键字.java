package ab.面向对象基础;

/*
定义一个人类

姓名和年龄都是变化的，这个我能接收，因为每个人的姓名和年龄是不同的。
但是，我们现在选取的几个人都是中国人，他们的国籍是一样的。
一样的国籍，我每次创建对象，在堆内存都要开辟这样的空间，
我就觉得有点浪费了。怎么办呢? 
	针对多个对象有共同的这样的成员变量值的时候，
	Java就提高了一个关键字来修饰：static。
*/

/*
static的特点：(它可以修饰成员变量，还可以修饰成员方法)
	A:随着类的加载而加载
		回想main方法。
	B:优先于对象存在
	C:被类的所有对象共享
		举例：咱们班级的学生应该共用同一个班级编号。
		其实这个特点也是在告诉我们什么时候使用静态?
			如果某个成员变量是被所有对象共享的，那么它就应该定义为静态的。
		举例：
			饮水机(用静态修饰)
			水杯(不能用静态修饰)
	D:可以通过类名调用
		其实它本身也可以通过对象名调用。
		推荐使用类名调用。
		
		静态修饰的内容一般我们称其为：与类相关的，类成员
*/

/*
static关键字注意事项
	A:在静态方法中是没有this关键字的
		如何理解呢?
			静态是随着类的加载而加载，this是随着对象的创建而存在。
			静态比对象先存在。
	B:静态方法只能访问静态的成员变量和静态的成员方法
			静态方法：
				成员变量：只能访问静态变量
				成员方法：只能访问静态成员方法
			非静态方法：
				成员变量：可以是静态的，也可以是非静态的
				成员方法：可是是静态的成员方法，也可以是非静态的成员方法。
		简单记：
			静态只能访问静态。
*/

class Person {
	// 姓名
	String name;
	// 年龄
	int age;
	// 国籍
	static String country;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person(String name, int age, String country) {
		this.name = name;
		this.age = age;
		// 注意：这里为什么不用this.country呢？
		// 是因为这里更改的country是static的，只有一个，只会是那一个被更改
		Person.country = country;
	}

	public void show() {
		System.out.println("姓名：" + name + ",年龄：" + age + ",国籍：" + country);
	}
}

public class L_static关键字 {
	public static void main(String[] args) {
		// 创建对象1
		Person p1 = new Person("邓丽君", 16, "中国");
		p1.show();

		// 创建对象2
		// Person p2 = new Person("杨幂",22,"中国");
		// p2.show();
		Person p2 = new Person("杨幂", 22);
		p2.show();

		// 创建对象3
		// Person p3 = new Person("凤姐",20,"中国");
		// p3.show();
		Person p3 = new Person("凤姐", 20);
		p3.show();

		Person.country = "美国";
		p3.show();		// 这里的static被更改成美国之后下面在运行的方法都是美国的了

		p1.show();
		p2.show();
	}
}