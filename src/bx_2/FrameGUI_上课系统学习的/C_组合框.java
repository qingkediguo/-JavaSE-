package bx_2.FrameGUI_上课系统学习的;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class C_组合框 implements ActionListener {
	JLabel lab1 , lab2 ,lab3 ,lab4;
	JTextField text1;
	JPasswordField text2;
	JRadioButton rb1 ,rb2;
	JFrame f;
	JComboBox<Object> combox;
	JLabel lab5;
	JList<String> list;
	JButton btnok,btncancle;
	JTextArea text;
	JScrollPane sp;
	public C_组合框(){
		
		f = new JFrame("java注册");
		lab1 = new JLabel("用户名:");
		lab2 = new JLabel("密码:");
		lab3 = new JLabel("性别:");
		lab4 = new JLabel("地址:");
		text1 = new JTextField();
		text2 = new JPasswordField();
		rb1 = new JRadioButton("男");
		rb2 = new JRadioButton("女");
		
		combox = new JComboBox<>();		//实例化组合框，并添加数据
		combox.addItem("北京");
		combox.addItem("天津");
		combox.addItem("上海");
		combox.addItem("重庆");
		
		lab5 = new JLabel("邮箱");
		
		btnok = new JButton("ok");
		btncancle = new JButton("cancle");
		
		text = new JTextArea();
		f.setVisible(true);
		f.setLayout(null);
		f.setBounds(50,30, 600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		ButtonGroup bg = new ButtonGroup();
		String mail[] ={"qweuiuoi@as","dlsd"};
		list = new JList<String>(mail);
		
		sp = new JScrollPane();
		
		bg.add(rb1);
		bg.add(rb2);
		
		lab1.setBounds(10, 10, 50, 30);
		text1.setBounds(60, 10, 150, 30);
		lab2.setBounds(10, 40, 50, 30);
		text2.setBounds(60,40, 150, 30);
		lab3.setBounds(10, 70, 50, 30);
		rb1.setBounds(60, 70, 50, 30);
		rb2.setBounds(105, 70, 50, 30);
		lab4.setBounds(10, 100, 50, 30);
		combox.setBounds(60,100 ,60,30);
		lab5.setBounds(10, 130, 40, 30);
		list.setBounds(40, 130, 100, 50);
		btnok.setBounds(60, 190, 70, 30);
		btncancle.setBounds(150, 190, 70, 30);
		text.setBounds(30, 230, 300, 400);
		sp.setBounds(30, 230, 300, 400);
		
		f.add(lab1);
		f.add(lab2);
		f.add(text1);
		f.add(text2);
		f.add(lab3);
		f.add(rb1);
		f.add(rb2);
		f.add(lab4);
		f.add(combox);
		f.add(list);
		f.add(lab5);
		f.add(btnok);
		f.add(btncancle);
		//f.add(sp);
		f.add(text);
		btnok.addActionListener(this);
		btncancle.addActionListener(this);
	}
	public static void main(String[] args) {
		new C_组合框();
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(btnok)){
		text.setText("用户名："+text1.getText()+"\n"+"密码为："+text2.getText());
		}
		if(e.getSource().equals(btncancle)){
			System.out.println("取消");
		}
	}
}
