package cb.Java设计模式_极难度_慢慢理解_都很重要;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
代理模式(Proxy)：		【动态代理更重要一些】
	代理模式其实就是多一个代理类出来，替原对象进行一些操作。
		比如咱有的时候打官司需要请律师，因为律师在法律方面有专长，可以替咱进行操作表达咱的想法，这就是代理的意思。
	代理模式分为两类：
		1、静态代理(不使用jdk里面的方法)				// 【其实就是用多态，另外一个类来实现这个接口】
		2、动态代理(使用jdk里面的InvocationHandler和Proxy)。
	代理模式好处：
		1、一个代理类调用原有的方法，且对产生的结果进行控制。
		2、可以将功能划分的更加清晰，有助于后期维护。
*/

interface Targetable1 {
	public void targetMethod();
}

class Target1 implements Targetable1 {
	@Override
	public void targetMethod() {
		System.out.println("this is a target method...");
	}
}

class 静态代理 implements Targetable1 {
	private Target1 target;

	public 静态代理() {
		this.target = new Target1();
	}

	private void beforeMethod() {
		System.out.println("this is a method before proxy...");
	}

	private void afterMethod() {
		System.out.println("this is a method after proxy...");
	}

	// 在执行目标方法前后加了逻辑
	@Override
	public void targetMethod() {
		beforeMethod();
		target.targetMethod();
		afterMethod();
	}
}

// 【下面是动态代理的内容】
class User {
	private String username;
	private String password;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
}

// 目标接口
interface IUserDao {
	public void add(User user);
}

class UserDaoImpl implements IUserDao {
	@Override
	public void add(User user) {
		System.out.println("add a user successfully...");
	}
}

// 日志类 --> 待织入的Log类
class LogEmbed implements InvocationHandler {
	private IUserDao target;

	 // 对target进行封装
	public IUserDao getTarget() {
		return target;
	}

	public void setTarget(IUserDao target) {
		this.target = target;
	}

	private void beforeMethod() {
		System.out.println("add start...");
	}

	private void afterMethod() {
		System.out.println("add end...");
	}

	/**
	 * 这里用到了反射
	 * proxy 代理对象
	 * method 目标方法
	 * args 目标方法里面参数列表
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		beforeMethod();
		// 回调目标对象的方法
		method.invoke(target, args);
		System.out.println("LogEmbed --invoke-> method = " + method.getName());
		afterMethod();
		return null;
	}
}

public class B_2代理Proxy设计模式_很重要 {
	public static void main(String[] args) {
		Targetable1 p1 = new 静态代理();
		p1.targetMethod();
		System.out.println();

		IUserDao userDao = new UserDaoImpl();
		LogEmbed log = new LogEmbed();
		log.setTarget(userDao);
		// 根据实现的接口产生代理
		IUserDao userDaoProxy = (IUserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
				userDao.getClass().getInterfaces(), log);
		/** 
         * 注意：这里在调用IUserDao接口里的add方法时， 
         * 代理对象会帮我们调用实现了InvocationHandler接口的LogEmbed类的invoke方法。 
         * 这样做，是不是有点像Spring里面的拦截器呢？ 
         */
		userDaoProxy.add(new User("张三", "123"));
	}
}
