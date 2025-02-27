package designpattern.demo.factory;

public class ShapeFactory {
	public Shape getShape(String shapeType) {
		if (null == shapeType) {
			return null;
		}
		else if("Rectangle".equalsIgnoreCase(shapeType)){
			return new Rectangle();
		}
		else if("Square".equalsIgnoreCase(shapeType)) {
			return new Square();
		}
		else if("Circle".equalsIgnoreCase(shapeType)) {
			return new Circle();
		}
		return null;
	}
}
