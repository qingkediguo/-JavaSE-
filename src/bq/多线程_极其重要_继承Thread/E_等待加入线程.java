package bq.多线程_极其重要_继承Thread;

/*
 * public final void join():等待该线程终止。 【该线程执行完成之后才会执行下面的线程】
 */
public class E_等待加入线程 {
	public static void main(String[] args) {
		ThreadJoin tj1 = new ThreadJoin();
		ThreadJoin tj2 = new ThreadJoin();
		ThreadJoin tj3 = new ThreadJoin();

		tj1.setName("李渊");
		tj2.setName("李世民");
		tj3.setName("李元霸");

		tj1.start();
		try {
			tj1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		tj2.start();
		tj3.start();
	}
}


class ThreadJoin extends Thread {
	@Override
	public void run() {
		for (int x = 0; x < 5; x++) {
			System.out.println(getName() + ":" + x);
		}
	}
}