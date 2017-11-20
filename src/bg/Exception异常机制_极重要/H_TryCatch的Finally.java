package bg.Exception异常机制_极重要;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * finally:被finally控制的语句体一定会执行
 * 注意：如果在执行到finally之前jvm退出了，就不能执行了。
 * 
 * A:格式
 * 		try...catch...finally...
 * B:用于释放资源，在IO流操作和数据库操作中会见到
 */
public class H_TryCatch的Finally {
	public static void main(String[] args) {
		String s = "2014-11-20";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date d = null;
		try {
			d = sdf.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			// System.exit(0);			// 【如果要强行不执行finally的内容就只能强行退出了】
		} finally {
			System.out.println("这里的代码是可以执行的");
		}

		System.out.println(d);
	}
}