package br.多线程_极其重要_实现Runnable;

class SellTicket implements Runnable {
	// 定义100张票
	private int tickets = 20;			// 自己思考为什么总20张票要这么写，放在这个地方
										// 为了让多个线程对象共享这100张票，我们其实应该用静态修饰

	@Override
	public void run() {
		while (true) {
			if (tickets > 0) {
				System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
			}
		}
	}
}

/*
 * 实现Runnable接口的方式实现
 */
public class B_卖票Demo {
	public static void main(String[] args) {
		// 创建资源对象
		SellTicket st = new SellTicket();

		// 创建三个线程对象
		Thread t1 = new Thread(st, "窗口1");
		Thread t2 = new Thread(st, "窗口2");
		Thread t3 = new Thread(st, "窗口3");

		// 启动线程
		t1.start();
		t2.start();
		t3.start();
	}
}