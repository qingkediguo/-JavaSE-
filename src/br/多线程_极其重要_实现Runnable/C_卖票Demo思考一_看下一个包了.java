package br.多线程_极其重要_实现Runnable;

/*
 * 实现Runnable接口的方式实现
 * 
 * 通过加入延迟后，就产生了连个问题：
 * A:相同的票卖了多次
 * 		CPU的一次操作必须是原子性的
 * B:出现了负数票
 * 		随机性和延迟导致的
 */
public class C_卖票Demo思考一_看下一个包了 {
	public static void main(String[] args) {
		// 创建资源对象
		SellTicket1 st = new SellTicket1();

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



class SellTicket1 implements Runnable {
	// 定义100张票
	private int tickets = 100;

//	@Override
//	public void run() {
//		while (true) {
//			// t1,t2,t3三个线程
//			// 这一次的tickets = 100;
//			if (tickets > 0) {
//				// 为了模拟更真实的场景，我们稍作休息
//				try {
//					Thread.sleep(100); // t1就稍作休息,t2就稍作休息
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//
//				System.out.println(Thread.currentThread().getName() + "正在出售第"
//						+ (tickets--) + "张票");
//				// 理想状态：
//				// 窗口1正在出售第100张票
//				// 窗口2正在出售第99张票
//				// 但是呢?
//				// CPU的每一次执行必须是一个原子性(最简单基本的)的操作。
//				// 先记录以前的值
//				// 接着把ticket--
//				// 然后输出以前的值(t2来了)
//				// ticket的值就变成了99
//				// 窗口1正在出售第100张票
//				// 窗口2正在出售第100张票
//
//			}
//		}
//	}
	
	@Override
	public void run() {
		while (true) {
			// t1,t2,t3三个线程
			// 这一次的tickets = 1;
			if (tickets > 0) {
				// 为了模拟更真实的场景，我们稍作休息
				try {
					Thread.sleep(100); //t1进来了并休息，t2进来了并休息，t3进来了并休息，
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println(Thread.currentThread().getName() + "正在出售第"
						+ (tickets--) + "张票");
				//窗口1正在出售第1张票,tickets=0
				//窗口2正在出售第0张票,tickets=-1
				//窗口3正在出售第-1张票,tickets=-2
			}
		}
	}
}