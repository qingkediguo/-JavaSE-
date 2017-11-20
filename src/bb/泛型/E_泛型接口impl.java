package bb.泛型;

//实现类在实现接口的时候
//第一种情况：已经知道该是什么类型的了

//public class InterImpl implements Inter<String> {
//
//	@Override
//	public void show(String t) {
//		System.out.println(t);
//	}
//}

//第二种情况：还不知道是什么类型的
public class E_泛型接口impl<T> implements E_泛型接口_非常重要_适用于很多场景<T> {
	@Override
	public void show(T t) {
		System.out.println(t);
	}
}
