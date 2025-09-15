package org.howard.edu.lsp.assignment3;

import java.util.List;

/*
 * Interface to implement a ProductTransformer
 */
interface TransformsProducts{
	int numberOfRowsTransformed = 0;
	public List<Product> transformProductList(List<Product> products);
	public int getNumberOfRowsTransformed();
}
