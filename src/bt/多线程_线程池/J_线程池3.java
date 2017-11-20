package bt.多线程_线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/*
 * 线程池的好处：线程池里的每一个线程代码结束后，并不会死亡，而是再次回到线程池中成为空闲状态，等待下一个对象来使用。
 * 
 * 如何实现线程的代码呢?
 * 		A:创建一个线程池对象，控制要创建几个线程对象。
 * 			public static ExecutorService newFixedThreadPool(int nThreads)
 * 		B:这种线程池的线程可以执行：
 * 			可以执行Runnable对象或者Callable对象代表的线程
 * 			做一个类实现Runnable接口。
 * 		C:调用如下方法即可
 * 			Future<?> submit(Runnable task)
 *			<T> Future<T> submit(Callable<T> task)
 *		D:我就要结束，可以吗?
 *			可以。
 */


// 【创建一个定长线程池，支持定时及周期性任务执行。】

public class J_线程池3 {
	public static void main(String[] args) {
		// 创建一个线程池对象，控制要创建几个线程对象。
		// public static ExecutorService newFixedThreadPool(int nThreads)
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
		
		// 可以执行Runnable对象或者Callable对象代表的线程
		pool.submit(new MyRunnable5());
		pool.submit(new MyRunnable5());

		//结束线程池
		pool.shutdown();
	}
}


class MyRunnable5 implements Runnable {

	@Override
	public void run() {
		for (int x = 1; x <= 5; x++) {
			System.out.println(Thread.currentThread().getName() + ":" + x);
		}
	}
}