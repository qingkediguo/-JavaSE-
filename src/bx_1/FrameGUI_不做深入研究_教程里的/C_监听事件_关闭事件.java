package bx_1.FrameGUI_不做深入研究_教程里的;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;

public class C_监听事件_关闭事件 {
	public static void main(String[] args) {
		// 创建窗体对象
		Frame f = new Frame("窗体关闭案例");

		// 设置窗体属性
		f.setBounds(400, 200, 400, 300);

		// 让窗体关闭
		//事件源
		//事件：对窗体的处理
		//事件处理：关闭窗口(System.exit(0));
		//事件监听
		// 【下面的这些都是有可能的需要被监听的事件】
//		f.addWindowListener(new WindowListener() {
//			@Override
//			public void windowOpened(WindowEvent e) {
//			}
//			
//			@Override
//			public void windowIconified(WindowEvent e) {
//			}
//			
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//			}
//			
//			@Override
//			public void windowDeactivated(WindowEvent e) {
//			}
//			
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//			
//			@Override
//			public void windowClosed(WindowEvent e) {
//			}
//			
//			@Override
//			public void windowActivated(WindowEvent e) {
//			}
//		});
		
		//用适配器类改进
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// 设置窗体可见
		f.setVisible(true);
	}
}