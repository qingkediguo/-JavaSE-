package bz.Java反射_很重要_里面有个配置文件_很重要;

import java.io.FileReader;
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Method;
import java.util.Properties;

/*
 * 通过配置文件运行类中的方法
 * 
 * 反射：
 * 		需要有配置文件配合使用。
 * 		用class.txt代替。
 * 		并且你知道有两个键。
 * 			className
 * 			methodName
 */

// ☆☆☆☆☆☆☆☆☆☆☆☆☆☆【下面是通过配置文件来加载反射所需要的配置文件，我这里就跳过了】☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆


public class H_加载配置文件_很重要 {
	public static void main(String[] args) throws Exception {
		// 反射前的做法
		// Student s = new Student();
		// s.love();
		// Teacher t = new Teacher();
		// t.love();
		// Worker w = new Worker();
		// w.love();
		// 反射后的做法

		// 加载键值对数据
		Properties prop = new Properties();
		FileReader fr = new FileReader("配置文件1.txt");	// 【配置文件在JavaSE中是放在项目的根目录的】
		prop.load(fr);
		fr.close();

		// 获取数据
		String className = prop.getProperty("className");
		String methodName = prop.getProperty("methodName");
		
		System.out.println(className);
		System.out.println(methodName);

		// 反射
//		Class<?> c = Class.forName(className);

//		Constructor<?> con = c.getConstructor();
//		Object obj = con.newInstance();

		// 调用方法
//		Method m = c.getMethod(methodName);
//		m.invoke(obj);
	}
}