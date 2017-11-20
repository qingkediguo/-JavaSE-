package cb.Java设计模式_极难度_慢慢理解_都很重要;

/*
访问者模式(Visitor)：
	把数据结构和作用于结构上的操作解耦合，使得操作集合可相对自由地演化。
	访问者模式适用于数据结构相对稳定而算法又容易变化的系统。
	
优点
	符合单一职责原则：凡是适用访问者模式的场景中，元素类中需要封装在访问者中的操作必定是与元素类本身关系不大且是易变的操作，使用访问者模式一方面符合单一职责原则，
				     另一方面，因为被封装的操作通常来说都是易变的，所以当发生变化时，就可以在不改变元素类本身的前提下，实现对变化部分的扩展。
	扩展性良好：元素类可以通过接受不同的访问者来实现对不同操作的扩展。
	
缺点
	增加新的元素类比较困难。
		通过访问者模式的代码可以看到，在访问者类中，每一个元素类都有它对应的处理方法，
		也就是说，每增加一个元素类都需要修改访问者类（也包括访问者类的子类或者实现类），修改起来相当麻烦。
		也就是说，在元素类数目不确定的情况下，应该慎用访问者模式。所以，访问者模式比较适用于对已有功能的重构，
		比如说，一个项目的基本功能已经确定下来，元素类的数据已经基本确定下来不会变了，会变的只是这些元素内的相关操作，
		这时候，我们可以使用访问者模式对原有的代码进行重构一遍，这样一来，就可以在不修改各个元素类的情况下，对原有功能进行修改。
		
适用场景
	假如一个对象中存在着一些与本对象不相干（或者关系较弱）的操作，为了避免这些操作污染这个对象，则可以使用访问者模式来把这些操作封装到访问者中去。
	假如一组对象中，存在着相似的操作，为了避免出现大量重复的代码，也可以将这些重复的操作封装到访问者中去。
*/

interface Visitor {
	public void visitor(Subject1 subject); // 参数是待访问的对象
}

class MyVisitor implements Visitor {
	@Override
	public void visitor(Subject1 subject) {
		System.out.println("MyVisitor 访问的属性值为：" + subject.getField());
	}
}

class OtherVisitor implements Visitor {
	@Override
	public void visitor(Subject1 subject) {
		System.out.println("OtherVisitor 访问的属性值为：" + subject.getField());
	}
}

interface Subject1 {
	// 接受将要访问它的对象
	public void accept(Visitor visitor);

	// 获取将要被访问的属性
	public String getField();
}

class MySubject implements Subject1 {
	private String name;

	public MySubject(String name) {
		this.name = name;
	}

	// 这是核心：接收【指定的访问者】来访问咱自身的MySubject类的状态或特征			// 【这里是最核心的同意进来访问的逻辑】
	@Override
	public void accept(Visitor visitor) {
		visitor.visitor(this);
	}

	@Override
	public String getField() {
		return name;
	}
}

public class C_11访问者设计模式_比较重要 {
	public static void main(String[] args) {
		Subject1 subject = new MySubject("张三");
		subject.accept(new MyVisitor());
		subject.accept(new OtherVisitor());
	}
}
