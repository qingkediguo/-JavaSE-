package bx_2.FrameGUI_上课系统学习的;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

public class D_记事本保存 {
	File f;
	JTextArea textArea;
	public D_记事本保存(File file,JTextArea text) {
		f = file;
		textArea = text;
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(textArea.getText());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
