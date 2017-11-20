package as.Integer;

/*
 * Integer的构造方法：
 * public Integer(int value)
 * public Integer(String s)
 * 		注意：这个字符串必须是由数字字符组成
 */

// 【进制转换相关的方法自行去百度】

public class A_Integer基础 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// 方式1
		int i = 100;
		Integer ii = new Integer(i);
		System.out.println("ii:" + ii);

		// 方式2
		String s = "100";
		// NumberFormatException
		// String s = "abc";
		Integer iii = new Integer(s);
		System.out.println("iii:" + iii);
	}
}