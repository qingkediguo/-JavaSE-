package ab.面向对象基础;

/*
写程序的执行结果。

林青霞都60了，我很伤心
我是main方法
Student 静态代码块
Student 构造代码块
Student 构造方法
Student 构造代码块
Student 构造方法
*/
class Student6 {
	static {
		System.out.println("Student 静态代码块");
	}

	{
		System.out.println("Student 构造代码块");
	}

	public Student6() {
		System.out.println("Student 构造方法");
	}
}

public class O_代码块的使用小技巧 {
	static {
		System.out.println("林青霞都60了，我很伤心");
	}

	@SuppressWarnings("unused") 				// 只是为了消除警告
	public static void main(String[] args) {
		System.out.println("我是main方法");

		Student6 s1 = new Student6();
		Student6 s2 = new Student6();
	}
}