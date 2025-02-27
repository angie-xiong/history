package designpattern.demo.abstractfactory;

public class AbstractFactoryPatternDemo {

	public static void main(String[] args) {
		AbstractFactory abstractFactory = FactoryProducer.getFactory("shape");
		abstractFactory.getShape("circle").draw();
		abstractFactory = FactoryProducer.getFactory("color");
		abstractFactory.getColor("Green").fill();
	}

}
