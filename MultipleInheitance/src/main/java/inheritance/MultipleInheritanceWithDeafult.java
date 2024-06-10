package inheritance;

interface VehicleWithDeafult
{
	public void mileadge();
	default void display() {
		System.out.println("displaying from VehicleWithDeafult deafult");
	}
}

interface OilWithDeafult
{
	public void price();
	default void display1() {
		System.out.println("displaying from OilWithDeafult deafult");
	}
}

class Car implements VehicleWithDeafult , OilWithDeafult
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
	
}

abstract class Cde implements VehicleWithDeafult, OilWithDeafult
{

	@Override
	public void display()
	{
		VehicleWithDeafult.super.display();
	}
	
}


public class MultipleInheritanceWithDeafult
{
	public static void main(String args[])
	{
		VehicleWithDeafult car = new Car();
		car.mileadge();
		/*
		 * can't access price cause bus here we declared is of type VehicleWithDeafult, and in vehicle
		 * this price method is not there
		 */
		//car.price();
		car.display();
		OilWithDeafult oil = new Car();
		//oil.mileadge();
		oil.price();
		oil.display1();
		Car bus2 = new Car();
		bus2.mileadge();
		bus2.price();
	}
}
