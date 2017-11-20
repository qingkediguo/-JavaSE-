package ab.面向对象基础;

/*
匿名对象：就是没有名字的对象。

匿名对象的应用场景：
	A:调用方法，仅仅只调用一次的时候。
		注意：调用多次的时候，不适合。
		那么，这种匿名调用有什么好处吗?
			有，匿名对象调用完毕就是垃圾。可以被垃圾回收器回收。
	B:匿名对象可以作为实际参数传递
*/
class Student2 {
	public void show() {
		System.out.println("我爱学习");
	}
}

class StudentDemo2 {
	public void method(Student2 s) {
		s.show();
	}
}

public class E_匿名对象 {
	public static void main(String[] args) {
		// 带名字的调用
		Student2 s = new Student2();
		s.show();
		s.show();
		System.out.println("--------------");

		// 匿名对象
		// new Student();

		// 匿名对象调用方法
		new Student2().show();
		new Student2().show(); // 这里其实是重新创建了一个新的对象
		System.out.println("--------------");

		
		// 下面两个是另外一个案例
		// 匿名对象作为实际参数传递
		StudentDemo2 sd = new StudentDemo2();
		// Student ss = new Student();
		// sd.method(ss); //这里的s是一个实际参数
		// 匿名对象
		sd.method(new Student2());

		// 在来一个
		new StudentDemo2().method(new Student2());
	}
}