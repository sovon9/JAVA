package java8.Java8Features.comparatorAndcomparable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Student1
{
	private String name;
	private Integer rollno;
	public Student1() {
		super();
	}
	public Student1(String name, Integer rollno) {
		super();
		this.name = name;
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRollno() {
		return rollno;
	}
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollno=" + rollno + "]";
	}
}

class NameComparator implements Comparator<Student1>
{
	public int compare(Student1 s1, Student1 s2)
	{
		return s1.getName().compareTo(s2.getName());
	}
}

public class ComparatorTest {

	public static void main(String[] args) {

		// we are trying to add duplicates of student sovon but set doesn't allows it
		List<Student1> studentList = Arrays.asList(new Student1("sovon", 9),new Student1("sovon", 10),
				new Student1("guddu", 12),new Student1("sougata", 6));
		
		Set<Student1> students = new TreeSet<>(new NameComparator()); // passing comparator object
		students.addAll(studentList);
		System.out.println("sorted by name with no duplicates: ");
		System.out.println(students);
//		Comparator<Student1> cc = (s1,s2)->
//		{
//			return s2.getName().compareTo(s1.getName());
//		};
		Set<Student1> studentsDesc = new TreeSet<>((s1,s2)->
		{
			return s2.getName().compareTo(s1.getName());
		}); // since comparator is functional interface
		studentsDesc.addAll(studentList);
		System.out.println("sorted by name in decending with no duplicates: ");
		System.out.println(studentsDesc);
		
	}

}
