package by.网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * 这种写法有一个好处就是客户端发送数据的时候，可以知道服务端接收到了数据
 * 就是可以即时通讯
 * 可以有一个反馈【】
 */

public class E_TCP_阻塞式Socket发送数据_客户端 {
	public static void main(String[] args) throws IOException {
		// 创建客户端Socket对象
		Socket s = new Socket("localhost", 9999);

		// 获取输出流
		OutputStream os = s.getOutputStream();
		os.write("今天天气很好,适合睡觉".getBytes());

		// 获取输入流
		InputStream is = s.getInputStream();
		byte[] bys = new byte[1024];
		int len = is.read(bys);// 阻塞
		String client = new String(bys, 0, len);
		System.out.println("client:" + client);

		// 释放资源
		s.close();
	}
}