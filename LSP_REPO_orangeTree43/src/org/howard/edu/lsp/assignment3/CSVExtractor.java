package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/*
 * class used to extract data from a csv into Product objects
 */
public class CSVExtractor {
	// constant for use in delimiting the input csv
	public static final String COMMA_DELIMITER = ",";
		
	//header is the top line of the csv
	String header;
	int numberOfRowsRead = 0;
	
	
	public String getHeader() {
		return header;
	}
	public int getNumberOfRowsRead() {
		return numberOfRowsRead;
	}
	
	/* 
	 * @params extract data from file given by inputFile
	 * Data must be in the correct form:
	 * ProductId,Name,Price,Category
	 * With a header line above the data
	 * 
	 * @return returns a list of products
	*/
	public List<Product> extract(File inputFile){
		List<Product> productList = new ArrayList<Product>();
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
		// catch if input file is non-existent
		catch(FileNotFoundException se) {
			System.out.println("Error: File Not Found in location \"" + inputFile.toString() + "\"");
			System.exit(0);
		}
		// catch generic exceptions separately for a more applicable error message
		catch(Exception e) {
			System.out.println("Error Accessing products.csv");
			System.exit(0);
		}
		return productList;
	}
}
