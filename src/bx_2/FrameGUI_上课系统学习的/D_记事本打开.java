package bx_2.FrameGUI_上课系统学习的;

import java.io.File;
import java.io.FileReader;

import javax.swing.JTextArea;

public class D_记事本打开 {
	File f;
	JTextArea text;
	public D_记事本打开(File filename,JTextArea txt) {
		f = filename;
		text = txt;
		//字符流
		try {
			FileReader fr = new FileReader(f);
			char []cs = new char [1024];
			int n ;
			while((n = fr.read(cs)) !=-1){
				String s =new String(cs, 0,n);
				txt.setText(txt.getText()+s);
			}
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
