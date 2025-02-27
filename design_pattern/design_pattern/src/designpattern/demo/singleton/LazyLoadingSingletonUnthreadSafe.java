package designpattern.demo.singleton;

/**
 * ����ʽ/�̲߳���ȫ����ģʽ
 * @author anqi.xiong
 *
 */
public class LazyLoadingSingletonUnthreadSafe {
	private static LazyLoadingSingletonUnthreadSafe instance;
	private LazyLoadingSingletonUnthreadSafe() {}
	
	public static LazyLoadingSingletonUnthreadSafe getInstance() {
		if(null == instance) {
			instance = new LazyLoadingSingletonUnthreadSafe();
		}
		return instance;
	}
	

	public void showMessage() {
		System.out.println("I am LazyLoadingSingletonUnthreadSafe.java!");
	}
}
