package aa.编程基础;

/*
break:跳出。
break作用的范围：要么是switch语句，要么是循环语句。
记住：当break语句单独存在时，下面不要定义其他语句，因为执行不到。
break跳出所在的当前循环。
如果出现了循环嵌套，break想要跳出指定的循环，可以通过标号来完成。
continue:继续。
作用的范围：循环结构。
continue：结束本次循环，继续下次循环。
如果continue单独存在时，下面不要有任何语句，因为执行不到。
*/

/*
需求：
打印一个99乘法表。
思路：
1，定义一个类。
2，为了可以运行，该类中定义一个main函数。
3，将99惩罚表的代码定义在main函数中。
步骤：
1，用class关键字定义名称Demo99为的类。
2，定义main函数。
3，
1*1=1
1*2=2 2*2=4
1*3=3 2*3=6 3*3=9
分析一下99乘法表。
*/


public class C_九九乘法表 {
	public static void main(String[] args) {
		for (int x = 1;x<=9 ;x++ )
		{
			for (int y=1; y<=x ; y++)//
			{
				System.out.print(y+"*"+x+"="+y*x+"\t");
			}
		System.out.println("");
		}
	}
}