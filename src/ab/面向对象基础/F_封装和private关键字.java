package ab.面向对象基础;

/*
private:
	是一个权限修饰符
	可以修饰成员变量和成员方法
	被其修饰的成员只能在本类中被访问
*/
class Demo {
	// int num = 10;
	// 用private修饰
	private int num = 10;

	public void show() {
		System.out.println(num);
	}

	private void method() {
		System.out.println("method");
	}

	public void function() {
		method();
	}

	// 如果要访问private的成员变量就要用这个方法
	public int getNum() {
		return num;
	}
}

public class F_封装和private关键字 {
	public static void main(String[] args) {
		Demo d = new Demo();
		// 不能方法私有的成员变量
		// System.out.println(d.num); //这里是要报错的

		// 必须要通过这种方式来访问private的成员变量
		System.out.println(d.getNum());

		// 这种是直接在方法中访问的
		d.show();
		
		// 不能访问私有的成员方法
		// d.method(); //这种是要报错的
		d.function();
	}
}