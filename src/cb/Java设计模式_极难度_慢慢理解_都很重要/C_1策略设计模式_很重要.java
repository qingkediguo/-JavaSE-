package cb.Java设计模式_极难度_慢慢理解_都很重要;

/*
策略模式:
	让用户可以选择执行一个动作的方法，
	也就是说，用户可以选择不同的策略来进行操作。
	个人觉得策略模式可以用这个公式：不同的XXX 拥有不同的XXX供用户选择。
	比如说：不同的象棋棋子拥有不同的走法供用户选择。
	
	应用场景(仅代表个人观点)
		游戏中的角色武器、棋类游戏中的棋子走法等。
		
	这一篇的案例不是特别好，但是重写也很好理解，所以就不写了，自行理解就行【并且这个设计模式很常用】
*/

interface WeaponBehavior {
	void useWeapon();
}

// 武器
class KnifeBehavior implements WeaponBehavior {
	@Override
	public void useWeapon() {
		System.out.println("实现用匕首刺杀...");
	}
}

class BowAndArrowBehavior implements WeaponBehavior {
	@Override
	public void useWeapon() {
		System.out.println("实现用弓箭设计...");
	}
}

class AxeBehavior implements WeaponBehavior {
	@Override
	public void useWeapon() {
		System.out.println("实现用斧头劈砍...");
	}
}

class SwordBehavior implements WeaponBehavior {
	@Override
	public void useWeapon() {
		System.out.println("实现用宝剑挥舞...");
	}
}

// 角色
abstract class Character {
	// 将接口作为抽象角色的Field以便封装
	WeaponBehavior weaponBehavior = null;

	public void setWeapon(WeaponBehavior w) {
		weaponBehavior = w;
	}

	// 这里有点类似“代理模式”
	public void performWeapon() {
		weaponBehavior.useWeapon();
	}
}

// 国王使用宝剑挥舞
class King extends Character {
	public King() {
		weaponBehavior = new SwordBehavior();
	}
}

// 皇后使用匕首刺杀
class Queen extends Character {
	public Queen() {
		weaponBehavior = new KnifeBehavior();
	}
}

public class C_1策略设计模式_很重要 {
	public static void main(String[] args) {
		Character king = new King();
		king.performWeapon();
		// 这里有点类似于“状态模式”
		king.setWeapon(new AxeBehavior());
		king.performWeapon();

		System.out.println("----------------------");
		Character queen = new Queen();
		queen.performWeapon();
		queen.setWeapon(new BowAndArrowBehavior());
		queen.performWeapon();
	}
}
