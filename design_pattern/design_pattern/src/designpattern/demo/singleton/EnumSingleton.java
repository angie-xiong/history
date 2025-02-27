package designpattern.demo.singleton;

public enum EnumSingleton {
	INSTANCE;
	
	public void showMessage() {
		System.out.println("I am EnumSingleton.java!");
	}
}
