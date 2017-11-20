package cb.Java设计模式_极难度_慢慢理解_都很重要;

/*
适配器模式(Adapter)：将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题。
主要分为三类：
	类的适配器模式:
		当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可。
	对象的适配器模式:
		当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Adapter类，持有原类的一个实例，在Adapter类的方法中，调用实例的方法就行。
	接口的适配器模式:
		当不希望实现一个接口中所有的方法时，可以创建一个抽象类Adapter实现所有方法，我们写别的类的时候，继承抽象类即可。
*/

//【原类有一个待适配的方法】
class Original {
	public void originMethod() {
		System.out.println("this is a original method...");
	}
}

interface Targetable {
	// 与原类的方法相同
	public void originMethod();

	// 目标类的方法
	public void targetMethod();
}

class 类的适配器模式 extends Original implements Targetable { // 【接口的原方法被继承类的待适配的方法所实现，接口的另一个方法就是我们想要的待实现的方法】
	/**
	 * 可以看到该类只需要实现targetMethod即可。 因为Targetable接口里的originMethod方法已经由Original实现了。
	 * 这就是Adapter适配器这个类的好处：方法实现的转移(或称嫁接) --> 将Adapter的责任转移到Original身上 这样就实现了类适配器模式
	 * --> 将Original类适配到Targetable接口上
	 * 如果Original又添加了一个新的方法originMethod2，那么只需在Targetable接口中声明即可。
	 */
	@Override
	public void targetMethod() {
		System.out.println("this is a target method...");
	}
}

class 对象的适配器模式 implements Targetable {
	private Original original;

	public 对象的适配器模式(Original original) {
		this.original = original;
	}

	@Override
	public void targetMethod() {
		System.out.println("this is a target method...");
	}

	@Override
	public void originMethod() {
		original.originMethod();
	}
}

// 【直接将原类做成一个接口】接口的适配器模式
interface Originable {
	public void originMethod1();

	public void originMethod2();
}

/**
 * 该抽象类实现了原始接口，实现了所有的方法。 空实现即可，具体实现靠子类，子类只需实现自身需要的方法即可。
 * 以后咱们就不用跟原始的接口打交道，只和该抽象类取得联系即可。
 */
abstract class 接口的适配器模式 implements Originable {
	public void originMethod1() {
	}

	public void originMethod2() {
	}
}

// 【子类只需选择你所需要的方法进行实现即可】
class OriginSub1 extends 接口的适配器模式 {
	@Override
	public void originMethod1() {
		System.out.println("this is Originable interface's first sub1...");
	}
	// 【此时：originMethod2方法默认空实现】
}

public class B_1适配器设计模式 {
	public static void main(String[] args) {
		Targetable t1 = new 类的适配器模式();
		t1.originMethod();
		t1.targetMethod();
		System.out.println();

		Original original = new Original();
		Targetable t2 = new 对象的适配器模式(original);
		t2.originMethod();
		t2.targetMethod();
		System.out.println();

		Originable originable = new OriginSub1();
		originable.originMethod1();
		originable.originMethod2();			// 【这个Method2是空实现的】
	}
}
