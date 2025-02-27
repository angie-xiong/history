package designpattern.demo.singleton;

/**
 * ��̬�ڲ��൥��ģʽ
 * �ŵ㣺�̰߳�ȫ�������أ����ܸ�
 * ȱ�㣺
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
