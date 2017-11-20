package bj.IO流_OutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 字节输出流操作步骤：
 * A:创建字节输出流对象
 * B:调用write()方法
 * C:释放资源
 * 
 * public void write(int b):写一个字节
 * public void write(byte[] b):写一个字节数组
 * public void write(byte[] b,int off,int len):写一个字节数组的一部分
 */
public class B_理解写入的是字节流 {
	public static void main(String[] args) throws IOException {
		// 创建字节输出流对象 【下面的那个是文件字节流，上面的那个是单纯的字节流 】
		// OutputStream os = new FileOutputStream("C:\\Users\\admin\\Desktop\\fos.txt"); // 多态
		FileOutputStream fos = new FileOutputStream("C:\\Users\\admin\\Desktop\\fos.txt");

		// 调用write()方法
		//fos.write(97); //97 -- 底层二进制数据	-- 通过记事本打开 -- 找97对应的字符值 -- a
		// fos.write(57);
		// fos.write(55);
		
		//public void write(byte[] b):写一个字节数组
		byte[] bys={97,98,99,100,101};
		fos.write(bys);
		
		//public void write(byte[] b,int off,int len):写一个字节数组的一部分
		fos.write("----".getBytes());
		
		fos.write(bys,1,3);
		
		System.out.println("创建成功");
		//释放资源
		fos.close();
	}
}