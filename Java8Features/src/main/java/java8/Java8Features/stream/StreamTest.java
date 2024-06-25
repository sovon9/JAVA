package java8.Java8Features.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student
{
	private String name;
	private String stream;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String stream) {
		super();
		this.name = name;
		this.stream = stream;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", stream=" + stream + "]";
	}
	
}

public class StreamTest {

	public static void main(String[] args) {
		
		/***********************   filter    ********************/
		List<String> list = Arrays.asList("sovon", "sougata", "guddu");
		// passing condition as parameter in filter
		List<String> list2 = list.stream().filter(s->s.startsWith("s")).collect(Collectors.toList());
		
		System.out.println("constins names with starts with word s "+list2);
		
		/***********************     map     ****************************/
		List<Student> students = Arrays.asList(
	            new Student("John Doe", "Engineering"),
	            new Student("Jane Smith", "Marketing"),
	            new Student("Jack Johnson", "Sales"),
	            new Student("John Doe", "Marketing")
	        );
		
		 // Use map to transform the list of students to a list of their names
		List<String> studentNames = students.stream().map(s->s.getName()).collect(Collectors.toList());
		// Or using method reference
		List<String> studentNames1 = students.stream().map(Student::getName).collect(Collectors.toList());
		
		System.out.println(studentNames);
		System.out.println(studentNames1);
		
		/***********************    distinct    **********************/
		// now the above lists having some duplicate names, to remove it we can use distinct
		List<String> list3 = students.stream().map(s->s.getName()).distinct().collect(Collectors.toList());
		System.out.println("student names without duplicates : "+list3);
		
		/***********************      sorted        **********************/
		// now we can sort the list
		List<String> list4 = students.stream().map(s->s.getName()).distinct().sorted().collect(Collectors.toList());
		System.out.println("student names sorted asc: "+list4);
		
		list4=students.stream().map(s->s.getName()).distinct().sorted((s1,s2)->s2.compareTo(s1))
				.collect(Collectors.toList());
		System.out.println("student names sorted desc "
				+ ": "+list4);
		/***********************    limit      **************************/
		// only give me first name sorted started with word s
		list4=students.stream().map(s->s.getName()).distinct().sorted((s1,s2)->s2.compareTo(s1)/*takes a comparator as input*/)
				.limit(1)
				.collect(Collectors.toList());
		System.out.println(" First student names sorted desc "
				+ ": "+list4);
		
		/***********************   Stream.Iterate     ********************/
		List<Integer> collect = Stream.iterate(1, n->n+1/*takes a function*/)
				.limit(10).collect(Collectors.toList());
		System.out.println("values from 1 will increment 10 times : "+collect);
		
		/***********************    max/min      **************************/
		
		Integer max = Stream.iterate(1, n->n+1/*takes a function*/)
				.limit(10)
				.max((n1,n2)->n1-n2) // returns optional value
				.get();
		System.out.println("the last element as per comparator logic : "+max);
		
		Integer max1 = Stream.iterate(1, n->n+1/*takes a function*/)
				.limit(10)
				.max((n1,n2)->n2-n1) // returns optional value
				.get();
		System.out.println("the last element as per comparator logic : "+max1);// output: 1 as max as sorting in decensing order and last element is 1
		
		/***********************    count    **************************/
		
		Long count = Stream.iterate(2, n->n/2/*takes a function*/)
				.limit(10)
				.peek(s->System.out.println(s))
				.distinct()
				.count(); // returns a long value
		System.out.println("the count of this stream is : "+count);

	}

}
