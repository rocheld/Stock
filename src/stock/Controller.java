/*
 * Name: Hyun Woo Choi
 * Date: Jan 4 2018
 */

package stock;

import java.util.*;
import java.io.*;

public class Controller {
	
	public static File file;
	public static CompanyDB db = new CompanyDB();
	
	private static Scanner sc;
	private static Scanner sc2;
	
	private static Crawler spider;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Company com;
		String CompanyName;
		String CompanyCode;
		
		// Open Company List file
		file = new File("ComList.tsv");
		sc = new Scanner(file);
		
		// Skip the first blank line
		sc.nextLine();
		// Build database with Company List file
		while (sc.hasNextLine()) {
			
			CompanyName = sc.next();
			CompanyCode = sc.next();
			
			com = new Company(CompanyName, CompanyCode);
			db.AddData(CompanyName, com);
			
			sc.nextLine();
		}
		sc.close();
		
		printMenu();
		
		while(menu() != -1) {
			printMenu();
			//menu();
			
			System.out.println("");
		}
		
		
		System.out.println("Exit program!");
		
	}
	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	public static int menu() {
		
		int option;
		String name = "";
		Company com;
		
		sc2 = new Scanner(System.in);
		option = Integer.parseInt(sc2.nextLine());
		System.out.print("");
		
		if(option == 0) {
			return -1;
		}
		else {
			
			switch(option) {
			
			// search company
			case 1:
				
				System.out.println("Enter company Name: " + '\n');
				
				if(sc2.hasNextLine()) {
					name = sc2.nextLine();
				}
				
				com = db.GetData(name);
				
				spider = new Crawler();
				String url = spider.getUrl(com.getCode());
				
				try {
					spider.readUrl(url);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(com == null) {
					System.out.println("Search Failed. Try again.");
				}
				
				else {
					com.printInfo();
				}
				break;
			}
			
		}
			return 1;
	}
	
	public static void printMenu() {
		
		System.out.println("===========================================================");
		System.out.println("|                                                         |");
		System.out.println("|            KOSPI KOSDAQ Market Search Program           |");
		System.out.println("|                                                         |");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|  (0) Quit (1) Search Company  (2) (3)                          |");
		System.out.println("===========================================================");
	}

}
