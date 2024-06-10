package inheritance;

interface VehicleWithDeafult1
{
	public void mileadge();
	default void display() {
		System.out.println("displaying from VehicleWithDeafult1 deafult");
	}
}

interface OilWithDeafult1
{
	public void price();
	default void display() {
		System.out.println("displaying from OilWithDeafult1 deafult");
	}
}

class Car1 implements VehicleWithDeafult1 , OilWithDeafult1
{

	@Override
	public void price()
	{
		System.out.println("80Rs/ltr");
	}

	@Override
	public void mileadge()
	{
		System.out.println("20kmpl");
	}

	@Override
	public void display()
	{
		//VehicleWithDeafult1.super.display(); // to display VehicleWithDeafult display method
		System.out.println("displaying from car");
	}
	
}

abstract class Cde1 implements VehicleWithDeafult, OilWithDeafult
{

	@Override
	public void display()
	{
		VehicleWithDeafult.super.display();
	}
	
}


public class MultipleInheritanceWithDeafultSameName
{
	public static void main(String args[])
	{
		VehicleWithDeafult1 car = new Car1();
		car.mileadge();
		/*
		 * can't access price cause bus here we declared is of type VehicleWithDeafult, and in vehicle
		 * this price method is not there
		 */
		//car.price();
		car.display();
		OilWithDeafult1 oil = new Car1();
		//oil.mileadge();
		oil.price();
		oil.display();
		Car bus2 = new Car();
		bus2.mileadge();
		bus2.price();
	}
}
