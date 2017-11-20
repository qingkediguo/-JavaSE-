package ad.面向对象进阶_多态;

/*
多态：同一个对象(事物)，在不同时刻体现出来的不同状态。
举例：
	猫是猫，猫是动物。
	水(液体，固体，气态)。
	
多态的前提：
	A:要有继承关系。
	B:要有方法重写。
		其实没有也是可以的，但是如果没有这个就没有意义。
			动物 d = new 猫();
			d.show();
			动物 d = new 狗();
			d.show();
	C:要有父类引用指向子类对象。
		父 f =  new 子();
		
用代码体现一下多态。

多态中的成员访问特点：☆☆☆☆☆☆☆☆☆【相当重要】☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
	A:成员变量
		编译看左边，运行结果看左边。
	B:构造方法
		创建子类对象的时候，访问父类的构造方法，对父类的数据进行初始化。
	C:成员方法
		编译看左边，运行结果看右边。			// 【编译看左边的意思就是一定要左边有的方法，才能被调用。就算子类有这个方法，父类没有，就不能被调用】
										// 【但是最终的结果是子类的方法的结果】
	D:静态方法
		编译看左边，运行看左边。
		(静态和类相关，算不上重写，所以，访问还是左边的)
		
	由于成员方法存在方法重写，所以它运行看右边。
*/
class Fu {
	public int num = 100;

	public void show() {
		System.out.println("show Fu");
	}

	public static void function() {
		System.out.println("function Fu");
	}
}

class Zi extends Fu {
	public int num = 1000;
	public int num2 = 200;

	public void show() {
		System.out.println("show Zi");
	}

	public void method() {
		System.out.println("method zi");
	}

	public static void function() {
		System.out.println("function Zi");
	}
}

public class A_多态基础_非常非常重要 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// 要有父类引用指向子类对象。
		// 父 f = new 子();
		Fu f = new Zi();
		System.out.println(f.num);
		// 找不到符号
		// System.out.println(f.num2);

		f.show();
		// 找不到符号	// 【这个就是编译看左边的结果】
		// f.method();
		f.function();	//这里会报一个警告The static method function() from the type Fu should be 
						//accessed in a static way
						//这个就是因为上面的static，解决的办法是不用f.function()，而是用fu.function()
	}
}