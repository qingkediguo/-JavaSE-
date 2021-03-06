package cb.Java设计模式_极难度_慢慢理解_都很重要;

/*
解释器模式(Interpreter)：
	它定义了对象与对象之间进行某种操作之后会得到什么值。一般主要应用在OOP开发中的编译器的开发中，所以适用面比较窄。
	
解释器模式用来做各种各样的解释器，如正则表达式的解释器等等。
*/

class Entity {
	private double num1;
	private double num2;

	public Entity(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}
}

// 运算接口
interface Operatable {
	public double interpreter(Entity entity);
}

class AddOperation implements Operatable {
	@Override
	public double interpreter(Entity entity) {
		return entity.getNum1() + entity.getNum2();
	}
}

class MinusOperation implements Operatable {
	@Override
	public double interpreter(Entity entity) {
		return entity.getNum1() - entity.getNum2();
	}
}

public class C_9解释器设计模式_比较重要 {
	public static void main(String[] args) {
		/**
		 * 创建加法、减法运算
		 */
		AddOperation addOperation = new AddOperation();
		MinusOperation minusOperation = new MinusOperation();
		/**
		 * 一、分步运算
		 */
		double addResult = addOperation.interpreter(new Entity(20, 30));
		double minusResult = minusOperation.interpreter(new Entity(20, 30));
		System.out.println("addResult = " + addResult);
		System.out.println("minusResult = " + minusResult);
		/**
		 * 二、混合运算
		 */
		double mixResult = new AddOperation().interpreter(new Entity(addOperation.interpreter(new Entity(20, 30)),
				minusOperation.interpreter(new Entity(40, 50))));
		System.out.println("mixResult = " + mixResult);
	}
}
