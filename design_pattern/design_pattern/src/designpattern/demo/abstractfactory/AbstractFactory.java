package designpattern.demo.abstractfactory;

import designpattern.demo.abstractfactory.color.Color;
import designpattern.demo.abstractfactory.shape.Shape;

public abstract class AbstractFactory {
	public abstract Color getColor(String color);
	public abstract Shape getShape(String shapeType);
}
