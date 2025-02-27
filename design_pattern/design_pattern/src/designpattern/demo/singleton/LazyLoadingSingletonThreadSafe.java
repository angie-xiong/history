package designpattern.demo.singleton;

/**
 * 懒汉式/线程安全单例模式
 * @author anqi.xiong
 *
 */
public class LazyLoadingSingletonThreadSafe {
	private static LazyLoadingSingletonThreadSafe instance;
	private LazyLoadingSingletonThreadSafe() {}
	
	public static synchronized LazyLoadingSingletonThreadSafe getInstance() {
		if(null == instance) {
			instance = new LazyLoadingSingletonThreadSafe();
		}
		return instance;
	}
	
	public void showMessage() {
		System.out.println("I am LazyLoadingSingletonThreadSafe.java!");
	}
}
