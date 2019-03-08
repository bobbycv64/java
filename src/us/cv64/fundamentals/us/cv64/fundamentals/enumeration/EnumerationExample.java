// https://www.youtube.com/watch?v=ThN8IXr0n_k
package us.cv64.fundamentals.enumeration;

/**
 * don't need to put public static final because declared in interface *
 */
interface InterfaceExample {
	String APPLE = "Apple";
	String SAMSUNG = "Samsung";
	String GOOGLE = "Google";
}

// can be defined inside or outside the Class
// Java enumerations are more powerful than other languages because you can define attributes and methods
// behind the scene, 
// class EnumExample { 
// 		static final EnumExample APPLE = new EnumExample(); 
// 		static final EnumExample SAMPLE = new EnumExample(); 
// 		static final EnumExample GOOGLE = new EnumExample(); 
// }
enum EnumExample {
	APPLE(100), SAMSUNG, GOOGLE(90);
	
	int price;
	
	EnumExample(int price) {
		System.out.println("EnumExample Constructor " + price);
		this.price = price;
	}
	
	EnumExample() {
		System.out.println("EnumExample Constructor");
		price = 80;
	}
	
	public int getPrice() {
		return price;
	}
}

public class EnumerationExample {

	public static void main(String[] args) {
			
		System.out.println("InterfaceExample:    " + InterfaceExample.APPLE);
		System.out.println("EnumExample:         " + EnumExample.APPLE);
		System.out.println("EnumExample.ordinal: " + EnumExample.APPLE.ordinal());
		
		EnumExample enumExample = EnumExample.APPLE;
		EnumExample[] enumExamples = EnumExample.values();
		
		switch (enumExample) {
		
			case APPLE:
				System.out.println("switch Apple");
				break;
			case SAMSUNG:
				System.out.println("switch Samsung");
				break;
			case GOOGLE:
				System.out.println("switch Google");
				break;
		}
	}
}
