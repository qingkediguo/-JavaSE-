package cb.Java设计模式_极难度_慢慢理解_都很重要;

/*
工厂方法模式（Factory Method）
	工厂方法：顾名思义，就是调用工厂里的方法来生产对象(产品)的。
	工厂方法实现方式有3种：
		一、普通工厂模式。就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
			缺点：如果传递的字符串出错，则不能正确创建对象
		二、多个工厂方法模式。是对普通工厂方法模式的改进。
			在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。
		三、静态工厂方法模式。将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
		
	总体来说，凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。
	在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对象，第三种相对于第二种，不需要实例化工厂类，
	所以，大多数情况下，我们会选用第三种——静态工厂方法模式。
*/

interface Sender {
	public void send();
}

class EmailSender implements Sender {
	@Override
	public void send() {
		System.out.println("使用电子邮箱发送...");
	}
}

class SmsSender implements Sender {
	@Override
	public void send() {
		System.out.println("使用短信发送...");
	}
}

class 普通工厂方法模式 {
	public Sender produceSender(String type) {
		if ("email".equals(type)) {
			return new EmailSender();
		} else if ("sms".equals(type)) {
			return new SmsSender();
		} else {
			System.out.println("没有这种类型...");
			return null;
		}
	}
}

class 多个工厂方法模式 {  
    public Sender produceEmail() {  
        return new EmailSender();  
    }  

    public Sender produceSms() {  
        return new SmsSender();  
    }  
}

class 静态工厂方法模式 {  
    public static Sender produceEmail() {  
        return new EmailSender();  
    }  

    public static Sender produceSms() {  
        return new SmsSender();  
    }  
}

public class A_3工厂设计模式_很重要 {
	public static void main(String[] args) {
		普通工厂方法模式 factory1 = new 普通工厂方法模式();
		Sender s1 = factory1.produceSender("email");
		s1.send();
		
		多个工厂方法模式 factory2 = new 多个工厂方法模式();
		Sender s2 = factory2.produceEmail();
		s2.send();
		
		Sender s3 = 静态工厂方法模式.produceEmail();
		s3.send();
	}
}
