package designpattern.demo.builder;

public class BuilderPatternDemo {
	public static void main(String[] args) {
		MealBuilder mealBuilder = new MealBuilder();
		Meal vegSet = mealBuilder.prepareVegMeal();
		System.out.println("Veg Set:");
		vegSet.showItems();
		System.out.println("Veg Set price:"+vegSet.getCost());
		
		Meal nonMeal = mealBuilder.prepareNonVegMeal();
		System.out.println("Veg Set:");
		nonMeal.showItems();
		System.out.println("Veg Set price:"+nonMeal.getCost());
	}
}
