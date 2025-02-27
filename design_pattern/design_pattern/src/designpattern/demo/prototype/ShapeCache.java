package designpattern.demo.prototype;

import java.util.HashMap;
import java.util.Map;

public class ShapeCache {
	private static Map<String,Shape> shapes = new HashMap<String,Shape>();
	
	public static Shape getShape(String shapeId) {
		return shapes.get(shapeId);
	}
	
	public static void loadShapes() {
		Rectangle rec = new Rectangle();
		rec.setId("1");
		rec.setType("Rectangle");
		shapes.put(rec.getId(), rec);
		
		Square square = new Square();
		square.setId("2");
		square.setType("Square");
		shapes.put(square.getId(), square);
		
		Circle circle = new Circle();
		circle.setId("3");
		circle.setType("Circle");
		shapes.put(circle.getId(), circle);
	}
}
