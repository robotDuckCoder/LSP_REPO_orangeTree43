package org.howard.edu.lsp.assignment3;

import java.util.List;

public class ProductTransformer {
	int numberOfRowsTransformed = 0;
	
	public int getNumberOfRowsTransformed() {
		return numberOfRowsTransformed;
	}
	
	/*
	 * @return the modified data from the product list
	 */
	public List<Product> transformData(List<Product> productList) {
		 // because we are creating a new column in the data
		numberOfRowsTransformed++;
		ProductTransform pt = new ProductTransform();
		for(int i = 0; i < productList.size(); i++) {
			numberOfRowsTransformed++;
			Product workingProduct = productList.get(i);
			pt.makeNameUppercase(workingProduct);
			pt.calculatePriceRange(workingProduct);
			pt.discountElectronic(workingProduct);
		}
		return productList;
	}
}
