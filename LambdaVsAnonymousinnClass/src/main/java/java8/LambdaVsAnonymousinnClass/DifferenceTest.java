package java8.LambdaVsAnonymousinnClass;

interface Animal
{
	public String name = "cat";
	public void sound();
}


public class DifferenceTest {

	public String name = "Dog";
	
	public Animal animalSound()
	{
		return ()->{
			System.out.println("bhow bhow "+this.name);
		};
		
	}
	
	public Animal animalSound1()
	{
		return new Animal() {

			//String name = "SS";
			/*
			 * here this represents the subclass it's creating so this.name pointing to this subclass's name variable
			 * since subclass inheriting parent properties so name pointing to Animal name value
			 */
			@Override
			public void sound() {
				System.out.println("meow meow "+this.name); 
				// since this pointing anonymous/subclass obj so uncommenting line 26 will print out meow meow SS
			}
			
		};
		
	}
	
	public static void main(String[] args) {

		DifferenceTest test = new DifferenceTest();
		/*
		 * this keyword to represent the current class in lambda expression 
		 */
		Animal animalSound = test.animalSound();
		animalSound.sound();
		
		/*
		 * while in the case of an anonymous class, this keyword can represent that particular anonymous class
		 */
		Animal animalSound1 = test.animalSound1();
		animalSound1.sound();
		
	}

}
