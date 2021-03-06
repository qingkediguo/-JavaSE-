package ac.面向对象进阶_继承;

/*
继承中成员方法的关系:
	A:子类中的方法和父类中的方法声明不一样，这个太简单。
	B:子类中的方法和父类中的方法声明一样，这个该怎么玩呢?
		通过子类对象调用方法：
			a:先找子类中，看有没有这个方法，有就使用
			b:再看父类中，有没有这个方法，有就使用
			c:如果没有就报错。
*/
class Father6 {
	public void show() {
		System.out.println("show Father");
	}
}

class Son6 extends Father6 {
	public void method() {
		System.out.println("method Son");
	}

	public void show() {
		System.out.println("show Son");
	}
}

public class H_继承中的成员方法的关系 {
	public static void main(String[] args) {
		// 创建对象
		Son6 s = new Son6();
		s.show();
		s.method();
		// s.fucntion(); //找不到符号
	}
}