package java8.Java8Features.constructorReference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student
{
	private String name;
	public Student() {
		super();
	}
	public Student(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	
}

public class ConstructorreferenceTest {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("sovon", "sougata");
		List<Student> students = list.stream().map(Student::new).collect(Collectors.toList());
		System.out.println(students);
	}

}
