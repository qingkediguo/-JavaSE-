package bs.多线程_极其重要_线程锁;

/*
 * 分析：
 * 		资源类：Student	
 * 		设置学生数据:SetThread(生产者)
 * 		获取学生数据：GetThread(消费者)
 * 		测试类:StudentDemo
 *
 * 问题3:虽然数据安全了，但是呢，一次一大片不好看，我就想依次的一次一个输出。
 * 如何实现呢?
 * 		通过Java提供的等待唤醒机制解决。
 * 
 * 等待唤醒：
 * 		Object类中提供了三个方法：
 * 			wait():等待
 * 			notify():唤醒单个线程
 * 			notifyAll():唤醒所有线程
 * 		为什么这些方法不定义在Thread类中呢?
 * 			这些方法的调用必须通过锁对象调用，而我们刚才使用的锁对象是任意锁对象。
 * 			所以，这些方法必须定义在Object类中。
 */
public class H_多线程获取多个学生信息_排队Demo {
	public static void main(String[] args) {
		//创建资源
		Student2 s = new Student2();
		
		//设置和获取的类
		SetThread2 st = new SetThread2(s);
		GetThread2 gt = new GetThread2(s);

		//线程类
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(gt);

		//启动线程
		t1.start();
		t2.start();
	}
}


class Student2 {
	String name;
	int age;
	boolean flag; // 默认情况是没有数据，如果是true，说明有数据		//【多了一个这个东西】
}


class SetThread2 implements Runnable {

	private Student2 s;
	private int x = 0;

	public SetThread2(Student2 s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (s) {
				//判断有没有
				if(s.flag){
					try {
						s.wait(); //t1等着，释放锁
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if (x % 2 == 0) {
					s.name = "林青霞";
					s.age = 27;
				} else {
					s.name = "刘意";
					s.age = 30;
				}
				x++; //x=1
				
				//修改标记
				s.flag = true;
				//唤醒线程
				s.notify(); //唤醒t2,唤醒并不表示你立马可以执行，必须还得抢CPU的执行权。
			}
			//t1有，或者t2有
		}
	}
}


class GetThread2 implements Runnable {
	private Student2 s;

	public GetThread2(Student2 s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (s) {
				if(!s.flag){
					try {
						s.wait(); //t2就等待了。立即释放锁。将来醒过来的时候，是从这里醒过来的时候
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println(s.name + "---" + s.age);
				//林青霞---27
				//刘意---30
				
				//修改标记
				s.flag = false;
				//唤醒线程
				s.notify(); //唤醒t1
			}
		}
	}
}