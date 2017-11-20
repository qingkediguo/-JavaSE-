package by.网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 这种写法有一个好处就是客户端发送数据的时候，可以知道服务端接收到了数据
 * 就是可以即时通讯
 * 可以有一个反馈【】
 */

public class E_TCP_阻塞式Socket接收数据_服务端 {
	public static void main(String[] args) throws IOException {
		// 创建服务器Socket对象
		ServerSocket ss = new ServerSocket(9999);

		// 监听客户端的连接
		Socket s = ss.accept(); // 阻塞

		// 获取输入流
		InputStream is = s.getInputStream();
		byte[] bys = new byte[1024];
		int len = is.read(bys); // 阻塞
		String server = new String(bys, 0, len);
		System.out.println("server:" + server);

		// 写一个输出流
		OutputStream os = s.getOutputStream();
		os.write("数据已经收到".getBytes());

		// 释放资源
		s.close();
		ss.close();	 //这个不应该关闭，因为是服务端。【但是在这个测试阶段可以关闭】
	}
}