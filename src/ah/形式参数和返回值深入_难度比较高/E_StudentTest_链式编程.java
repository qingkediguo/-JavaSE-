package ah.形式参数和返回值深入_难度比较高;

/*
链式编程。
	每次调用完毕方法后，返回的是一个对象。
*/
class Student5 {
	public void study() {
		System.out.println("Good Good Study,Day Day Up");
	}
}

class StudentDemo5 {
	public Student5 getStudent() {
		return new Student5();
	}
}

public class E_StudentTest_链式编程 {
	public static void main(String[] args) {
		// 如何调用的呢?
		StudentDemo5 sd = new StudentDemo5();
		// Student s = sd.getStudent();
		// s.study();

		// 大家注意了
		sd.getStudent().study();
	}
}