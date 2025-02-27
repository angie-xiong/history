package designpattern.demo.singleton;

/**
 * ˫��У��������ģʽ(�̰߳�ȫ��Ч�ʸߣ��������أ����ܸ�)
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
