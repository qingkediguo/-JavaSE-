package ab.面向对象基础;

/*
手机类的测试
*/
class Phone {
	// 品牌
	String brand;
	// 价格
	int price;
	// 颜色
	String color;

	// 打电话的方法
	public void call(String name) {
		System.out.println("给" + name + "打电话");
	}

	// 发短信的方法
	public void sendMessage() {
		System.out.println("群发短信");
	}

	// 玩游戏的方法
	public void playGame() {
		System.out.println("玩游戏");
	}
}

public class A_面向对象基础一 {
	public static void main(String[] args) {
		// 创建手机对象
		// 类名 对象名 = new 类名();
		Phone p = new Phone();

		// 直接输出成员变量值
		System.out.println(p.brand + "---" + p.price + "---" + p.color);

		// 给成员变量赋值
		p.brand = "诺基亚";
		p.price = 100;
		p.color = "灰色";
		// 再次输出
		System.out.println(p.brand + "---" + p.price + "---" + p.color);

		// 调用方法
		p.call("林青霞");
		p.sendMessage();
		p.playGame();
	}
}