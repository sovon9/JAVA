package java8.Java8Features.methodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Utilities
{
	public static boolean isEven(int n)
	{
		return n%2==0;
	}
}

public class StaticMethodReferenceTest {

	public static void main(String[] args) {

		Predicate<Integer> predicate = (n)->{
			return n%2==0;
		};
		System.out.println(predicate.test(2));
		// now in place of lambda we can use method reference if an existing method is already providing this
		// functionality
		Predicate<Integer> methodref = Utilities::isEven; // Classname :: static method
		System.out.println(methodref.test(4));
		
		List<String> list = Arrays.asList("1", "2","3");
		// since pasrseInt is static mehtod in integer class referencing it using class name
		// map takes function
		List<Integer> listOfIntegers = list.stream().map(Integer::parseInt).collect(Collectors.toList());
		System.out.println(listOfIntegers);
		
		
		
	}

}
