package ad.面向对象进阶_多态;

/*
ClassCastException:类型转换异常
一般在多态的向下转型中容易出现
*/
class Animal2 {
	public void eat() {
	}
}

class Dog2 extends Animal2 {
	public void eat() {
	}

	public void lookDoor() {
	}
}

class Cat2 extends Animal2 {
	public void eat() {
	}

	public void playGame() {
	}
}

public class D_向下转型的异常 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// 内存中的是狗
		Animal2 a = new Dog2();
		Dog2 d = (Dog2) a;

		// 内存中是猫
		a = new Cat2();
		Cat2 c = (Cat2) a;

		// 内存中是猫
		Dog2 dd = (Dog2) a; // ClassCastException // 这里就编译不报错，运行要报错
	}
}