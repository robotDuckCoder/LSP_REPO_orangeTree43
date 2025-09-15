package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.List;

public class ETLPipeline {
	
	public static void main(String[] args) {
		//set initial variables
		File inputFile = new File("./LSP_REPO_orangeTree43/data/product.csv");
		File outputFile = new File("./LSP_REPO_orangeTree43/data/transformed_products.csv");
		
		//extract data
		CSVExtractor extractor = new CSVExtractor();
		List<Product> productList = extractor.extract(inputFile);
		String header = extractor.getHeader() + ",PriceRange";
		
		//transform data
		TransformsProducts transformer = new ProductTransformer();
		List<Product> transformedList = transformer.transformProductList(productList);
		
		//load data
		CSVLoader loader = new CSVLoader(header, transformedList);
		loader.loadData(outputFile);
		
		// Run summary
		System.out.println("Run Summary: " + extractor.getNumberOfRowsRead() + " rows read, "
		+ transformer.getNumberOfRowsTransformed() + " rows transformed, "
		+ (extractor.getNumberOfRowsRead() - transformer.getNumberOfRowsTransformed()) + " rows skipped, "
		+ "and the output path was: " + outputFile.getAbsolutePath());
	}
}