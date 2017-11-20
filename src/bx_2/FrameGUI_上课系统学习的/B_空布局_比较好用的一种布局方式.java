package bx_2.FrameGUI_上课系统学习的;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class B_空布局_比较好用的一种布局方式 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("窗口");
		JLabel jLabelzh = new JLabel("账号");
		JLabel jLabelmima = new JLabel("密码");
		JTextField jTextField = new JTextField(20);
		JPasswordField passwordField = new JPasswordField(20);
		JButton buttondl = new JButton("登录");
		JButton buttonzc = new JButton("注册");
		frame.setLayout(null);					// 【这里设置布局方式为空】
		jLabelzh.setBounds(10, 10, 50, 30);		// 【所有的布局都是用setBounds来实现，有绝对定位的意思】
		jTextField.setBounds(60, 10, 150, 30);
		jLabelmima.setBounds(10, 50, 50, 30);
		passwordField.setBounds(60, 50, 150, 30);
		buttondl.setBounds(100, 90, 80, 30);
		buttonzc.setBounds(20, 90, 80, 30);
		frame.add(jLabelzh);
		frame.add(jLabelmima);
		frame.add(jTextField);
		frame.add(passwordField);
		frame.add(buttonzc);
		frame.add(buttondl);

		frame.setVisible(true);

		frame.setSize(500, 500);
	}
}
