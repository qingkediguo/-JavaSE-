package bb.泛型;

/*
 * 泛型类：把泛型定义在类上
 */

// 【这里适合用于一个类里是同一种类型的情况】

public class C_泛型类_这里非常重要<T> {
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
}