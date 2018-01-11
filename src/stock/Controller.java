/*
 * Name: Hyun Woo Choi
 * Date: Jan 4 2018
 */

package stock;

import java.util.*;
import java.io.*;

public class Controller {

	private static final String FILENAME = "/Users/Hyun/Documents/workspace/Stock/bin/newFile.txt";
	private static File file;

	private static Scanner sc;
	private static Scanner sc2;

	public static CompanyDB db = new CompanyDB();

	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
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
		currTime();
		
		printMenu();
		while (menu() != -1) {
			printMenu();
		}

		System.out.println("Exit program!");
	}

	/**
	 * 
	 * @return
	 */
	public static int menu() {

		int option;
		String name = "";
		Company com;

		sc2 = new Scanner(System.in);

		if (sc2.hasNextInt()) {
			option = sc2.nextInt();
			System.out.print("");
		}

		else
			return -1;

		if (option == 0) {
			return -1;
		}

		else {

			switch (option) {

			// search company
			case 1:

				Scanner sc3 = new Scanner(System.in);
				System.out.println("Enter company Name: " + '\n');

				if (sc3.hasNextLine()) 
					name = sc3.nextLine();

				com = db.GetData(name);

				if (com == null)
					System.out.println("Search Failed. Try again.");

				else {

					try {
						addFavor(com);
						com.printInfo(false);

					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				break;

			case 2:

				System.out.println("Favorite");
				readFavor();
				break;
			}

		}
		return 1;
	}

	public static void addFavor(Company com) throws IOException {

		try {

			File file = new File(FILENAME);
			if (!file.exists())
				file.createNewFile();

			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				
				String str = sc.nextLine();

				if (str.equals(com.getName())) {
					sc.close();
					return;
				}

			}
			sc.close();

			FileWriter fw = new FileWriter(file, true);
			fw.write(com.getName());
			fw.write('\n');
			fw.flush();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	public static void readFavor() {

		try {
			File file = new File(FILENAME);

			if (!file.exists()) {
				file.createNewFile();
			}

			Scanner sc = new Scanner(file);
			
			while (sc.hasNextLine()) {
				String name = sc.nextLine();
				Company com = db.GetData(name);
				System.out.println(com.getName() + " #" + com.getCode());
				com.printInfo(true);
				System.out.println(" ");
				
				com.update();
			}
			sc.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	public static void printMenu() {

		System.out.println("===========================================================");
		System.out.println("|                                                         |");
		System.out.println("|            KOSPI KOSDAQ Market Search Program           |");
		System.out.println("|                                                         |");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|  (0) Quit (1) Search Company  (2) Farvorite             |");
		System.out.println("===========================================================");
	}
	
	public static void currTime() {
		Date date = new Date();
		date.getTime();
		
		System.out.println(date);
		
	}
}
