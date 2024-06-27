package java8Interface.Java_Interface.staticMethod;

interface Vehicle
{
	public void type();
	static void display()
	{
		System.out.println("static method in interface can't be overriden");
	}
}

class Car implements Vehicle
{

	// have to provide implementation for abstract method
	@Override
	public void type() {
		System.out.println("4 seater automatic");
	}
	
	static void display()
	{
		System.out.println("this static method isn't overriden as Car can't see vehicle display mehtod, it's a fresh method");
	}
	
}

public class InterfaceStaticMethod {

	public static void main(String[] args) {
		Car car = new Car();
		car.type();
		car.display();
		// The only way to access Vehicle Interface display method is by InterfaceName.static method name
		Vehicle.display();
	}

}
