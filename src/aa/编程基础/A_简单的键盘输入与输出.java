package aa.编程基础;

/*
	为了让程序的数据更符合开发的数据，我们就加入了键盘录入。
	让程序更灵活一下。

	那么，我们如何实现键盘数据的录入呢?
	A:导包
		格式：
			import java.util.Scanner; 
		位置：
			在class上面。
	B:创建键盘录入对象
		格式：
			Scanner sc = new Scanner(System.in);
	C:通过对象获取数据	
		格式：
			int x = sc.nextInt();
*/

import java.util.Scanner;

public class A_简单的键盘输入与输出 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 将输入的第一行赋给string
		String string = sc.nextLine();

		// 将输入单词到第一个空白符为止的字符串赋给string
		// String string=sc.next();

		// 将输入的数字赋给变量
		// int string = sc.nextInt();

		System.out.println(string);
		sc.close();
	}
}
