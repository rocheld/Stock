package stock;

import org.jsoup.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.*;
import java.util.Iterator;

public class Crawler implements iCrawler {
	
	private int element_size = 10;
	private String path = "http://finance.daum.net/item/quote.daum?code=";
	
	/**
	 * 
	 */
	public Crawler() {
	}
	
	/**
	 * 
	 * @param path
	 * @param opt
	 * @throws IOException
	 */
	public void readUrl(String path, boolean opt) throws IOException {
		
		if(opt) {
			element_size = 3;
		}
		
		Document document = Jsoup.connect(path).get();
		Elements elements = document.select("table.gHead tr");
		
		for(int i = 0; i < element_size; i++) {
			Element e = elements.get(i);
			System.out.println(e.text());
		}
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	public String getUrl(String code) {
		
		while(code.length() < 6)
			code = "0" + code;
		
		String url = path + code;
		return url;
	}
	
	@Override
	public void update() {
		
		System.out.println("callback");
		
		try {
			readUrl(path,true);
		} catch (IOException e) {
			
		}
	}

}
