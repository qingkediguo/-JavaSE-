package ah.形式参数和返回值深入_难度比较高;

/*
形式参数：
	引用类型
		类名:(匿名对象的时候其实我们已经讲过了)需要的是该类的对象
		抽象类:需要的是该抽象的类子类对象
		接口
*/
abstract class Person {
	public abstract void study();
}

class PersonDemo {
	public void method(Person p) { // Person p = new Student(); //多态
		p.study();
	}
}

// 定义一个具体的学生类
class Student extends Person {
	public void study() {
		System.out.println("Good Good Study,Day Day Up");
	}
}

public class A_PersonTest {
	public static void main(String[] args) {
		// 目前是没有办法的使用的
		// 因为抽象类没有对应的具体类
		// 那么，我们就应该先定义一个具体类
		// 需求：我要使用PersonDemo类中的method()方法
		PersonDemo pd = new PersonDemo();
		Person p = new Student();
		pd.method(p);
		// 【其实等同于下面的代码，不过为了体现多态性，就写成上面的代码】
		// Student st = new Student();
		// st.study();
	}
}