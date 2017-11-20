package ad.面向对象进阶_多态;

/*
多态练习：猫狗案例
*/
class Animal3 {
	public void eat() {
		System.out.println("吃饭");
	}
}

class Dog3 extends Animal3 {
	public void eat() {
		System.out.println("狗吃肉");
	}

	public void lookDoor() {
		System.out.println("狗看门");
	}
}

class Cat3 extends Animal3 {
	public void eat() {
		System.out.println("猫吃鱼");
	}

	public void playGame() {
		System.out.println("猫捉迷藏");
	}
}

public class E_经典猫狗案例 {
	public static void main(String[] args) {
		// 定义为狗
		Animal3 a = new Dog3();
		a.eat();
		System.out.println("--------------");
		// 还原成狗
		Dog3 d = (Dog3) a;
		d.eat();
		d.lookDoor();
		System.out.println("--------------");
		// 变成猫
		a = new Cat3();
		a.eat();
		System.out.println("--------------");
		// 还原成猫
		Cat3 c = (Cat3) a;
		c.eat();
		c.playGame();
		System.out.println("--------------");

		// 演示错误的内容
		// Dog dd = new Animal();
		// Dog ddd = new Cat();
		// ClassCastException
		// Dog dd = (Dog)a;
	}
}