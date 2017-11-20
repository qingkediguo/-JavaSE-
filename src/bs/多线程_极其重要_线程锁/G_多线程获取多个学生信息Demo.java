package bs.多线程_极其重要_线程锁;

/*
 * 分析：
 * 		资源类：Student	
 * 		设置学生数据:SetThread(生产者)
 * 		获取学生数据：GetThread(消费者)
 * 		测试类:StudentDemo
 * 
 * 问题2：为了数据的效果好一些，我加入了循环和判断，给出不同的值,这个时候产生了新的问题
 * 		A:同一个数据出现多次
 * 		B:姓名和年龄不匹配
 * 原因：
 * 		A:同一个数据出现多次
 * 			CPU的一点点时间片的执行权，就足够你执行很多次。
 * 		B:姓名和年龄不匹配
 * 			线程运行的随机性
 * 线程安全问题：
 * 		A:是否是多线程环境		是
 * 		B:是否有共享数据		是
 * 		C:是否有多条语句操作共享数据	是
 * 解决方案：
 * 		加锁。
 * 		注意：
 * 			A:不同种类的线程都要加锁。
 * 			B:不同种类的线程加的锁必须是同一把。
 */
public class G_多线程获取多个学生信息Demo {
	public static void main(String[] args) {
		//创建资源
		Student1 s = new Student1();
		
		//设置和获取的类
		SetThread1 st = new SetThread1(s);
		GetThread1 gt = new GetThread1(s);

		//线程类
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(gt);

		//启动线程
		t1.start();
		t2.start();
	}
}


class Student1 {
	String name;
	int age;
}


class SetThread1 implements Runnable {

	private Student1 s;
	private int x = 0;

	public SetThread1(Student1 s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (s) {
				if (x % 2 == 0) {
					s.name = "林青霞";//刚走到这里，就被别人抢到了执行权
					s.age = 27;
				} else {
					s.name = "刘意"; //刚走到这里，就被别人抢到了执行权
					s.age = 30;
				}
				x++;
			}
		}
	}
}


class GetThread1 implements Runnable {
	private Student1 s;

	public GetThread1(Student1 s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (s) {
				System.out.println(s.name + "---" + s.age);
			}
		}
	}
}