package ah.形式参数和返回值深入_难度比较高;

/*
形式参数：
	引用类型
		类名:(匿名对象的时候其实我们已经讲过了) 需要的是该类的对象
		抽象类:
		接口
*/
class Student3 {
	public void study() {
		System.out.println("Good Good Study,Day Day Up");
	}
}

class StudentDemo3 {
	public void method(Student3 s) { // ss; ss = new Student(); Student s = new
									// Student();
		s.study();
	}
}

public class C_StudentTest {
	public static void main(String[] args) {
		// 需求：我要测试Student类的study()方法
		Student s = new Student();
		s.study();
		System.out.println("----------------");

		// 需求2：我要测试StudentDemo类中的method()方法
		StudentDemo3 sd = new StudentDemo3();
		Student3 ss = new Student3();
		sd.method(ss);
		System.out.println("----------------");

		// 匿名对象用法
		new StudentDemo3().method(new Student3());
	}
}
