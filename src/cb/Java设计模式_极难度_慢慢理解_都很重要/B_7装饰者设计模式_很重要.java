package cb.Java设计模式_极难度_慢慢理解_都很重要;

/*
装饰者(Decorator)模式：
	动态地将责任附加到对象上，若要扩展功能，装饰者提供了比继承更具有弹性的替代方案。
	对于装饰者模式，它其实是一种包装，所以我更愿意称它为一种包装。
	像咱们以前经常使用的Java里面的IO流就用到了装饰者模式。
		比如：BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
		这里file1为目标对象，而像BufferedReader、InputStreamReader就可以称之为包装类。
		
	应用场景(仅代表个人观点)
		I/O、过滤器
		
	输出的过程其实是将包装类“拆包”的过程，就像包装袋一样一层一层的拆开。
	设计原则：1)多用组合，少用继承。2)对扩展开放，对修改关闭。
*/

// 对修改关闭，对拓展开放
interface Filterable {
	public void filter();
}

class Filter implements Filterable {
	@Override
	public void filter() {
		System.out.println("目标类的核心过滤方法...");
	}
}

// DecoratorForFilter1包装类与目标类实现相同的接口 --> 织入Log
class DecoratorForFilter1 implements Filterable {
	private Filterable filterable;

	public DecoratorForFilter1(Filterable filterable) {
		this.filterable = filterable;
	}

	private void beforeMethod() {
		System.out.println("DecoratorForFilter1 --> 核心过滤方法执行前执行");
	}

	private void afterMethod() {
		System.out.println("DecoratorForFilter1 --> 核心过滤方法执行后执行");
	}

	@Override
	public void filter() {
		beforeMethod();
		filterable.filter();
		afterMethod();
	}
}

// DecoratorForFilter2包装类与目标类实现相同的接口 --> 织入Log
class DecoratorForFilter2 implements Filterable {
	private Filterable filterable;

	public DecoratorForFilter2(Filterable filterable) {
		this.filterable = filterable;
	}

	private void beforeMethod() {
		System.out.println("DecoratorForFilter2 --> 核心过滤方法执行前执行");
	}

	private void afterMethod() {
		System.out.println("DecoratorForFilter2 --> 核心过滤方法执行后执行");
	}

	@Override
	public void filter() {
		beforeMethod();
		filterable.filter();
		afterMethod();
	}
}

public class B_7装饰者设计模式_很重要 {
	public static void main(String[] args) {
		Filterable targetObj = new Filter();
		Filterable decorObj = new DecoratorForFilter1(new DecoratorForFilter2(targetObj));
		decorObj.filter();
	}
}
