package org.howard.edu.lsp.assignment3;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

/*
 * Loads the data from the given header and productList into the outputFile when loadData() is called
 */

public class CSVLoader {
	// header is the top line of csv
	String header;
	List<Product> productList;
	
	CSVLoader(String m_header, List<Product> m_productList){
		header = m_header;
		productList = m_productList;
	}
	
	public void setHeader(String m_header) {
		header = m_header;
	}
	public void setProductList(List<Product> m_productList) {
		productList = m_productList;
	}
	
	/*
	 * Load the transformed data to a specified output file
	 */
	public void loadData(File outputFile) {
		try {
			outputFile.createNewFile();
			FileWriter fileWriter = new FileWriter(outputFile);
			// re-attach header line to data
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
}
