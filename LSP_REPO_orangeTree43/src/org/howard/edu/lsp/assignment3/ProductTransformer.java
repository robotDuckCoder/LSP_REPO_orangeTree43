package org.howard.edu.lsp.assignment3;

import java.util.List;

public class ProductTransformer implements TransformsProducts {
	int numberOfRowsTransformed = 0;
	
	public int getNumberOfRowsTransformed() {
		return numberOfRowsTransformed;
	}
	
	/*
	 * @return the modified data from the product list
	 */
	public List<Product> transformProductList(List<Product> productList) {
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
