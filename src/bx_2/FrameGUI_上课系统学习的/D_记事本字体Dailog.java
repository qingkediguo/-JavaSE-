package bx_2.FrameGUI_上课系统学习的;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class D_记事本字体Dailog implements ActionListener, ListSelectionListener {
	JDialog dialog;
	JLabel labName, labStyle, labSize, labAnli, labshili;
	JTextField textName, textStyle, textSize;
	JList<String> lisName, lisStyle, lisSize;
	JScrollPane jsName, jsStyle, jsSize;// 定义滚动面板
	JButton btnok, btncanle;
	JMenuBar mb;
	JMenuItem sc;
	JTextArea txt;
	int style;
	int size;

	public D_记事本字体Dailog(JTextArea text) {
		dialog = new JDialog();
		txt = text;
		// 实例化文本标题
		labName = new JLabel("字体(F):");
		labStyle = new JLabel("字形(Y):");
		labSize = new JLabel("字号(S):");
		labAnli = new JLabel("AaBbYyZz");
		labshili = new JLabel("示例：");
		// 实例化文本域
		textName = new JTextField(txt.getFont().getFontName());
		textStyle = new JTextField(txt.getFont().getStyle() + "");
		textSize = new JTextField(txt.getFont().getSize() + "");
		// 实例化列表
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] Name = environment.getAvailableFontFamilyNames();
		String Style[] = { "常规", "加粗", "倾斜" };
		String Size[] = { "2", "10", "30", "20" };
		lisName = new JList<String>(Name);
		lisStyle = new JList<String>(Style);
		lisSize = new JList<String>(Size);
		// 实例化滚动面板
		jsName = new JScrollPane(lisName);
		jsSize = new JScrollPane(lisSize);
		jsStyle = new JScrollPane(lisStyle);
		// 实例化按钮
		btnok = new JButton("确定");
		btncanle = new JButton("取消");
		// 实例化下拉菜单
		sc = new JMenuItem("西方语言");
		// 实例化菜单
		mb = new JMenuBar();
		mb.add(sc);
		// 设置布局
		dialog.setLayout(null);

		// 设置大小与位置

		labName.setBounds(10, 10, 50, 30);
		textName.setBounds(10, 40, 120, 30);
		jsName.setBounds(10, 70, 120, 150);
		labStyle.setBounds(170, 10, 50, 30);
		textStyle.setBounds(170, 40, 120, 30);
		jsStyle.setBounds(170, 70, 120, 150);
		labSize.setBounds(330, 10, 50, 30);
		textSize.setBounds(330, 40, 90, 30);
		jsSize.setBounds(330, 70, 90, 150);
		btnok.setBounds(180, 400, 70, 40);
		btncanle.setBounds(280, 400, 70, 40);
		labshili.setBounds(150, 240, 50, 30);
		labAnli.setBounds(180, 250, 500, 100);
		// 获取并设置字形
		style = text.getFont().getStyle();
		if (style == 0) {
			textStyle.setText("常规");
		} else if (style == 1) {
			textStyle.setText("加粗");
		} else if (style == 2) {
			textStyle.setText("倾斜");
		}

		dialog.setVisible(true);
		dialog.setTitle("字体");
		dialog.setSize(500, 500);
		dialog.setResizable(false);
		dialog.add(labName);
		dialog.add(jsName);
		dialog.add(textName);
		dialog.add(labStyle);
		dialog.add(jsStyle);
		dialog.add(textStyle);
		dialog.add(jsSize);
		dialog.add(labSize);
		dialog.add(textSize);
		dialog.add(btnok);
		dialog.add(btncanle);
		dialog.add(labshili);
		dialog.add(labAnli);
		dialog.add(mb);
		btncanle.addActionListener(this);
		btnok.addActionListener(this);
		lisName.addListSelectionListener(this);
		lisStyle.addListSelectionListener(this);
		lisSize.addListSelectionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btncanle)) {
			// 销毁对话框
			dialog.dispose();
		} else if (e.getSource().equals(btnok)) {
			txt.setFont(new Font(textName.getText(), style, Integer.valueOf(textSize.getText())));
			dialog.dispose();// 设置文本框中的字体，字形，字号，并关闭窗口。
		}
	}

	@Override
	// 实现选择字体、字形、字号并显示到该文本框中。
	public void valueChanged(ListSelectionEvent e) {
		int style = 0;
		if (textStyle.getText().equals("常规")) {
			style = 0;
		} else if (textStyle.getText().equals("加粗")) {
			style = 1;
		} else if (textStyle.getText().equals("倾斜")) {
			style = 3;
		}
		labAnli.setFont(new Font(textName.getText(), style, Integer.valueOf(textSize.getText())));

		if (e.getSource().equals(lisName)) {
			textName.setText(lisName.getSelectedValue());
		} else if (e.getSource().equals(lisStyle)) {
			textStyle.setText(lisStyle.getSelectedValue());
		} else if (e.getSource().equals(lisSize)) {
			textSize.setText(lisSize.getSelectedValue());
		}
	}

}