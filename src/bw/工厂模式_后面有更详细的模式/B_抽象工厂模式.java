package bw.工厂模式_后面有更详细的模式;

interface Food {
	public abstract void eat();
}
class Apple implements Food {
	@Override
	public void eat() {
		System.out.println("eat apple");
	}
}

interface Weapon {
	public abstract void play();
}

class AK47 implements Weapon {
	@Override
	public void play() {
		System.out.println("AK47 dadada");
	}
}

interface Vehicle {
	public abstract void run();
}

class Car implements Vehicle {
	@Override
	public void run() {
		System.out.println("car driver");
	}
}

//抽象工厂类
abstract class AbstractFactory {
	public abstract Vehicle createVehicle();

	public abstract Weapon createWeapon();

	public abstract Food createFood();
}

// 具体工厂类，其中Food,Vehicle，Weapon是抽象类，
class DefaultFactory extends AbstractFactory {
	@Override
	public Food createFood() {
		return new Apple();
	}

	@Override
	public Vehicle createVehicle() {
		return new Car();
	}

	@Override
	public Weapon createWeapon() {
		return new AK47();
	}
}

// 测试类
public class B_抽象工厂模式 {
	public static void main(String[] args) {
		AbstractFactory f = new DefaultFactory();
		Vehicle v = f.createVehicle();
		v.run();
		Weapon w = f.createWeapon();
		w.play();
		Food a = f.createFood();
		a.eat();
	}
}