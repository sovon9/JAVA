package inheritance;

interface Vehicle
{
	public void mileadge();
}

interface Oil
{
	public void price();
}

class Bus implements Vehicle , Oil
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

abstract class Abc implements Vehicle, Oil
{
	
}


public class MultipleInheritance
{
	public static void main(String args[])
	{
		Vehicle bus = new Bus();
		bus.mileadge();
		/*
		 * can't access price cause bus here we declared is of type Vehicle, and in vehicle
		 * this price method is not there
		 */
		//bus.price();
		System.out.println(bus instanceof Vehicle);
		System.out.println(bus instanceof Bus);
		System.out.println(bus instanceof Oil);
		Oil oil = new Bus();
		//oil.mileadge();
		oil.price();
		System.out.println(oil instanceof Vehicle);
		System.out.println(oil instanceof Bus);
		System.out.println(oil instanceof Oil);
		Bus bus2 = new Bus();
		bus2.mileadge();
		bus2.price();
		System.out.println(bus2 instanceof Vehicle);
		System.out.println(bus2 instanceof Bus);
		System.out.println(bus2 instanceof Oil);
	}
}
