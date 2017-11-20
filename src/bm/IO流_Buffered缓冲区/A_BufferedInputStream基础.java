package bm.IO流_Buffered缓冲区;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

// 【Buffered的意思是缓冲区！！！！非常重要这个专业术语】☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆

/*
 * 注意：虽然我们有两种方式可以读取，但是，请注意，这两种方式针对同一个对象在一个代码中只能使用一个。
 */
public class A_BufferedInputStream基础 {
	public static void main(String[] args) throws IOException {
		// BufferedInputStream(InputStream in)
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\qingkediguo\\Desktop\\1.txt"));

		// 读取数据
		// int by = 0;
		// while ((by = bis.read()) != -1) {
		// System.out.print((char) by);
		// }
		// System.out.println("---------");

		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = bis.read(bys)) != -1) {
			System.out.print(new String(bys, 0, len));
		}

		// 释放资源
		bis.close();
	}
}
