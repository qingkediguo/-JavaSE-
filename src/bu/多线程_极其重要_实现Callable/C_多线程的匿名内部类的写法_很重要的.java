package bu.多线程_极其重要_实现Callable;

/*
 * 匿名内部类的格式：
 * 		new 类名或者接口名() {
 * 			重写方法;
 * 		};
 * 		本质：是该类或者接口的子类对象。
 */
public class C_多线程的匿名内部类的写法_很重要的 {
	public static void main(String[] args) {
		// 继承Thread类来实现多线程
		new Thread() {
			public void run() {
				for (int x = 0; x < 100; x++) {
					System.out.println(Thread.currentThread().getName() + ":" + x);
				}
			}
		}.start();
		
		// 实现Runnable接口来实现多线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int x = 0; x < 100; x++) {
					System.out.println(Thread.currentThread().getName() + ":" + x);
				}
			}
		}).start();
	}
}