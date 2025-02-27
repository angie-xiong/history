package designpattern.demo.singleton;

/**
 * ��������ģʽ(�̰߳�ȫģʽ)
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
