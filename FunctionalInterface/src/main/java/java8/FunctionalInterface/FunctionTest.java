package java8.FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

class Student
{
	private int id;
	private String name;
	public Student() {
		super();
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}


public class FunctionTest {

	public static void main(String[] args) {

		// Function takes a input a gives an output
		Function<String, String> capitalize = (s)->s.toUpperCase();
		System.out.println(capitalize.apply("sovon"));
		
		// takes Student type data and returns String
		Function<Student, String> findname = (s)->{
			String name="";
			if(s.getName().startsWith("s"))
			{
				name = s.getName();
			}
			return name;
		};
		
		List<Student> studentList = Arrays.asList(new Student(0, "sovon"), new Student(1, "sougata"), new Student(2, "nawaz"));
		for(Student s : studentList)
		{
			System.out.println(findname.apply(s));
		}
		
		// andThen
		/* Returns a composed function that first applies first function to
		 * its input, and then applies the {@code after} function to the result
		 */
		for(Student s : studentList)
		{
			// first findname will be applied and then capitalize
			System.out.println(findname.andThen(capitalize).apply(s));
		}
		
	}

}
