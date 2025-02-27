package designpattern.demo.abstractfactory;

import designpattern.demo.abstractfactory.color.ColorFactory;
import designpattern.demo.abstractfactory.shape.ShapeFactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if("shape".equalsIgnoreCase(choice)) {
			return new ShapeFactory();
		}
		else if("color".equalsIgnoreCase(choice)) {
			return new ColorFactory();
		}
		return null;
	}
}
