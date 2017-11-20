package av.正则表达式;

import java.util.Scanner;

/*
 * 校验qq号码.
 * 		1:要求必须是5-15位数字
 * 		2:0不能开头
 * 
 * 分析：
 * 		A:键盘录入一个QQ号码
 * 		B:写一个功能实现校验
 * 		C:调用功能，输出结果。
 */
public class A_检验是否是QQ号原版 {
	public static void main(String[] args) {
		// 创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你的QQ号码：");
		String qq = sc.nextLine();
		
		System.out.println("checkQQ:"+checkQQ(qq));
		
		sc.close();
	}

	/*
	 * 写一个功能实现校验 两个明确： 明确返回值类型：boolean 明确参数列表：String qq
	 */
	public static boolean checkQQ(String qq) {
		boolean flag = true;

		// 校验长度
		if (qq.length() >= 5 && qq.length() <= 15) {
			// 0不能开头
			if (!qq.startsWith("0")) {
				// 必须是数字
				char[] chs = qq.toCharArray();
				for (int x = 0; x < chs.length; x++) {
					char ch = chs[x];
					if (!Character.isDigit(ch)) {
						flag = false;
						break;
					}
				}
			} else {
				flag = false;
			}
		} else {
			flag = false;
		}

		return flag;
	}
}