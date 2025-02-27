package designpattern.demo.builder;

public class Coke extends ColdDrink {

	@Override
	public String name() {
		return "Coke cola";
	}

	@Override
	public float price() {
		return 15.0f;
	}

}
