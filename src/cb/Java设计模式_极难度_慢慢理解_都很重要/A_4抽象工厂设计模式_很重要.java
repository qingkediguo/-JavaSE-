package cb.Java设计模式_极难度_慢慢理解_都很重要;

/*
抽象工厂模式（Abstract Factory）：
	抽象工厂--顾名思义，就是把工厂抽象出来，不同的工厂生产不同的产品。
	这样做有个好处：一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码。
	
	
如果你现在想增加一个功能：
	给特别关注的好友发信息，则只需做一个实现类，实现Sender接口，同时做一个工厂类，实现AbstractFactory接口，就可以了，无需修改现有代码。这样做拓展性较好！
*/

interface Sender1 {
	public void send();
}

class EmailSender1 implements Sender1 {
	@Override
	public void send() {
		System.out.println("this is a email...");
	}
}

class SmsSender1 implements Sender1 {
	@Override
	public void send() {
		System.out.println("this is a sms...");
	}
}

// 【抽象工厂】
interface AbstractFactory {
	public Sender1 produce();
}

// 【邮件工厂】
class EmailSendFactory implements AbstractFactory {
	@Override
	public Sender1 produce() {
		return new EmailSender1();
	}
}

// 【短信工厂】
class SmsSendFactory implements AbstractFactory {
	@Override
	public Sender1 produce() {
		return new SmsSender1();
	}
}

public class A_4抽象工厂设计模式_很重要 {
	public static void main(String[] args) {
		AbstractFactory a1 = new EmailSendFactory();
		Sender1 s1 = a1.produce();
		s1.send();
	}
}
