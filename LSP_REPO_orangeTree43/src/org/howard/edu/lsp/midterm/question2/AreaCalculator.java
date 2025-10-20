package org.howard.edu.lsp.midterm.question2;

public class AreaCalculator {
	// Circle area
	public static double area(double radius) {
		if(radius <= 0) {
			throw new IllegalArgumentException("Radius cannot be 0 or less 0");
		}
		return radius * radius * Math.PI;
	}

	// Rectangle area
	public static double area(double width, double height) {
		if(width <= 0 || height <= 0) {
			throw new IllegalArgumentException("Neither width nor height can be 0 or less");
		}
		return width * height;
	}

	// Triangle (base & height) area
	public static double area(int base, int height) {
		if(base <= 0 || height <= 0) {
			throw new IllegalArgumentException("Neither base nor height can be 0 or less");
		}
		return (base * height) / 2;
	}

	// Square (side length) area
	public static double area(int side) {
		if(side <= 0) {
			throw new IllegalArgumentException("Side cannot be 0 or less");
		}
		return side * side;
	}

}
