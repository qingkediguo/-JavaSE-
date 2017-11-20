package cb.Java设计模式_极难度_慢慢理解_都很重要;

/*
命令模式(Command)：
	将“请求”(命令/口令)封装成一个对象，以便使用不同的请求、队列或者日志来参数化其对象。
	命令模式也支持撤销操作。命令模式的目的就是达到命令的发出者和执行者之间解耦，实现请求和执行分开。
优点
	1.降低对象之间的耦合度。
	2.新的命令可以很容易地加入到系统中。
	3.可以比较容易地设计一个组合命令。
	4.调用同一方法实现不同的功能
缺点
	使用命令模式可能会导致某些系统有过多的具体命令类。
	因为针对每一个命令都需要设计一个具体命令类，因此某些系统可能需要大量具体命令类，这将影响命令模式的使用。
适用情况
	1.系统需要将请求调用者和请求接收者解耦，使得调用者和接收者不直接交互。
	2.系统需要在不同的时间指定请求、将请求排队和执行请求。
	3.系统需要支持命令的撤销(Undo)操作和恢复(Redo)操作。
	4.系统需要将一组操作组合在一起，即支持宏命令。
应用场景
	菜馆点餐、遥控器、队列请求、日志请求。
*/
/*
 * 示例：以咱去餐馆吃饭为例，分为3步 
 * 1、和小二说，来个宫保鸡丁 --> 顾客发出口令 
 * 2、小二来了一句：宫保鸡丁一份。 这时命令被传递到了厨师。--> 口令传递到了厨师 
 * 3、然后厨师就开始做宫保鸡丁去了。 --> 厨师根据口令去执行 
 * 从这3步可以看到，宫保鸡丁并不是我想吃就我来做，而是传达给别人去做。 
 * 我要的是一个结果——宫保鸡丁这道菜做好了，而我无需去关系这道菜是怎么去做的。 
*/

interface Command {
	public void execute(); // 执行

	public void undo(); // 撤销
}

class CookReceiver { // 厨师，命令的执行者
	public void cooking() {
		System.out.println("开始炒宫保鸡丁了...");
	}

	public void unCooking() {
		System.out.println("不要炒宫保鸡丁了...");
	}
}

class OrderCommand implements Command { // 小二传达命令
	private CookReceiver cook;

	public OrderCommand(CookReceiver cook) {
		this.cook = cook;
	}

	@Override
	public void execute() {
		cook.cooking();
	}

	@Override
	public void undo() {
		cook.unCooking();
	}
}

class Customer1 { // 顾客，命令的发出者
	private Command command;

	public Customer1(Command command) {
		this.command = command;
	}

	public void order() {
		command.execute();
	}

	public void unOrder() {
		command.undo();
	}
}

public class C_6命令设计模式_很重要 {
	public static void main(String[] args) {
		// 等待口令的执行者 --炒菜总得有个厨师吧.
		CookReceiver cookReceiver = new CookReceiver();
		// 等待将口令传达给厨师 --因为顾客要什么菜还不知道，但口令始终要传达到厨师耳朵里这是肯定的。
		OrderCommand orderCommand = new OrderCommand(cookReceiver);
		// 顾客来了
		Customer1 customer1 = new Customer1(orderCommand);
		// 点菜
		customer1.order();
		// 不想吃了
		customer1.unOrder();
	}
}
