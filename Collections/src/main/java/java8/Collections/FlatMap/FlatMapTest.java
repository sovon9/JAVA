package java8.Collections.FlatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Customer {
	private String name;
	private List<String> phNumbers;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, List<String> phNumbers) {
		super();
		this.name = name;
		this.phNumbers = phNumbers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhNumbers() {
		return phNumbers;
	}

	public void setPhNumbers(List<String> phNumbers) {
		this.phNumbers = phNumbers;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", phNumbers=" + phNumbers + "]";
	}

}

public class FlatMapTest {

	public static void main(String[] args) {

		System.out.println("test");
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("sovon", Arrays.asList("9000000000", "8000000000")));
		customers.add(new Customer("sougata", Arrays.asList("9999999999", "8111111111")));
		customers.add(new Customer("SS", Arrays.asList("7000000000", "7000000001")));
		customers.add(new Customer("nawaz", Arrays.asList("6000000000", "5000000000")));

		// get the customer names who's names starts with 's'
		/*
		 * c->c.getName() ==> one to one relationship
		 */
		customers.stream().map(c -> c.getName()).filter((n) -> {
			return n.startsWith("s") || n.startsWith("S");
		}).forEach(System.out::println);
		// return list of phone numbers
		/*
		 * c->c.getPhNumbers() ==> one to many
		 */
		List<List<String>> phList = customers.stream().map(c -> c.getPhNumbers()).collect(Collectors.toList());
		System.out.println("As a List of List: " + phList);

		// not I want only a list of phone numbers not a List<List<>>
		List<String> phnumbers = customers.stream().flatMap(c -> c.getPhNumbers().stream())
				.collect(Collectors.toList());
		System.out.println("As a single List: " + phnumbers);

	}

}
