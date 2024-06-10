package anonymousInnerClass;

public class AnonymousInnerClassTest
{

	public static void main(String[] args)
	{
		Animal animal = new Animal();
		// provides a general implementation what animal by default providing
		animal.sound();
		// now if we want a special implementation 
		// like a normal subclass do providing special implementation
		// but make it a one time use class
		Animal animalSpecial=new Animal() {
			@Override
			public void sound()
			{
				System.out.println("Roarrrrrrr");
			}
		};
		animalSpecial.sound();
		// here we are basically creating anonymous subclass of Animal class
		
		//another way of creating anonymous class for interfaces
		Runnable runnable = new Runnable() {
			
			@Override
			public void run()
			{
				System.out.println("anonymous runnable");
			}
		};
		runnable.run();
		
		/*
		 * anonymous classes are not related to functional interface so 
		 * for anonymous class interface can have more that one abstract method
		 * It's just like some subclass extending Headphone class
		 */
		System.out.println(new Headphone() {
			
			@Override
			public String type()
			{
				return "wireless";
			}
			
			@Override
			public boolean isANC()
			{
				return true;
			}
		}.type());
		
	}

}
