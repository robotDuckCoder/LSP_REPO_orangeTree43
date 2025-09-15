package org.howard.edu.lsp.assignment3;

/*
 * Class for transforming single Product objects
 */

public class ProductTransform{
	
	/*
	 *Sets priceRange based on price and defined constant values
	 */
	public void calculatePriceRange(Product currentProduct) {
		float low = 10;
		float medium = 100;
		float high = 500;
		
		if(currentProduct.getPrice() < low)
			currentProduct.setPriceRange("Low");
		else if (currentProduct.getPrice() < medium)
			currentProduct.setPriceRange("Medium");
		else if (currentProduct.getPrice() < high)
			currentProduct.setPriceRange("High");
		else
			currentProduct.setPriceRange("Premium");
	}
	
	/*
	 * @param sets the product's name to only capital letter characters
	 */
	public void makeNameUppercase(Product currentProduct) {
		String newName = makeUppercase(currentProduct.getName());
		currentProduct.setName(newName);
	}
	
	/*
	 * @param discounts electronics over 500 dollars and sets their category to premium electronics
	 * if they still have a price over 500 dollars
	 */
	public void discountElectronic(Product currentProduct) {
		if(currentProduct.getCategory().equals("Electronics")) {
			discount(currentProduct, 10);
			if(currentProduct.getPrice() > 500)
				currentProduct.setCategory("Premium Electronics");
		}
	}
	
	/*
	 * @return - returns the lowercaseString entirely in capital letters
	*/
	private String makeUppercase(String lowercaseString) {
		String returnString = "";
		for(int i = 0; i < lowercaseString.length(); i++) {
			char c = lowercaseString.charAt(i);
			// changes the ascii value of the character to make it capital letters
			// 32 is the difference between 'a' and 'A'
			if(c >='a' && c <= 'z')
				returnString += (char)(c - 32);
			else
				returnString += c;
		}
		return returnString;
	}
	
	/*
	 * @param percentage - discounts the price by the percentage given
	 * so 10 == 10%
	 */
	private void discount(Product currentProduct, float percentage) {
		percentage = 1 - (percentage / 100);
		currentProduct.setPrice(round(currentProduct.getPrice() * percentage));
	}
	
	/*
	 * @return returns the @param decimal rounded to the hundredth's place
	 */
	private float round(float decimal) {
		int temp = (int)(decimal * 1000);
		// rounds the thousands place digit from the original number
		if(temp % 10 >= 5) {
			temp += 10;
		}
		temp /= 10;
		return (float)temp / 100.0f;
	}
}
