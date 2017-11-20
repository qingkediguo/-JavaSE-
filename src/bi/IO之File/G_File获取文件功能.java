package bi.IO之File;

import java.io.File;

/*
 * 获取功能：
 * public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
 * public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
 */

// list()方法是返回某个目录下的所有文件和目录的文件名，返回的是String数组
// listFiles()方法是返回某个目录下所有文件和目录的绝对路径，返回的是File数组

public class G_File获取文件功能 {
	public static void main(String[] args) {
		// 指定一个目录
		File file = new File("C:\\Users\\admin\\Desktop");

		// public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
		String[] strArray = file.list();
		for (String s : strArray) {
			System.out.println(s);
		}
		System.out.println("------------");

		// public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
		File[] fileArray = file.listFiles();
		for (File f : fileArray) {
			System.out.println(f);
		}
	}
}