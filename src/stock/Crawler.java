package stock;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.IOException;
import java.lang.*;

public class Crawler {
	
	
	private String path = "http://finance.daum.net/item/quote.daum?code=0";
	
	
	public Crawler() {
		
	}
	
	public boolean checkUrl(String path) {
		
		return true;
	}
	
	public void readUrl(String path) throws IOException {
		
		Document document = Jsoup.connect(path).get();
		Elements element = document.select("table.gHead tr");
		String str = element.text();
		System.out.println(path)
		;
		System.out.println(str);
		
		
		
	}
	
	public String getUrl(String code) {
		path = path + code;
		return path;
	}
	

}
