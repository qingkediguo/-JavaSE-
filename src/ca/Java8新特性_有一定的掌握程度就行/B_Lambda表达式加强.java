package ca.Java8新特性_有一定的掌握程度就行;

import java.util.Arrays;
import java.util.List;

public class B_Lambda表达式加强 {
	public static void main(String[] args) {
		List<String> ls = Arrays.asList("a", "b", "c");
		for (String e : ls) {
			System.out.println(e);
		}
		System.out.println("------------------------"); // 【这个是原版的】

		Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));
		System.out.println("------------------------"); // 【在上面这个代码中的参数e的类型是由编译器推理得出的，你也可以显式指定该参数的类型】

		Arrays.asList("a", "b", "c").forEach((String e) -> System.out.println(e));
		System.out.println("------------------------");

		// 【如果Lambda表达式需要更复杂的语句块，则可以使用花括号将该语句块括起来，类似于Java中的函数体】
		Arrays.asList("a", "b", "c").forEach(e -> {
			System.out.print(e);
			System.out.print(e);
		});
		System.out.println("\n------------------------");

		// 【Lambda表达式可以引用类成员和局部变量（会将这些变量隐式得转换成final的）】
		String separator = ","; // 【也就是这里的会自动变成final修饰符】
		Arrays.asList("a", "b", "d").forEach((String e) -> System.out.print(e + separator));

		// 【Lambda表达式有返回值，返回值的类型也由编译器推理得出。如果Lambda表达式中的语句块只有一行，则可以不用使用return语句】
		// 【下列两个代码片段效果相同】
		Arrays.asList("a", "b", "d").sort((e1, e2) -> e1.compareTo(e2));
		Arrays.asList("a", "b", "d").sort((e1, e2) -> {
			int result = e1.compareTo(e2);
			return result;
		});
	}
}
