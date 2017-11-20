package ca.Java8新特性_有一定的掌握程度就行;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A_Lambda表达式入门 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
/*
 * 【原版】
		// 【首先看看在老版本的Java中是如何排列字符串的】
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
*/
/*
 * 【第一个版本】
		Collections.sort(names, (String a, String b) -> {
		    return b.compareTo(a);  
		});
*/
/*
 * 【第二个版本】
		Collections.sort(names, (String a, String b) -> b.compareTo(a));
*/
/*
 * 【终极版】
 * Java编译器可以自动推导出参数类型，所以你可以不用再写一次类型。
 * 接下来我们看看lambda表达式还能作出什么更方便的东西来
*/
		Collections.sort(names, (a, b) -> b.compareTo(a));
	}
}
