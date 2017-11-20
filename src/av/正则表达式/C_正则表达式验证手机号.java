package av.正则表达式;

import java.util.Scanner;

// 【这个正则肯定是不完善的。还有很多种电话号码的情况没有考虑到】

/*
 * 判断功能
 *		String类的public boolean matches(String regex)
 *
 * 需求：
 * 		判断手机号码是否满足要求?
 * 
 * 分析：
 * 		A:键盘录入手机号码
 * 		B:定义手机号码的规则
 * 			13436975980
 * 			13688886868
 * 			13866668888
 * 			13456789012
 * 			13123456789
 * 			18912345678
 * 			18886867878
 * 			18638833883
 * 		C:调用功能，判断即可
 * 		D:输出结果
 */
public class C_正则表达式验证手机号 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//键盘录入手机号码
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你的手机号码：");
		String phone = sc.nextLine();
		
		//定义手机号码的规则
		String regex = "1[358]\\d{9}";
		String zhengze = "1[358][0-9]{9}";
		
		//调用功能，判断即可
		boolean flag = phone.matches(zhengze);
		
		//输出结果
		System.out.println("flag:"+flag);
		
		sc.close();
	}
}