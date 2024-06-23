package java8.FunctionalInterface;

import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {

		// Predicate takes a input and gives boolean output
		// predicate actually holds a condition, rather than typing conditions everywhere we can use standard condition as a predicate
		Predicate<String> startsWith = (s)->s.startsWith("s");
		
		System.out.println(startsWith.test("sovon"));
		
		Predicate<String> endsWith = (s)->s.endsWith("n");
		
		/*
		 * predicate has few default methods like and, not, or....
		 */
		// like if we want to combine two conditions 
		Predicate<String> startsAndEndsWith = startsWith.and(endsWith);
		System.out.println(startsAndEndsWith.test("sovon"));
		Predicate<String> startsOrEndsWith = startsWith.or(endsWith);
		System.out.println("Starts And Ends with :"+startsAndEndsWith.test("sougata"));
		System.out.println("Starts Or Ends with :"+startsOrEndsWith.test("sougata"));
		
		// negate condition is something like !condition(not condition)
		Predicate<String> negate = startsWith.negate();
		System.out.println("just puts a not condition for startswith even though startswith gives negate makes it :"+negate.test("sovon"));
	}

}
