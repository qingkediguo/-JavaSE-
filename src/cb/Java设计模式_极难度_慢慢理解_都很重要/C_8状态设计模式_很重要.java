package cb.Java设计模式_极难度_慢慢理解_都很重要;

/*
状态模式(State)：
	允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它的类。
	状态模式说白了就是一个对象有不同的状态，不同的状态对应不同的行为，它其实是对switch case这样的语句的拓展。
	
状态模式在工作流或游戏等各种系统中有大量使用，甚至是这些系统的核心功能设计，
	例如ERP系统中，一个批文的状态有多种：未办；正在办理；正在批示；正在审核；已经完成等各种状态，使用状态机可以封装这个状态的变化规则，从而达到扩充状态时，不必涉及到状态的使用者。

总结：
	封装基类状态的行为，并将行为委托到当前状态。
*/

interface State {
	public double operate(double num1, double num2);
}

class AddOperator implements State {
	@Override
	public double operate(double num1, double num2) {
		return num1 + num2;
	}
}

class SubOperator implements State {
	@Override
	public double operate(double num1, double num2) {
		return num1 - num2;
	}
}

class Student1 {
	private State state;

	public Student1(State state) {
		this.state = state;
	}

	// 设置状态
	public void setState(State state) {
		this.state = state;
	}

	public double operate(double num1, double num2) {
		return state.operate(num1, num2);
	}

}

public class C_8状态设计模式_很重要 {
	public static void main(String[] args) {
		Student1 s1 = new Student1(new AddOperator());
		System.out.println(s1.operate(12, 23));
		/**
		 * 改变状态，即改变了行为 --> 加法运算变成了减法运算
		 */
		s1.setState(new SubOperator());
		System.out.println(s1.operate(12, 23));
	}
}
