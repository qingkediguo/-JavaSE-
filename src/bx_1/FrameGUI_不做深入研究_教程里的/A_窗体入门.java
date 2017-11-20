package bx_1.FrameGUI_不做深入研究_教程里的;

import java.awt.Frame;

//【这个窗体不能正常关闭，要关闭JVM才可以停止运行】

public class A_窗体入门 {
	public static void main(String[] args) {
		// 创建窗体对象
		// Frame f = new Frame();
		// Frame(String title)
		Frame f = new Frame("林青霞");

		// 设置窗体标题
		f.setTitle("HelloWorld");
		// 设置窗体大小
		f.setSize(400, 300); // 单位：像素
		// 设置窗体位置
		f.setLocation(400, 200);

		// 调用一个方法，设置让窗体可见
		// f.show();	// 【被弃用的方法】
		f.setVisible(true);

		// System.out.println("helloworld");
	}
}
