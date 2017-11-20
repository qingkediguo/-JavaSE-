package cb.Java设计模式_极难度_慢慢理解_都很重要;

import java.util.ArrayList;
import java.util.List;

/*
建造者模式(Builder)：
	工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理。
	简单起见，就拿之前的工厂方法模式进行修改一下就可以得到建造者模式。
	
	建造者模式将很多功能集成到一个类里，这个类可以创造出比较复杂的东西。
	所以与工厂模式的区别就是：工厂模式关注的是创建单个产品，而建造者模式则关注创建复合对象，多个部分。
	
延伸：可以多线程创建对象
*/

interface Sender2 {
	public void send();
}

class EmailSender2 implements Sender2 {
	@Override
	public void send() {
		System.out.println("使用电子邮箱发送...");
	}
}

class SmsSender2 implements Sender2 {
	@Override
	public void send() {
		System.out.println("使用短信发送...");
	}
}

class Builder {
	private List<Sender2> list = new ArrayList<Sender2>();

	public List<Sender2> getList() {
		return list;
	}

	public void produceEmailSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new EmailSender2());
		}
	}

	public void produceSmsSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new SmsSender2());
		}
	}
}

public class A_5建造者设计模式_比较重要 {
	public static void main(String[] args) {
		Builder builder = new Builder();
		builder.produceEmailSender(5); // 【创建5个，存放在list中】
		builder.produceSmsSender(5);

		List<Sender2> list = builder.getList();
		for (int i = 0; i < list.size(); i++) {
			Sender2 sender = list.get(i);
			System.out.println(sender);
			sender.send();
		}
	}
}
