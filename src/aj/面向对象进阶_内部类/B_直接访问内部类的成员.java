package aj.面向对象进阶_内部类;

/*
成员内部类:
	如何直接访问内部类的成员。
	外部类名.内部类名 对象名 = 外部类对象.内部类对象;
*/
class Outer2 {
	private int num = 10;

	class Inner {
		public void show() {
			System.out.println(num);
		}
	}
}

public class B_直接访问内部类的成员 {
	public static void main(String[] args) {
		// 需求：我要访问Inner类的show()方法
		// Inner i = new Inner();
		// i.show();

		// 格式：外部类名.内部类名 对象名 = 外部类对象.内部类对象;
		Outer2.Inner oi = new Outer2().new Inner();
		oi.show();
	}
}