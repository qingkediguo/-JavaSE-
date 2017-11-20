package ca.Java8新特性_有一定的掌握程度就行;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/*
	方法引用使得开发者可以直接引用现存的方法、Java类的构造方法或者实例对象。
	方法引用和Lambda表达式配合使用，使得java类的构造方法看起来紧凑而简洁，没有很多复杂的模板代码。
*/

// 【其实就是一个官方的另一种形式的工厂模式】

class Car {
	public static Car create(final Supplier<Car> supplier) {
		return supplier.get(); // 【supplier是一个工厂函数】可以暂时不用太过深入的了解
	}

	public static void collide(final Car car) {
		System.out.println("Collided " + car.toString());
	}

	public void follow(final Car another) {
		System.out.println("Following the " + another.toString());
	}

	public void repair() {
		System.out.println("Repaired " + this.toString());
	}
}

public class D_方法引用_暂时了解就行 {
	public static void main(String[] args) {
		// 【第一种方法引用的类型是构造器引用，语法是Class::new，或者更一般的形式：Class<T>::new。注意：这个构造器没有参数。】
		final Car car = Car.create(Car::new);
		final List<Car> cars = Arrays.asList(car);
		// 【第二种方法引用的类型是静态方法引用，语法是Class::static_method。注意：这个方法接受一个Car类型的参数。】
		cars.forEach(Car::collide);
		// 【第三种方法引用的类型是某个类的成员方法的引用，语法是Class::method，注意，这个方法没有定义入参。】
		cars.forEach(Car::repair);
		// 【第四种方法引用的类型是某个实例对象的成员方法的引用，语法是instance::method。注意：这个方法接受一个Car类型的参数】
		final Car police = Car.create(Car::new);
		cars.forEach(police::follow);
	}
}
