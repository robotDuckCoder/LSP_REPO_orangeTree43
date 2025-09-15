package org.howard.edu.lsp.assignment3;

/*
 * Class for storing information about Products in a store
 * 
 */
public class Product {
	protected int productId;
	protected String name;
	protected float price;
	protected String category;
	protected String priceRange;
	
	Product(){
		productId = -1;
		name = "";
		price = -1;
		category = "";
		priceRange = "";
	}
	
	Product(int m_id, String m_name, float m_price, String m_category){
		productId = m_id;
		name = m_name;
		price = round(m_price);
		category = m_category;
		priceRange = "";
	}
	
	public int getId() {
		return productId;
	}
	public void setId(int m_id) {
		productId = m_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String m_name) {
		name = m_name;
	}
	public float getPrice() {
		return price;
	}
	
	/*
	 * @param m_price - rounds the price to the nearest hundredth before storing it
	 */
	public void setPrice(float m_price) {
		price = round(m_price);
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String m_category) {
		category = m_category;
	}
	public String getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(String m_priceRange) {
		priceRange = m_priceRange;
	}
	
	/*
	 * @return - returns a toString() in a CSV format
	 * ProductId,Name,Price,Category,PriceRange
	 */
	public String returnCSV() {
		String returnString = "";
		returnString += Integer.toString(productId) + ','
				+ name + ',' 
				+ Float.toString(price) + ','
				+ category;
		if(priceRange != "")
			returnString += ',' + priceRange;
		return returnString;
	}
	
	/*
	 * @return - the original float rounded to the hundredth's place 
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
