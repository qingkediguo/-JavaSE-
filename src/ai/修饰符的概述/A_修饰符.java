package ai.修饰符的概述;

/*
修饰符：
	权限修饰符：private，默认的，protected，public
	状态修饰符：static，final
	抽象修饰符：abstract
	
类：
	权限修饰符：默认修饰符，public
	状态修饰符：final
	抽象修饰符：abstract
	
	用的最多的就是：public
	
成员变量：
	权限修饰符：private，默认的，protected，public
	状态修饰符：static，final
	
	用的最多的就是：private
	
构造方法：
	权限修饰符：private，默认的，protected，public
	
	用的最多的就是：public
	
成员方法：
	权限修饰符：private，默认的，protected，public
	状态修饰符：static，final
	抽象修饰符：abstract
	
	用的最多的就是：public
	
除此以外的组合规则：
	成员变量：public static final
	成员方法：public static 
	          public abstract
			  public final
	
*/


/*
权限修饰符：
				本类	同一个包下(子类和无关类)	不同包下(子类)	不同包下(无关类)
	private 	Y		
	默认			Y	Y
	protected	Y	Y					Y
	public		Y	Y					Y			Y
*/

public class A_修饰符 {
	public static void main(String[] args) {
		System.out.println("hello world");
	}
}
