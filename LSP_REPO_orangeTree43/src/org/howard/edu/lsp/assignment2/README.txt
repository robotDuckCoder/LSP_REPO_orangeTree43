Assumptions:
	product.csv has no commas within datapoints, there is a header line of the csv,
	the data in product.csv matches the following format: <ProductID>,<ProductName>,<ProductPrice>,<ProductCatagory>
	
Design Notes:
	A class was used to store and modify the product data where it could be justified (i.e. discounting items is a method in the
	class, but making the name uppercase is not). productList is a static variable because it is used across all of main and it
	would be inefficient to keep passing the data back and forth.

How To Run:
	Make sure the Product class is in the same directory when trying to run ETLPipline.java (or just run the package as a whole), 
	as well as having a file in the path "./data/product.csv" or else an error will be returned.

Testing Strategy:
	1) Compared the golden test cases with results from program
	2) Created own test csv and manually transformed the data before comparing it with results from program

Internet Sources Used (also the use and adaptation of their knowledge)
	1) https://www.geeksforgeeks.org/java/different-ways-for-integer-to-string-conversions-in-java/ - used to find the way to convert ints to strings, adapted in the extract function in ETLPipeline.java and the returnCSV method of Product.java
 	2) https://stackoverflow.com/questions/7552660/convert-float-to-string-and-string-to-float-in-java - used to find the way to convert floats to strings and backwards, adapted in the extract function in ETLPipeline.java and the returnCSV method of Product.java
 	3) https://www.baeldung.com/java-csv-file-array - used to find out how to do input in Java with a csv (buffered file streams), used in extract function of ETLPipeline.java
 	4) https://www.w3schools.com/java/java_try_catch.asp - guidance on how to catch exceptions (try/catch statements), adapted for error handling in the extract and loadData functions of ETLPipeline.java
 	5) https://www.w3schools.com/java/java_arraylist.asp - for arraylist documentation, adapted for all of ETLPipeline.java (when interacting with productList)
 	6) https://stackoverflow.com/questions/437382/how-do-relative-file-paths-work-in-eclipse - to find the relative path of data/product.csv, adapted for the variables outputFile and inputFile in ETLPipeline.java
	7) https://www.ascii-code.com/ - ascii table reference, adapted for the makeUppercase function in ETLPipeline.java
	8) https://stackoverflow.com/questions/23257369/exporting-to-a-csv-file-in-java - writing to a csv (a more general file would have worked too), adapted for the loadData function in ETLPipeline.java
	9) https://www.w3schools.com/java/java_files_create.asp - creating new files, adapted for the loadData function of ETLPipeline.java to create transformed_products.csv