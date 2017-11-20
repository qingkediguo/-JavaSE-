package ca.Java8新特性_有一定的掌握程度就行;

/*
	默认方法使得接口有点类似traits，不过要实现的目标不一样。
	默认方法使得开发者可以在 不破坏二进制兼容性的前提下，往现存接口中添加新的方法，
	即不强制那些实现了该接口的类也同时实现这个新加的方法
	
	默认方法和抽象方法之间的区别在于抽象方法需要实现，而默认方法不需要。接口提供的默认方法会被接口的实现类继承或者覆写
*/

//Defaulable接口使用关键字default定义了一个默认方法method()。
//DefaultableImpl类实现了这个接口，同时默认继承了这个接口中的默认方法；
//OverridableImpl类也实现了这个接口，但覆写了该接口的默认方法，并提供了一个不同的实现。

interface Defaulable {
	default String method() {
		return "Default implementation";
	}
}

class DefaultableImpl implements Defaulable {
}

class OverridableImpl implements Defaulable {
	@Override
	public String method() {
		return "Overridden implementation";
	}
}
// 【Java 8带来的另一个有趣的特性是在接口中可以定义静态方法】
// 【但是这个东西非常不推荐使用，所以就不写了】
public class C_接口的默认方法和静态方法_了解即可 {
	public static void main(String[] args) {
		Defaulable df1 = new DefaultableImpl();
		df1.method();
	}
}
