package designpattern.demo.singleton;

/**
 * 饿汉单例模式(线程安全模式)
 * @author anqi.xiong
 *
 */
public class HungerManSingleton {
	private static HungerManSingleton instance = new HungerManSingleton();

	private HungerManSingleton() {
	}

	public static HungerManSingleton getInstance() {
		return instance;
	}
	
	public void showMessage() {
		System.out.println("I am HungerManSingleton.java!");
	}
}
