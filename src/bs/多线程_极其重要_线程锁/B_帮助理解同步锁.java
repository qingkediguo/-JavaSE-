package bs.多线程_极其重要_线程锁;

/*
 * A:同步代码块的锁对象是谁呢?
 * 		任意对象。
 * 
 * B:同步方法的格式及锁对象问题?
 * 		把同步关键字加在方法上。
 * 
 * 		同步方法是谁呢?
 * 			this
 * 
 * C:静态方法及锁对象问题?
 * 		静态方法的锁对象是谁呢?
 * 			类的字节码文件对象。(反射会讲)
 */

class SellTicket1 implements Runnable {

	// 定义100张票
	private int tickets = 100;

	// 定义同一把锁
	private Object obj = new Object();

	@Override
	public void run() {
		while (true) {
			// t1,t2,t3都能走到这里
			// 假设t1抢到CPU的执行权，t1就要进来
			// 假设t2抢到CPU的执行权，t2就要进来,发现门是关着的，进不去。所以就等着。
			// 门(开,关)
			synchronized (obj) { // 发现这里的代码将来是会被锁上的，所以t1进来后，就锁了。(关)
				if (tickets > 0) {
					try {
						Thread.sleep(100); // t1就睡眠了
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()
							+ "正在出售第" + (tickets--) + "张票 ");
					//窗口1正在出售第100张票
				}
			} //t1就出来可，然后就开门。(开)
		}
	}
}



/*
 * 举例：
 * 		火车上厕所。
 * 
 * 同步的特点：
 * 		前提：
 * 			多个线程
 *		解决问题的时候要注意：
 *			多个线程使用的是同一个锁对象
 * 同步的好处 
 *		同步的出现解决了多线程的安全问题。
 * 同步的弊端
 *		当线程相当多时，因为每个线程都会去判断同步上的锁，这是很耗费资源的，无形中会降低程序的运行效率。
 */
public class B_帮助理解同步锁 {
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