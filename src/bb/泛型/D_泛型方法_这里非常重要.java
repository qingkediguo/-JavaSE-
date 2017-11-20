package bb.泛型;

//public class ObjectTool<T> {
// public void show(String s) {
// System.out.println(s);
// }
//
// public void show(Integer i) {
// 	System.out.println(i);
// }
//
// public void show(Boolean b) {
//	 System.out.println(b);
// }
//
//public void show(T t) {
//	System.out.println(t);
//}
//}

/*
* 泛型方法：把泛型定义在方法上
*/

// 【这里适用于一个类里可能 会有多个不同的类型的成员变量】

public class D_泛型方法_这里非常重要 {
	public <T> void show(T t) {
		System.out.println(t);
	}
}