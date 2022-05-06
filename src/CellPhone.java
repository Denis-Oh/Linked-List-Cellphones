import java.util.Scanner;
/**
 * Implementation of CellPhone class
 * @author Denis Oh
 */
public class CellPhone {
	
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	//Constructors
	/**
	 * Parameterized constructor for CellPhone Object
	 * @param serialNum Unique serial number
	 * @param brand Brand String
	 * @param year Year of release
	 * @param price Retail Price
	 */
	public CellPhone(long serialNum, String brand, int year, double price) {
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}	
	/**
	 * Default constructor for CellPhone Object
	 */
	public CellPhone() {
		this.serialNum = 000000;
		this.brand = "DefaultBrand";
		this.year = 0000;
		this.price = 0.0;
	}
	/**
	 * Copy constructor for CellPhone Object
	 * @param c Original CellPhone Object to be made a deep copy of
	 * @param serialNum New serial number of new CellPhone Object
	 */
	public CellPhone(CellPhone c, long serialNum) { 
		this.serialNum = serialNum;
		this.brand = c.brand;
		this.year = c.year;
		this.price = c.price;
	}
	
	//clone
	/**
	 * Clone method which prompts user for new serial number
	 * @return Copy of CellPhone object with new serial number
	 */
	public CellPhone clone() {
		Scanner KeyIn = new Scanner(System.in);
		
		System.out.print("New Serial Number: "); //obtain new serial number for new CellPhone Object
		long newSerialNum = KeyIn.nextLong();
		KeyIn.close();
		
		return new CellPhone(this, newSerialNum);
	}
	
	//toString
	/**
	 * toString method for CellPhone Object
	 * @return string with information about CellPhone Object
	 */
	public String toString() {
		return "["+this.serialNum+": "+this.brand+" "+this.price+"$ "+this.year+"]";
	}
	
	//equals
	/**
	 * equals method which checks for equality of two CellPhone objects
	 * @return boolean: true if all attributes are same except for serial number
	 */
	public boolean equals(Object o) {
		if(o==null)
			return false;
		CellPhone temp = (CellPhone)o;
		if(this.getClass()!=temp.getClass())
			return false;
		else
			return (this.brand==temp.brand && this.year==temp.year && this.price==temp.price);
	}
	
	//accessors and mutators
	/**
	 * Accessor for serialNum attribute
	 * @return serialNum
	 */
	public long getSerialNum() {
		return serialNum;
	}
	/**
	 * Mutator for serialNum attribute
	 * @param serialNum
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	/**
	 * Accessor for brand attribute
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * Mutator for brand attribute
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * Accessor for year attribute
	 * @return year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * Mutator for year attribute
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * Accessor for price attribute
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Mutator for price attribute
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
}
