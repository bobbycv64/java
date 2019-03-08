// https://www.youtube.com/watch?v=yY6XMBUCNYE
// https://www.youtube.com/watch?v=E2tYw6pEW6I
package us.cv64.fundamentals.abstrct;

// abstract prevents instantiation of a Class
abstract class Animal {
	public abstract void eat(); // define an abstract method

	public void walk() {
	}
}

// class Dog has the implementation of the method
class Dog extends Animal {
	public void bark() {
	}

	public void eat() {
		System.out.println("Dog eatting");
	}
}

// class Cat has the implementation of the method
class Cat extends Animal {
	public void meow() {
	}

	public void eat() {
		System.out.println("Cat eatting");
	}
}

class Printer {
	// abstract class Number is the super class to all numbers, e.g. Integer and
	// Double
	public void show(Number number) {
		System.out.println(number);
	}
}

public class AbstractExample {

	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal cat = new Cat();
		dog.eat();
		cat.eat();
		Printer printer = new Printer();
		printer.show(5); // call with an Integer
		printer.show(5.5); // call with a Double
	}
}
