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

	public CompanyDB() {
		Database = new HashMap<String, Company>();
	}

	public void AddData(String key, Company com) {
		Database.put(key, com);
	}

	public Company GetData(String key) {
		return Database.get(key);
	}

	public int getSize() {

		return Database.size();
	}

}
