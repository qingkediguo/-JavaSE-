package cb.Java设计模式_极难度_慢慢理解_都很重要;

/*
模板方法模式是:
	类的行为模式。
	准备一个抽象类，将部分逻辑以具体方法以及具体构造函数的形式实现，然后声明一些抽象方法来迫使子类实现剩余的逻辑。
	不同的子类可以以不同的方式实现这些抽象方法，从而对剩余的逻辑有不同的实现。这就是模板方法模式的用意。
	
比如定义一个操作中的算法的骨架，将步骤延迟到子类中。模板方法使得子类能够不去改变一个算法的结构即可重定义算法的某些特定步骤。

举个例子，以准备去学校所要做的工作（prepareGotoSchool）为例，
	假设需要分三步：穿衣服（dressUp），吃早饭（eatBreakfast），带上东西（takeThings）。学生和老师要做得具体事情肯定有所区别。

优点：
	模板方法模式通过把不变的行为搬移到超类，去除了子类中的重复代码。
	子类实现算法的某些细节，有助于算法的扩展。
	通过一个父类调用子类实现的操作，通过子类扩展增加新的行为，符合“开放-封闭原则”。
缺点：
	每个不同的实现都需要定义一个子类，这会导致类的个数的增加，设计更加抽象。
适用场景:
	在某些类的算法中，用了相同的方法，造成代码的重复。
	控制子类扩展，子类必须遵守算法规则。
*/

abstract class AbstractPerson {
	// 抽象类定义整个流程骨架
	public void prepareGotoSchool() {
		dressUp();
		eatBreakfast();
		takeThings();
	}

	// 以下是不同子类根据自身特性完成的具体步骤
	abstract void dressUp();

	abstract void eatBreakfast();

	abstract void takeThings();
}

class Student extends AbstractPerson {
	@Override
	protected void dressUp() {
		System.out.println("穿校服");
	}

	@Override
	protected void eatBreakfast() {
		System.out.println("吃妈妈做好的早饭");
	}

	@Override
	protected void takeThings() {
		System.out.println("背书包，带上家庭作业和红领巾");
	}
}

class Teacher extends AbstractPerson {
	@Override
	protected void dressUp() {
		System.out.println("穿工作服");
	}

	@Override
	protected void eatBreakfast() {
		System.out.println("做早饭，照顾孩子吃早饭");
	}

	@Override
	protected void takeThings() {
		System.out.println("带上昨晚准备的考卷");
	}
}

public class C_3模板方法设计模式_很重要 {
	public static void main(String[] args) {
		Student student = new Student();
		student.prepareGotoSchool();

		Teacher teacher = new Teacher();
		teacher.prepareGotoSchool();
	}
}
