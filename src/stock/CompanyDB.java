package stock;

/**
 * 
 */
import java.util.*;

/**
 * 
 * @author Hyun
 *
 */
public class CompanyDB {

	private HashMap<String, Company> Database;

	/**
	 * 
	 */
	public CompanyDB() {
		Database = new HashMap<String, Company>();
	}

	/**
	 * 
	 * @param key
	 * @param com
	 */
	public void AddData(String key, Company com) {
		Database.put(key, com);
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public Company GetData(String key) {
		return Database.get(key);
	}

	/**
	 * 
	 * @return
	 */
	public int getSize() {

		return Database.size();
	}

}
