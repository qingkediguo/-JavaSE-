package bg.Exception异常机制_极重要;

import java.util.Scanner;

/*
 * java不可能对所有的情况都考虑到，所以，在实际的开发中，我们可能需要自己定义异常。
 * 而我们自己随意的写一个类，是不能作为异常类来看的，要想你的类是一个异常类，就必须继承自Exception或者RuntimeException
 * 
 * 两种方式：
 * A:继承Exception
 * B:继承RuntimeException
 */

class MyException extends Exception {
	private static final long serialVersionUID = 1L;		// 【自定义异常会自动生成一个这个东西】

	public MyException(String message) {		// 【构造函数☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆】
		super(message);
	}
}

// public class MyException extends RuntimeException {
//
// }

class Teacher {
	public void check(int score) throws MyException {
		if (score > 100 || score < 0) {
			throw new MyException("分数必须在0-100之间");
		} else {
			System.out.println("分数没有问题");
		}
	}

	// 针对MyException继承自RuntimeException
	
	// public void check(int score) {
	// if (score > 100 || score < 0) {
	// throw new MyException();
	// } else {
	// System.out.println("分数没有问题");
	// }
	// }
}

public class J_自定义异常_重要 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学生成绩：");
		int score = sc.nextInt();
		sc.close();
		
		Teacher t = new Teacher();
		
		try {
			t.check(score);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}