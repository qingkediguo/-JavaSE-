package ab.面向对象基础;

/*
代码块：在Java中，使用{}括起来的代码被称为代码块。
根据其位置和声明的不同，可以分为
	局部代码块:局部位置,用于限定变量的生命周期。
	构造代码块:在类中的成员位置,用{}括起来的代码。每次调用构造方法执行前，都会先执行构造代码块。
		作用：可以把多个构造方法中的共同代码放到一起，对对象进行初始化。
	静态代码块:在类中的成员位置,用{}括起来的代码,只不过它用static修饰了。
		作用：一般是对类进行初始化。

面试题?
	静态代码块,构造代码块,构造方法的执行顺序?
	静态代码块 -- 构造代码块 -- 构造方法【这个顺序很重要】
	静态代码块：只执行一次【很重要】
	构造代码块：每次调用构造方法都执行【很重要】
*/

/*
【】	静态代码块：static是静态，无论如何都是要先执行的。但是只会执行一次（被无数次实例化，也就只有第一次会执行）
	构造代码块：构造代码块是没有类名的，是特殊的构造方法，所以第二执行（每次类初始化就执行）。
	构造方法：就是普通的要执行了（每次类初始化就执行）。
*/

class Code {
	// 静态代码块
	static {
		int a = 1000;
		System.out.println(a);
	}

	// 构造代码块
	{
		int x = 100;
		System.out.println(x);
	}

	// 构造方法
	public Code() {
		System.out.println("code");
	}

	// 构造方法
	public Code(int a) {
		System.out.println("code");
	}

	// 构造代码块
	{
		int y = 200;
		System.out.println(y);
	}

	// 静态代码块
	static {
		int b = 2000;
		System.out.println(b);
	}
}

public class N_各种代码块 {
	@SuppressWarnings("unused")			//这个是为了消除下面c,c2,c3的未使用的警告
	public static void main(String[] args) {
		// 局部代码块
		{
			int x = 10;
			System.out.println(x);
		}
		// 找不到符号
		// System.out.println(x);
		{
			int y = 20;
			System.out.println(y);
		}
		System.out.println("---------------");

		Code c = new Code();
		System.out.println("---------------");
		Code c2 = new Code();
		System.out.println("---------------");
		Code c3 = new Code(1);
	}
}