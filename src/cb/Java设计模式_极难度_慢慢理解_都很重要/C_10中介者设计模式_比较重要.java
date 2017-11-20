package cb.Java设计模式_极难度_慢慢理解_都很重要;

/*
中介者模式(Mediator)：
	主要用来降低类与类之间的耦合的，因为如果类与类之间有依赖关系的话，不利于功能的拓展和维护，因为只要修改一个对象，其它关联的对象都得进行修改。
	
适用情况
	一般来说，同事类之间的关系是比较复杂的，多个同事类之间互相关联时，他们之间的关系会呈现为复杂的网状结构，这是一种过度耦合的架构，即不利于类的复用，也不稳定。
	例如有六个同事类对象，假如对象1发生变化，会有4个对象受到影响。如果对象2发生变化，那么会有5个对象受到影响。也就是说，同事类之间直接关联的设计是不好的。
	
	如果引入中介者模式，那么同事类之间的关系将变为星型结构，任何一个类的变动，只会影响的类本身，以及中介者，这样就减小了系统的耦合。
	一个好的设计，必定不会把所有的对象关系处理逻辑封装在本类中，而是使用一个专门的类来管理那些不属于自己的行为。
	
优点
	适当地使用中介者模式可以避免同事类之间的过度耦合，使得各同事类之间可以相对独立地使用。
	使用中介者模式可以将对象间一对多的关联转变为一对一的关联，使对象间的关系易于理解和维护。
	使用中介者模式可以将对象的行为和协作进行抽象，能够比较灵活的处理对象间的相互作用。
	
中介者模式是一种比较常用的模式，也是一种比较容易被滥用的模式。
对于大多数的情况，同事类之间的关系不会复杂到混乱不堪的网状结构，
因此，大多数情况下，将对象间的依赖关系封装的同事类内部就可以的，没有必要非引入中介者模式。滥用中介者模式，只会让事情变的更复杂。
*/

// 示例：下面以房屋(出租)中介为例
interface Mediator {
	void createMediator();

	void recommendHouse();
}

// 咱(User)让中介帮我们推荐房子，所以咱需要持有一个中介实例
abstract class User1 {
	private Mediator mediator;

	public User1(Mediator mediator) {
		this.mediator = mediator;
	}

	public Mediator getMediator() {
		return mediator;
	}

	public abstract void selectHouse();
}

class ZhangSan extends User1 {
	public ZhangSan(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void selectHouse() {
		System.out.println("张三在选房子...");
	}
}

class LiSi extends User1 {
	public LiSi(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void selectHouse() {
		System.out.println("李四在选房子...");
	}
}

// 房屋中介：中介向要找房子的那些人推荐房子，由他们选择自己想要的房子。因此中介得持有那些实例，才有可能把房子租出去。
class MyMediator implements Mediator {
	private User1 zhangsan;
	private User1 lisi;

	public User1 getZhangsan() {
		return zhangsan;
	}

	public User1 getLisi() {
		return lisi;
	}

	@Override
	public void createMediator() {
		zhangsan = new ZhangSan(this);
		lisi = new LiSi(this);
	}

	// 中介向要找房子的那些人推荐房子，由他们选择自己想要的房子
	@Override
	public void recommendHouse() {
		zhangsan.selectHouse();
		lisi.selectHouse();
	}
}

public class C_10中介者设计模式_比较重要 {
	public static void main(String[] args) {
		Mediator mediator = new MyMediator();
		mediator.createMediator();
		mediator.recommendHouse();
	}
}
