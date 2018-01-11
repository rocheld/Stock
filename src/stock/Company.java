package stock;

import java.io.IOException;

/**
 * 
 * @author Hyun
 *
 */
public class Company implements iCrawler{
	
	private Crawler spider;
	
	private String name;
	private String code;
	private int current_price;
	
	/**
	 * 
	 * @param name
	 * @param code
	 */
	public Company(String name, String code) {
		spider = new Crawler();
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
	
	/**
	 * 
	 * @param opt
	 * @throws IOException
	 */
	public void printInfo(boolean opt) throws IOException {
		String url = spider.getUrl(code);
		spider.readUrl(url, opt);
	}
	
	@Override
	public void update() {
		spider.update();
	}
	
}
