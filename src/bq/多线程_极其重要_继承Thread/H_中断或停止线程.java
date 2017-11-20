package bq.多线程_极其重要_继承Thread;

import java.util.Date;

/*
 * public final void stop():让线程停止，过时了，但是还可以使用。		//【最好就不用这个方法了】
 * public void interrupt():中断线程。 把线程的状态终止，并抛出一个InterruptedException。
 */
public class H_中断或停止线程 {
	public static void main(String[] args) {
		ThreadStop ts = new ThreadStop();
		ts.start();

		// 你超过三秒不醒过来，我就干死你
		try {
			Thread.sleep(3000);
			// ts.stop();					// 【这个方法已经过时了，具体情况把下面的那行注释掉，运行这行就知道了】☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
			ts.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


class ThreadStop extends Thread {
	@Override
	public void run() {
		System.out.println("开始执行：" + new Date());

		// 我要休息10秒钟，亲，不要打扰我哦
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// e.printStackTrace();
			System.out.println("线程被终止了");
		}

		System.out.println("结束执行：" + new Date());
	}
}