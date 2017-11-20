package bk.IO流_InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * 一次读取一个字节数组：int read(byte[] b)
 * 返回值其实是实际读取的字节个数。
 */
public class B_输入流用字节数组简化 {
	public static void main(String[] args) throws IOException {
		// 创建字节输入流对象
		// FileInputStream fis = new FileInputStream("fis2.txt");
		File fff = new File("C:\\Users\\admin\\Desktop\\fos.txt");
		fff.createNewFile();
		FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Desktop\\fos.txt");
		// 读取数据
		// 定义一个字节数组
		// 第一次读取
		// byte[] bys = new byte[5];
		// int len = fis.read(bys);
		// // System.out.println(len);
		// // System.out.println(new String(bys));
		// // System.out.println(new String(bys, 0, len));
		// System.out.print(new String(bys, 0, len));
		//
		// // 第二次读取
		// len = fis.read(bys);
		// // System.out.println(len);
		// // System.out.println(new String(bys));
		// // System.out.println(new String(bys, 0, len));
		// System.out.print(new String(bys, 0, len));
		//
		// // 第三次读取
		// len = fis.read(bys);
		// // System.out.println(len);
		// // System.out.println(new String(bys));
		// // System.out.println(new String(bys, 0, len));
		// System.out.print(new String(bys, 0, len));
		//
		// // 第四次读取
		// len = fis.read(bys);
		// // System.out.println(len);
		// // System.out.println(new String(bys, 0, len));
		// System.out.print(new String(bys, 0, len));
		// // 代码重复了，用循环改进
		// // 但是，我不知道结束条件
		// // len = fis.read(bys);
		// // System.out.println(len);
		// // len = fis.read(bys);
		// // System.out.println(len);
		// // 如果读取到的实际长度是-1，就说明没有数据了

		// byte[] bys = new byte[115]; // 0
		// int len = 0;
		// while ((len = fis.read(bys)) != -1) {
		// System.out.print(new String(bys, 0, len));
		// // System.out.print(new String(bys)); //千万要带上len的使用
		// }

		// 最终版代码
		// 数组的长度一般是1024或者1024的整数倍
		byte[] bys = new byte[5];		//这里用5是为了方便第65行的输出len的例子，可以把实验一下这一行，就可以更直观的理解这段代码的原理了
		int len = 0;
		while ((len = fis.read(bys)) != -1) {
			//System.out.println(len);
			//System.out.print(new String(bys));		// 【必须用下面的那个方法，具体情况可以运行试一下，意思就是他一定要把上面的数组填满】
			System.out.print(new String(bys, 0, len));
		}

		// 释放资源
		fis.close();
	}
}