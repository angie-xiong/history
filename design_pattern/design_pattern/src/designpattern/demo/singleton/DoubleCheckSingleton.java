package designpattern.demo.singleton;

/**
 * 双重校验锁单例模式(线程安全，效率高，非懒加载，性能高)
 * @author anqi.xiong
 *
 */
public class DoubleCheckSingleton {
	private volatile static DoubleCheckSingleton instance;
	private DoubleCheckSingleton() {}
	
	public static DoubleCheckSingleton getInstance() {
		if(null == instance) {
			synchronized(DoubleCheckSingleton.class) {
				if(null == instance) {
					return new DoubleCheckSingleton();
				}
			}
		}
		return instance;
	}
	
	public void showMessage() {
		System.out.println("I am DoubleCheckSingleton.java!");
	}
}
