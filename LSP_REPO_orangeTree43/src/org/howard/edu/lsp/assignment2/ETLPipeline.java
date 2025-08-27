package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ETLPipeline {
	
	static int numberOfRowsRead = 0;
	static int numberOfRowsTransformed = 0;
	static String header = "";
	static List<Product> productList = new ArrayList<Product>();
	
	// constant for use in delimiting the input csv
	public static final String COMMA_DELIMITER = ",";
	
	/*
	 * @return - returns the lowercaseString entirely in uppercase
	*/
	public static String makeUppercase(String lowercaseString) {
		String returnString = "";
		for(int i = 0; i < lowercaseString.length(); i++) {
			char c = lowercaseString.charAt(i);
			// changes the ascii value of the character to make it uppercase
			// 32 is the difference between 'a' and 'A'
			if(c >='a' && c <= 'z')
				returnString += (char)(c - 32);
			else
				returnString += c;
		}
		return returnString;
	}
	
	/* Extract from file:
	 * Requires that the data has a header and is formatted like this: 
	 * ProductId,Name,Price,Category
	*/
	public static void extract(File inputFile){
		try(BufferedReader br = new BufferedReader(new FileReader(inputFile))){
			header = br.readLine();
			String line;
			numberOfRowsRead++;
			// read the lines in product.csv and add them to the productList
			while((line = br.readLine()) != null) {
				numberOfRowsRead++;
				String[] values = line.split(COMMA_DELIMITER);
				int tempProductId = Integer.parseInt(values[0]);
				float tempPrice = Float.parseFloat(values[2]);
				Product tempProduct = new Product(tempProductId, values[1], tempPrice, values[3]);
				productList.add(tempProduct);
			}
		}
		catch(FileNotFoundException se) {
			System.out.println("Error: File Not Found in location \"./data/product.csv\"");
			System.exit(0);
		}
		// catch generic exceptions separately for a more applicable error message
		catch(Exception e) {
			System.out.println("Error Accessing products.csv");
			System.exit(0);
		}
	}
	
	/*
	 * Modify the data from the file
	 */
	public static void transformData() {
		header += ",PriceRange"; // because we are creating a new column in the data
		numberOfRowsTransformed++;
		for(int i = 0; i < productList.size(); i++) {
			numberOfRowsTransformed++;
			Product workingProduct = productList.get(i);
			String newName = makeUppercase(workingProduct.getName());
			workingProduct.setName(newName);
			
			if(workingProduct.getCategory().equals("Electronics")) {
				workingProduct.discount(10);
				if(workingProduct.getPrice() > 500)
					workingProduct.setCategory("Premium Electronics");
			}
			
			workingProduct.calculatePriceRange();
		}
	}
	
	/*
	 * Load the transformed data to a specified output file
	 */
	public static void loadData(File outputFile) {
		try {
			outputFile.createNewFile();
			FileWriter fileWriter = new FileWriter(outputFile);
			// reattach header line to data
			fileWriter.append(header);
			fileWriter.append('\n');
			for(int i = 0; i < productList.size(); i++) {
				fileWriter.append(productList.get(i).returnCSV());
				fileWriter.append('\n');
			}
			fileWriter.close();
		}
		// catch any exceptions that are thrown when we create/open our output file
		catch(Exception e) {
			System.out.println("Error With Output File");
			System.exit(0);
		}
	}
	
	
	public static void main(String[] args) {
		File inputFile = new File("./data/product.csv");
		File outputFile = new File("./data/transformed_products.csv");
		extract(inputFile);
		transformData();
		loadData(outputFile);
		// Run summary
		System.out.println("Run Summary: " + numberOfRowsRead + " rows read, "
		+ numberOfRowsTransformed + " rows transformed, "
		+ (numberOfRowsRead - numberOfRowsTransformed) + " rows skipped, "
		+ "and the output path was: " + outputFile.getAbsolutePath());
	}
}