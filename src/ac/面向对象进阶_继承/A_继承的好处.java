package ac.面向对象进阶_继承;

/*
继承概述：
	把多个类中相同的内容给提取出来定义到一个类中。
	
如何实现继承呢?	
	Java提供了关键字：extends
	
格式：
	class 子类名 extends 父类名 {}
	
好处：
	A:提高了代码的复用性
	B:提高了代码的维护性
	C:让类与类之间产生了关系，是多态的前提

类与类产生了关系，其实也是继承的一个弊端：
	类的耦合性增强了。
	
	开发的原则：低耦合，高内聚。☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
	耦合：类与类的关系
	内聚：就是自己完成某件事情的能力
*/

//使用继承前
/*
class Student {
	public void eat() {
		System.out.println("吃饭");
	}

	public void sleep() {
		System.out.println("睡觉");
	}
}

class Teacher {
	public void eat() {
		System.out.println("吃饭");
	}

	public void sleep() {
		System.out.println("睡觉");
	}
}
*/

//使用继承后
class Person {
	public void eat() {
		System.out.println("吃饭");
	}

	public void sleep() {
		System.out.println("睡觉");
	}
}

class Student extends Person {
}

class Teacher extends Person {
}

public class A_继承的好处 {
	public static void main(String[] args) {
		Student s = new Student();
		s.eat();
		s.sleep();
		System.out.println("-------------");

		Teacher t = new Teacher();
		t.eat();
		t.sleep();
	}
}