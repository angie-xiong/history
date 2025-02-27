package designpattern.demo.singleton;

/**
 * 静态内部类单例模式
 * 优点：线程安全，懒加载，性能高
 * 缺点：
 * 
 * @author anqi.xiong
 *
 */
public class InnerStaticSingleton {
	private static class SingletonHolder {
		private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
	}

	private InnerStaticSingleton() {
	}

	public static final InnerStaticSingleton getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public void showMessage() {
		System.out.println("I am InnerStaticSingleton.java!");
	}
}
