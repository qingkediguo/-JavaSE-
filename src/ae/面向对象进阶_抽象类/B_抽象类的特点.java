package ae.面向对象进阶_抽象类;

/*
抽象类的成员特点：
	成员变量：既可以是变量，也可以是常量。
	构造方法：有。
				用于子类访问父类数据的初始化。
	成员方法：既可以是抽象的，也可以是非抽象的。
	
	【在抽象类里写有参数的构造方法是不可取的】
	
抽象类的成员方法特性：
	A:抽象方法 强制要求子类做的事情。
	B:非抽象方法 子类继承的事情，提高代码复用性。
*/
abstract class Animal1 {
	public int num = 10;
	public final int num2 = 20;

	public Animal1() {
		System.out.println("无参构造方法运行了");
	}

	public Animal1(String name, int age) {
		System.out.println(name + age + "有参数的构造方法运行了");
	}

	public abstract void show();

	public void method() {
		System.out.println("抽象类里的非抽象方法运行了");
	}
}

class Dog1 extends Animal1 {
	public void show() {
		System.out.println("抽象类里的抽象方法被重写之后运行了");
	}
}

public class B_抽象类的特点 {
	public static void main(String[] args) {
		// 创建对象
		Animal1 a = new Dog1();
		a.num = 100;
		System.out.println(a.num);
		// a.num2 = 200;
		System.out.println(a.num2);
		System.out.println("--------------");
		a.show();
		a.method();
		System.out.println("--------------");
		// Animal1 b = new Dog1("name",20);
		// 这里被强制要求在Dog1类里面写子类的构造方法，所以在抽象类里写有参数的构造方法是不可取的
	}
}