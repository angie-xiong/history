package designpattern.demo.singleton;

/**
 * 单例模式的基本雏形形式，其他的模式都基于这个的思路衍生而来
 * @author anqi.xiong
 *
 */
public class SingletonObject {
	private static SingletonObject instance = new SingletonObject();

	private SingletonObject() {}
	
	public static SingletonObject getInstance() {
		return instance;
	}
	
	public void showMessage() {
		System.out.println("I am SingletonObject.java!");
	}
}
