package bs.多线程_极其重要_线程锁;

/*
 * 同步的弊端：
 * 		A:效率低
 * 		B:容易产生死锁
 * 
 * 死锁：
 * 		两个或两个以上的线程在争夺资源的过程中，发生的一种相互等待的现象。
 * 
 * 举例：
 * 		中国人，美国人吃饭案例。
 * 		正常情况：
 * 			中国人:筷子两支
 * 			美国人:刀和叉
 * 		现在：
 * 			中国人：筷子1支，刀一把
 * 			美国人：筷子1支，叉一把
 */

// 【就是两个对象之间互相加锁，就构成了死锁】
// 【千万注意，线程锁在服务器里会使服务器宕机的】


public class E_什么是死锁 {
	public static void main(String[] args) {
		DieLock dl1 = new DieLock(true);
		DieLock dl2 = new DieLock(false);

		dl1.start();
		dl2.start();
	}
}


class MyLock {
	// 创建两把锁对象
	public static final Object objA = new Object();
	public static final Object objB = new Object();
}


class DieLock extends Thread {

	private boolean flag;

	public DieLock(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		if (flag) {
			synchronized (MyLock.objA) {
				System.out.println("if objA");
				synchronized (MyLock.objB) {
					System.out.println("if objB");
				}
			}
		} else {
			synchronized (MyLock.objB) {
				System.out.println("else objB");
				synchronized (MyLock.objA) {
					System.out.println("else objA");
				}
			}
		}
	}
}