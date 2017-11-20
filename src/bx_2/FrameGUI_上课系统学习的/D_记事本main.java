package bx_2.FrameGUI_上课系统学习的;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class D_记事本main implements MouseListener,ActionListener{
	JFrame f;
	JScrollPane fb;
	JMenu mf ,me,mt,mv,help;
	JMenuBar mb;//菜单条
	JMenuItem fnew,open ,save ,quit;//菜单项
	JMenuItem copy,cut,paste;
	JMenuItem oline , font;
	JMenuItem im,call;
	JMenuItem local ,map;
	JButton btnew,ctn,dtn,htn,gtn;
	JToolBar tBar;
	JTextArea text;
	JPopupMenu pMenu;
	JMenuItem pCopy , pCute ,past;
	int flag = 0;
	
	public D_记事本main(){
		f = new JFrame("笔记本");
		mf = new JMenu("文件(F)");
		me = new JMenu("编辑(E)");
		mt = new JMenu("格式(O)");
		mv = new JMenu("查看(V)");
		help = new JMenu("帮助(H)");
		
		mb = new JMenuBar();
		mb.add(mf);
		mb.add(me);
		mb.add(mt);
		mb.add(mv);
		mb.add(help);
		
		fnew = new JMenuItem("新建");
		open = new JMenuItem("打开");
		save = new JMenuItem("保存");
		quit = new JMenuItem("退出");
		
		copy = new JMenuItem("复制");
		cut = new JMenuItem("剪切");
		paste = new JMenuItem("粘贴");
		
		oline = new JMenuItem("换行");
		font = new JMenuItem("字体");
		
		im = new JMenuItem("信息");
		call = new JMenuItem("联系");
		
		local = new JMenuItem("本地");
		map = new JMenuItem("地图");
		
		text = new JTextArea();
		//设置文本框的字体
		text.setFont(new Font("宋体",1,20));
		
		fb = new JScrollPane(text);
		tBar = new JToolBar();
		
		btnew = new JButton(new ImageIcon(""));
		ctn = new JButton(new ImageIcon(""));
		dtn = new JButton(new ImageIcon(""));
		htn = new JButton(new ImageIcon(""));
		gtn = new JButton(new ImageIcon(""));
		
		pMenu = new JPopupMenu();
		pCopy = new JMenuItem("复制");
		pCute = new JMenuItem("剪切");
		past = new JMenuItem("粘贴");
		
		pMenu.add(pCopy);
		pMenu.add(pCute);
		pMenu.add(past);
		
		tBar.add(btnew);
		tBar.add(ctn);
		tBar.add(dtn);
		tBar.add(htn);
		tBar.add(gtn);
		
		mf.add(fnew);
		mf.add(open);
		mf.add(save);
		mf.add(quit);
		
		me.add(copy);
		me.add(cut);
		me.add(paste);
				
		mt.add(oline);
		mt.add(font);
		
		help.add(im);
		help.add(call);
		
		mv.add(local);
		mv.add(map);
		
		f.setVisible(true);
		f.setSize(600, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(tBar,"North");
		f.setJMenuBar(mb);
		f.add(text);
		text.addMouseListener(this);
		open.addActionListener(this);
		btnew.addActionListener(this);
		save.addActionListener(this);
		quit.addActionListener(this);
		pCopy.addActionListener(this);
		paste.addActionListener(this);
		pCute.addActionListener(this);
		copy.addActionListener(this);
		past.addActionListener(this);
		cut.addActionListener(this);
		oline.addActionListener(this);
		font.addActionListener(this);
		ctn.addActionListener(this);
		dtn.addActionListener(this);
		htn.addActionListener(this);
		gtn.addActionListener(this);
		
	}
	public static void main(String[] args) {
		new D_记事本main();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == 3){
			pMenu.show(text, e.getX(),e.getY());
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(open)){
			/*
			File file =new File("c:\\cba\\abc.txt");
			try {
				FileReader fw = new FileReader(file);
				char c[] = new char[1024];
				int n;
				while((n=fw.read(c)) != -1){
					String s = new String(c, 0, n);
					text.setText(text.getText()+s);
				}
				fw.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			File f = new File("c:\\cba\\abc.txt");
			new Filetool(f, text);
			*/
			
			open();
		}
		else if (e.getSource().equals(btnew)){
			open();
		}else if(e.getSource().equals(save) || e.getSource().equals(gtn)){
			save();
		}else if(e.getSource().equals(quit)){
			System.exit(0);
		}
		//复制命令
		if(e.getSource().equals(pCopy)|| e.getSource().equals(copy) || e.getSource().equals(ctn)){
			text.copy();
		}
		
		if(e.getSource().equals(paste)||e.getSource().equals(past)||e.getSource().equals(dtn)){
			text.paste();
		}
		if(e.getSource().equals(pCute)||e.getSource().equals(cut)||e.getSource().equals(htn)){
			text.cut();
		}
		//换行
		if(e.getSource().equals(oline)){
			if(flag==0){
				text.setLineWrap(true);
				flag = 1;
			}else{
				text.setLineWrap(false);
				flag = 0;
			}
		}
		//字体
		if(e.getSource().equals(font)){
			new D_记事本字体Dailog(text);
		}
		
	}
	//打开文件的方法
	public void open(){
		//打开文件对话框
		FileDialog fd = new FileDialog(f, "打开",0 );
		fd.setVisible(true);
		String s1 = fd.getFile();//获得文件名并赋值
		String s2 = fd.getDirectory();//获得文件的详细路径
		if (s1 == null || s2 ==null){
			System.out.println("请选择正确的文件");
		}else{
			File file = new File(s2+s1);
			new D_记事本打开(file, text);
			f.setTitle(s1+"-记事本");
		}
	}
	public void save(){
		FileDialog fd = new FileDialog(f, "保存",1 );
		fd.setVisible(true);
		String s1 = fd.getFile();//获得文件名并赋值
		String s2 = fd.getDirectory();
		File file = new File(s2+s1);
		if (s1 == null || s2 ==null){
			System.out.println("请选择正确的文件");
		}else{
				new D_记事本保存(file, text);
		}
	}
}
