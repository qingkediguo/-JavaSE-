package ac.面向对象进阶_继承;

/*
继承中构造方法的关系
	A:子类中所有的构造方法默认都会访问父类中空参数的构造方法
	B:为什么呢?
		因为子类会继承父类中的数据，可能还会使用父类的数据。
		所以，子类初始化之前，一定要先完成父类数据的初始化。
		
		注意：子类每一个构造方法的第一条语句默认都是：super();		【重要：这里不是super(参数)，所以是不会访问有参数的构造方法的】
					     【但是如果你自己写了一句super(参数)的时候，他就不会自动添加无参数的super了，这时候就执行有参数的构造方法】
*/
class Father4 {
	int age;

	public Father4() {
		System.out.println("Father的无参构造方法");
	}

	public Father4(String name) {
		System.out.println("Father的带参构造方法");
	}
}

class Son4 extends Father4 {
	public Son4() {
		// super();
		System.out.println("Son的无参构造方法");
	}

	public Son4(String name) {
		// super();
		// super("123");
		System.out.println("Son的带参构造方法");
	}
}

public class F_继承中的构造方法 {
	public static void main(String[] args) {
		new Son4();
		System.out.println("------------");
		new Son4("林青霞");
	}
}