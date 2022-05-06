import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 * Implementation of the CellListUtilization Class
 * @author Denis Oh
 */
public class CellListUtilization {

	/**
	 * Main Method: Creates CellPhone Objects with attributes found Cell_Info.txt file. Stores all CellPhone Objects in a CellList Object.
	 * @param args
	 */
	public static void main(String[] args) {

		CellList list1 = new CellList();
		CellList list2 = new CellList();
			
		//reading from file
		File file = new File("Cell_Info.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			Scanner input = new Scanner(fis);
			
			long serialNumber;
			String brand;
			int year;
			double price;
			
			while(input.hasNextLine()) {
				serialNumber = input.nextLong();
				brand = input.next();
				price = input.nextDouble();
				year = input.nextInt();
				CellPhone cell = new CellPhone(serialNumber, brand, year, price);
				if(!(list1.contains(cell.getSerialNum()))) {
					list1.addToStart(cell);				
				}
			}
			input.close();
			fis.close();
		} catch(FileNotFoundException e) {
			System.err.println("File Not Found...");
		} catch(IOException e) {
			System.err.println("IOException...");
		} catch(Exception e) {
			System.err.println("An Error Occured...");
		}
		
		//display content
		list1.showContents();
		
		//prompt user to search for some serialNumbers
		System.out.print("\nEnter a serial number to search for: ");
		Scanner keyIn = new Scanner(System.in);
		long serial = keyIn.nextLong();
		try {
			System.out.println(list1.find(serial).getObject());
		} catch(NullPointerException e) {
			System.err.println("Phone Not Found...");
		}
		
		//Demonstrating Constructors and Methods
		System.out.println("\n------------------------------------------"
				+ "\nDemonstration of Constructors and Methods:"
				+ "\n------------------------------------------");
		CellPhone c1 = new CellPhone(11111, "SONY", 1999, 209.12);
		CellPhone c2 = new CellPhone(c1, 22222);
		CellPhone c3 = new CellPhone(33333, "APPLE", 2008, 509.35);
		CellPhone c4 = new CellPhone(44444, "GOOGLE", 2022, 403.63);
		
		System.out.println("\nCellPhone Clone method:");
		CellPhone c5 = c3.clone();
		System.out.println(c5);
		keyIn.close();
		
		System.out.println("\nAdd 3 CellPhone Objects:");
		list2.addToStart(c1);
		list2.addToStart(c2);
		list2.addToStart(c3);
		list2.showContents();
		
		System.out.println("\nReplace at index 1:");
		list2.replaceAtIndex(c4, 1);
		list2.showContents();
		
		System.out.println("\nDelete at index 1:");
		list2.deleteFromIndex(1);
		list2.showContents();
		
		System.out.println("\nInsert at index 2:");
		list2.insertAtIndex(c4, 2);
		list2.showContents();
		
		System.out.println("\nDelete from start:");
		list2.deleteFromStart();
		list2.showContents();
		
		System.out.println("\nContains serial number 11111:");
		System.out.println(list2.contains(11111));
		
		System.out.println("\nContains serial number 01234:");
		System.out.println(list2.contains(01234));
		
		System.out.println("\nCellList Copy Constructor:");
		CellList list3 = new CellList(list2);
		list3.showContents();
		
	}
	
	

}
