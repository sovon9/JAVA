package java8.FunctionalInterface;

import java.util.function.Function;
import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {

		Supplier<String> supplier = ()->{
			return "sovon";
		};
		System.out.println(supplier.get());
		
		Function<String, String> capitalize = (s)->s.toUpperCase();
		
		System.out.println(capitalize.apply(supplier.get()));
		
	}

}
