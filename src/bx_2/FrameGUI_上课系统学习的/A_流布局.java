package bx_2.FrameGUI_上课系统学习的;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class A_流布局 {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame("这是一个窗口");// 创建一个窗口实例
		jFrame.setVisible(true);// 将窗口进行显示
		// 设置窗口的布局
		jFrame.setLayout(new FlowLayout());// 流布局
											// 【流布局默认是所有的控件都是居中的】

		jFrame.setTitle("这是一个被修改的窗口");// 进行修改窗口名字
		// 定义一个标签
		JLabel jLabelhao = new JLabel("QQ号:");
		JLabel jLabelmima = new JLabel("密码:");

		// jFrame.add(jLabelmima);
		// jFrame.add(jLabelhao);

		// 定义文本框
		JTextField jTextField1 = new JTextField(20);// 这是一个单行文本框，里面的参数是代表TextField的长度
		JPasswordField jTextField2 = new JPasswordField(20);

		// jFrame.add(jTextField2,"East");			// 【这种方式是最原始的边界布局，已经被淘汰】

		JButton jButton1 = new JButton("登录");
		JButton jButton2 = new JButton("取消");
		// jFrame.add(jButton1,"Center");

		jFrame.add(jLabelhao);
		jFrame.add(jTextField1);
		jFrame.add(jLabelmima);
		jFrame.add(jTextField2);
		jFrame.add(jButton1);
		jFrame.add(jButton2);
		// jFrame.setEnabled(false);
		jFrame.setSize(300, 300);// 设置窗口的大小
	}
}
