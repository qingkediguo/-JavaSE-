package bu.多线程_极其重要_实现Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//Callable:是带泛型的接口。
//这里指定的泛型其实是call()方法的返回值类型。
class MyCallable implements Callable<Object> {
	@Override
	public Object call() throws Exception {
		for (int x = 0; x < 100; x++) {
			System.out.println(Thread.currentThread().getName() + ":" + x);
		}
		return null;
	}
}

/*
 * 多线程实现的方式3：
 *  	A:创建一个线程池对象，控制要创建几个线程对象。
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
public class A_实现Callable接口来实现多线程 {
	public static void main(String[] args) {
		//创建线程池对象
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		//可以执行Runnable对象或者Callable对象代表的线程
		pool.submit(new MyCallable());
		pool.submit(new MyCallable());
		
		//结束
		pool.shutdown();
	}
}