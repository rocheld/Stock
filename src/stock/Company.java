package stock;

/**
 * 
 * @author Hyun
 *
 */
public class Company {
	
	private String name;
	private String code;
	private int current_price;
	
	/**
	 * 
	 * @param name
	 * @param code
	 */
	public Company(String name, String code) {
		this.name = name;
		this.code = code;
		this.current_price = -1;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPrice() {
		return current_price;
	}
	
	/**
	 * 
	 * @param price
	 */
	public void setPrice(int price) {
		this.current_price = price;
	}
	
	public void printInfo() {
		System.out.println("Comapny INFO: ");
		System.out.println("Company: " + this.name + " Code#: " + this.code + '\n');
	}
	
}
