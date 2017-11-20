package bi.IO之File;

import java.io.File;

/*
 * 我们要想实现IO的操作，就必须知道硬盘上文件的表现形式。
 * 而Java就提供了一个类File供我们使用。
 * 
 * File:文件和目录(文件夹)路径名的抽象表示形式
 * 构造方法：
 * 		File(String pathname)：根据一个路径得到File对象
 * 		File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
 * 		File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
 */

// 【很重要的一点，他创建了file对象之后并不会创建这个文件，也就是这个文件是存在于内存里的，但是没有写入到硬盘里。】

public class A_File基础 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// File(String pathname)：根据一个路径得到File对象
		// 把C:\\Users\\admin\\Desktop\\a.txt封装成一个File对象
		File file = new File("C:\\Users\\admin\\Desktop\\a.txt");		// 【自行替换成自己的测试目录】

		// File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
		File file2 = new File("C:\\Users\\admin\\Desktop", "a.txt");

		// File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
		File file3 = new File("C:\\Users\\admin\\Desktop");
		File file4 = new File(file3, "a.txt");

		System.out.println(file);
		// 以上三种方式其实效果一样
	}
}