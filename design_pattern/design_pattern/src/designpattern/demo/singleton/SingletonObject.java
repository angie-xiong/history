package designpattern.demo.singleton;

/**
 * ����ģʽ�Ļ���������ʽ��������ģʽ�����������˼·��������
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
