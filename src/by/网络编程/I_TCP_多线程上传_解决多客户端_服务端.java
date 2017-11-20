package by.网络编程;

/*
 * 通过while循环可以改进一个服务器接收多个客户端。
 * 但是这个是有问题的。
 * 如果是这种情况，假设我还有张三，李四，王五这三个人分别执行客户端
 * 张三：好好学习.avi(100M)			256k
 * 李四：天天向上.mp3(3M)			1M
 * 王五：ILoveJava.txt(1k)		100M
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class I_TCP_多线程上传_解决多客户端_服务端 {
	public static void main(String[] args) throws IOException {
		// 创建服务器Socket对象
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(11111);

		while (true) {
			Socket s = ss.accept();
			new Thread(new UserThread(s)).start();
		}
	}
}



class UserThread implements Runnable {
	private Socket s;

	public UserThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			// 封装通道内的流
			BufferedReader br = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			// 封装文本文件
			// BufferedWriter bw = new BufferedWriter(new
			// FileWriter("Copy.java"));

			// 为了防止名称冲突
			String newName = System.currentTimeMillis() + ".java";
			BufferedWriter bw = new BufferedWriter(new FileWriter(newName));

			String line = null;
			while ((line = br.readLine()) != null) { // 阻塞
				bw.write(line);
				bw.newLine();
				bw.flush();
			}

			// 给出反馈
			BufferedWriter bwServer = new BufferedWriter(
					new OutputStreamWriter(s.getOutputStream()));
			bwServer.write("文件上传成功");
			bwServer.newLine();
			bwServer.flush();

			// 释放资源
			bw.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}