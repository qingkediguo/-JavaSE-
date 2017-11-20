package cb.Java设计模式_极难度_慢慢理解_都很重要;

/*
迭代器设计模式：
	提供了一种方法顺序访问一个聚合对象中的各个元素，而又不暴露其内部的表示。
*/

interface Iterator {
	// 前移
	public Object previous();

	// 后移
	public Object next();

	// 判断是否有下一个元素
	public boolean hasNext();
}

interface Collection {
	// 迭代器对象
	public Iterator iterator();

	// 取得集合中的某个元素
	public Object get(int i);

	// 取得集合大小
	public int size();
}

class MyIterator implements Iterator {
	private Collection collection;
	private int pos = -1;

	public MyIterator(Collection collection) {
		this.collection = collection;
	}

	@Override
	public Object previous() {
		if (pos > 0) {
			pos--;
		}
		return collection.get(pos);
	}

	@Override
	public Object next() {
		if (pos < collection.size() - 1) {
			pos++;
		}
		return collection.get(pos);
	}

	@Override
	public boolean hasNext() {
		if (pos < collection.size() - 1) {
			return true;
		}
		return false;
	}
}

class MyCollection implements Collection {
	private String[] strArray = { "aa", "bb", "cc", "dd" };

	@Override
	public Iterator iterator() {
		return new MyIterator(this);
	}

	@Override
	public Object get(int i) {
		return strArray[i];
	}

	@Override
	public int size() {
		return strArray.length;
	}
}

public class C_4迭代器设计模式_很重要 {
	public static void main(String[] args) {
		Collection collection = new MyCollection();
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
