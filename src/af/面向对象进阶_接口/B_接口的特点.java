package af.面向对象进阶_接口;

/*
接口成员特点
	成员变量；只能是常量，并且是静态的。		// 【意思是代码会自带有public static final，不管你加不加】
			默认修饰符：public static final
			建议：自己手动给出。
	构造方法：接口没有构造方法。
	成员方法：只能是抽象方法。				// 【意思是代码会自带有public abstract void，不管你加不加】
			默认修饰符：public abstract
			建议：自己手动给出。
	
所有的类都默认继承自一个类：Object。
类 Object 是类层次结构的根类。每个类都使用 Object 作为超类。	【Object类会在后面详细讲】
*/
interface Inter {
	public int num = 10;
	public final int num2 = 20;
	public static final int num3 = 30;

	// 错误: 需要<标识符>  // 就是缺少返回值
	// public Inter() {}

	// 接口方法不能带有主体
	// public void show() {}

	// abstract void show(); // 默认public
	// public void show(); // 默认abstract
	public abstract void show();// 这几个修饰符是可以改变顺序的
}

// 接口名+Impl这种格式是接口的实现类格式
/*
 * class InterImpl implements Inter { public InterImpl() { super(); } }
 */

class InterImpl extends Object implements Inter {			// 【继承Object类是默认的，可以不加】
	public InterImpl() {							// 【这个也是默认的，可以不加】
		super();
	}

	public void show() {
	}
}

// 测试类
public class B_接口的特点 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// 创建对象
		Inter i = new InterImpl();
		System.out.println(i.num);		// 【这里会报异常，所以正确的方法就是直接Inter.num，其实原因就是变量是static修饰的】
		System.out.println(i.num2);		// 【这里会报异常，所以正确的方法就是直接Inter.num2，其实原因就是变量是static修饰的】
		// i.num = 100;
		// i.num2 = 200;
		// System.out.println(i.num); //无法为最终变量num分配值
		// System.out.println(i.num2);//无法为最终变量num2分配值
		System.out.println(Inter.num);
		System.out.println(Inter.num2);
		System.out.println("--------------");
	}
}