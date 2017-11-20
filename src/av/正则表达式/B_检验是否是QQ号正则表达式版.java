package av.正则表达式;

import java.util.Scanner;

/*
 * 正则表达式：符合一定规则的字符串。
 * public boolean matches(String regex)	告知此字符串是否匹配给定的正则表达式
 */
public class B_检验是否是QQ号正则表达式版 {
	public static void main(String[] args) {
		// 创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你的QQ号码：");
		String qq = sc.nextLine();
		sc.close();
		System.out.println("checkQQ:" + checkQQ(qq));
	}

	public static boolean checkQQ(String qq) {
		// String regex ="[1-9][0-9]{4,14}";
		// boolean flag = qq.matches(regex);
		// return flag;

		//return qq.matches("[1-9][0-9]{4,14}");
		
		return qq.matches("[1-9]\\d{4,14}");
	}
}