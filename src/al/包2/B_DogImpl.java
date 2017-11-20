package al.包2;

import ak.包1.A_JumpInterface;

/**
 * 这是具体的狗类
 * 
 * @author 风清扬
 * @version V1.0
 */
class dog extends A_Animal implements A_JumpInterface {

	@Override
	public void jump() {
		System.out.println("会跳高的狗");
	}

	@Override
	public void eat() {
		System.out.println("狗吃肉");
	}

	@Override
	public void sleep() {
		System.out.println("狗站着睡觉");
	}
}

public class B_DogImpl {
	public static void main(String[] args) {
		dog dog = new dog();
		dog.jump();
		dog.eat();
		dog.sleep();
	}
}