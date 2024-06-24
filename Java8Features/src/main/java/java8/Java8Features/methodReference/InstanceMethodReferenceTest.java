package java8.Java8Features.methodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Utilities1
{
	public boolean isEven(int n)
	{
		return n%2==0;
	}
}

public class InstanceMethodReferenceTest {

	public static void main(String[] args) {

		Predicate<Integer> predicate = (n)->{
			return n%2==0;
		};
		System.out.println(predicate.test(2));
		// now in place of lambda we can use method reference if an existing method is already providing this
		// functionality
		Predicate<Integer> methodref = new Utilities1()::isEven; // object :: instance method
		System.out.println(methodref.test(4));
		
		List<String> fruits = Arrays.asList("apple", "orange", "banana", "grape", "cherry");
        //Sort the list of strings using an instance method reference
		// sort accepts comparator functional interface type
        fruits.sort(String::compareTo);

        //Print the sorted list of strings
        fruits.forEach(System.out::println);
		
		
	}

}
