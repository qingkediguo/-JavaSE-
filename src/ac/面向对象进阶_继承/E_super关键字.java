package ac.面向对象进阶_继承;

/*
问题是：
	我不仅仅要输出局部范围的num，还要输出本类成员范围的num。怎么办呢?
	我还想要输出父类成员范围的num。怎么办呢?
		如果有一个东西和this相似，但是可以直接访问父类的数据就好了。
		恭喜你，这个关键字是存在的：super。
		
this和super的区别?
	分别是什么呢?
		this代表本类对应的引用。
		super代表父类存储空间的标识(可以理解为父类引用,可以操作父类的成员)

	怎么用呢?
		A:调用成员变量
			this.成员变量 调用本类的成员变量
			super.成员变量 调用父类的成员变量
		B:调用构造方法
			this(...)	调用本类的构造方法
			super(...)	调用父类的构造方法
		C:调用成员方法
			this.成员方法 调用本类的成员方法
			super.成员方法 调用父类的成员方法
*/
class Father3 {
	public int num = 10;
}

class Son3 extends Father3 {
	public int num = 20;

	public void show() {
		int num = 30;
		System.out.println(num+"--方法里的变量");
		System.out.println(this.num+"--本类里的变量");
		System.out.println(super.num+"--父类里的变量");
	}
}

public class E_super关键字 {
	public static void main(String[] args) {
		Son3 s = new Son3();
		s.show();
	}
}