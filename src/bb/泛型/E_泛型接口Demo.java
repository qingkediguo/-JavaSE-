package bb.泛型;

public class E_泛型接口Demo {
	public static void main(String[] args) {
		// 第一种情况的测试
		// Inter<String> i = new InterImpl();
		// i.show("hello");

		// // 第二种情况的测试
		E_泛型接口impl<String> i = new E_泛型接口impl<String>();
		i.show("hello");

		E_泛型接口impl<Integer> ii = new E_泛型接口impl<Integer>();
		ii.show(100);
	}
}