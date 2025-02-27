package designpattern.demo.prototype;

public class PrototypePatternDemo {
	public static void main(String[] args) {
		ShapeCache.loadShapes();
		
		Shape cloneShape = ShapeCache.getShape("1");
		System.out.println("cloneShape="+cloneShape.getType());
		
		cloneShape = ShapeCache.getShape("2");
		System.out.println("cloneShape="+cloneShape.getType());
		
		cloneShape = ShapeCache.getShape("3");
		System.out.println("cloneShape="+cloneShape.getType());
	}
}
