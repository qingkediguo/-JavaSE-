package cb.Java设计模式_极难度_慢慢理解_都很重要;

import java.util.ArrayList;
import java.util.List;

/*
观察者模式中，一个被观察者管理所有相依于它的观察者物件，并且在本身的状态改变时主动发出通知。这通常通过呼叫各观察者所提供的方法来实现。此种模式通常被用来实现事件处理系统。

角色
	抽象被观察者角色：
		把所有对观察者对象的引用保存在一个集合中，每个被观察者角色都可以有任意数量的观察者。被观察者提供一个接口，可以增加和删除观察者角色。一般用一个抽象类和接口来实现。
	抽象观察者角色：
		为所有具体的观察者定义一个接口，在得到主题的通知时更新自己。
	具体被观察者角色：
		在被观察者内部状态改变时，给所有登记过的观察者发出通知。具体被观察者角色通常用一个子类实现。
	具体观察者角色：
		该角色实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题的状态相协调。通常用一个子类实现。如果需要，具体观察者角色可以保存一个指向具体主题角色的引用。
		
适用场景
	1) 当一个抽象模型有两个方面, 其中一个方面依赖于另一方面。将这二者封装在独立的对象中以使它们可以各自独立地改变和复用。
	2) 当对一个对象的改变需要同时改变其它对象, 而不知道具体有多少对象有待改变。
	3) 当一个对象必须通知其它对象，而它又不能假定其它对象是谁。换言之, 你不希望这些对象是紧密耦合的。
*/

interface Observer {
	public void update(String message);
}

class WeixinUser implements Observer {
	// 微信用户名
	private String name;

	public WeixinUser(String name) {
		this.name = name;
	}

	@Override
	public void update(String message) {
		System.out.println(name + "-" + message);
	}
}

interface Subject {
	// 增加订阅者
	public void attach(Observer observer);

	// 删除订阅者
	public void detach(Observer observer);

	// 通知订阅者更新消息
	public void notify(String message);
}

class SubscriptionSubject implements Subject {
	// 储存订阅公众号的微信用户
	private List<Observer> weixinUserlist = new ArrayList<Observer>();

	@Override
	public void attach(Observer observer) {
		weixinUserlist.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		weixinUserlist.remove(observer);
	}

	@Override
	public void notify(String message) {
		for (Observer observer : weixinUserlist) {
			observer.update(message);
		}
	}
}

public class C_2观察者设计模式_原版_很重要 {
	public static void main(String[] args) {
		SubscriptionSubject mSubscriptionSubject = new SubscriptionSubject();
		// 创建微信用户
		WeixinUser user1 = new WeixinUser("用户1");
		WeixinUser user2 = new WeixinUser("用户2");
		WeixinUser user3 = new WeixinUser("用户3");
		// 订阅公众号
		mSubscriptionSubject.attach(user1);
		mSubscriptionSubject.attach(user2);
		mSubscriptionSubject.attach(user3);
		// 公众号更新发出消息给订阅的微信用户
		mSubscriptionSubject.notify("更新了");
	}
}
