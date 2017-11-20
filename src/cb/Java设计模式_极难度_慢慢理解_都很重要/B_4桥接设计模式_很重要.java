package cb.Java设计模式_极难度_慢慢理解_都很重要;

/*
桥接模式(Bridge)：			// 【经常用】
	把事物和其具体实现分开(抽象化与实现化解耦)，使他们可以各自独立的变化。
	假设你的电脑是双系统(WinXP、Win7)，而且都安装了mysql、oracle、sqlserver、DB2这4种数据库,那么你有2*4种选择去连接数据库。
	按平常的写法，咱要写2*4个类，但是使用了桥接模式，你只需写2+4个类,可以看出桥接模式其实就是一种将N*M转化成N+M组合的思想。
*/
interface Driver {
	public void method();
}

class MysqlDriver implements Driver {
	@Override
	public void method() {
		System.out.println("use mysql driver to connection db...");
	}
}

class OracleDriver implements Driver {
	@Override
	public void method() {
		System.out.println("use oracle driver to connection db...");
	}
}

abstract class Computer1 {
	public abstract void connection(Driver driver);
}

class WinXP extends Computer1 {
	@Override
	public void connection(Driver driver) {
		System.out.println("WinXP Computer");
		driver.method();
	}
}

class Win7 extends Computer1 {
	@Override
	public void connection(Driver driver) {
		System.out.println("Win7 Computer");
		driver.method();
	}
}

public class B_4桥接设计模式_很重要 {
	public static void main(String[] args) {
		// 第一种组合：winXP使用mysql驱动连接数据库
		Computer1 winxp = new WinXP();
		winxp.connection(new MysqlDriver());
		// 第二种组合：win7使用mysql驱动连接数据库
		Computer1 win7 = new Win7();
		win7.connection(new MysqlDriver());
		// 第三种组合：winXP使用oracle驱动连接数据库
		Computer1 cwinxp = new WinXP();
		cwinxp.connection(new OracleDriver());
		// 第四种组合：winXP使用oracle驱动连接数据库
		Computer1 cwin7 = new Win7();
		cwin7.connection(new OracleDriver());
	}
}
