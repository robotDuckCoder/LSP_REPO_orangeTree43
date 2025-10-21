package org.howard.edu.lsp.midterm.question2;

public class Main {

	public static void main(String[] args) {
		System.out.println("Circle radius 3.0 → area = " + AreaCalculator.area(3.0));
		System.out.println("Rectangle 5.0 x 2.0 → area = " + AreaCalculator.area(5.0, 2.0));
		System.out.println("Triangle base 10, height 6 → area = " + AreaCalculator.area(10, 6));
		System.out.println("Square side 4 → area = " + AreaCalculator.area(4));
		
		try {
			AreaCalculator.area(-1.0);
		}
		catch(IllegalArgumentException e){
			System.out.println("Error, " + e.toString());
		}
	}
	
	/*
	 * Using methods with different names would be the better choice in this circumstance, although the current implementation does use overloading.
	 * You can tell that it uses overloading because there are 4 functions of the same name which are called depending on the parameters that are given to each function.
	 * This is because this way of overloading does not allow the user to calculate the area of a triangle with decimal side lengths. 
	 * It is also because unless you know the AreaCalculator class, it is not easy to predict what you are finding the area of in this case.
	 * The code would be much more understandable and usable with methods named areaRectangle(), etc. for all of the different shapes.
	 */

}
