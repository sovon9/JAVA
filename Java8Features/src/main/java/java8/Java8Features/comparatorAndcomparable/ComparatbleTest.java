package java8.Java8Features.comparatorAndcomparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Student implements Comparable<Student>
{
	private String name;
	private Integer rollno;
	public Student() {
		super();
	}
	public Student(String name, Integer rollno) {
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
	
	public int compareTo(Student s)
	{
//		return s.getName().compareTo(name); //desc
		return name.compareTo(s.getName()); //asc
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollno=" + rollno + "]";
	}

}


public class ComparatbleTest {

	public static void main(String[] args) {

		// we are trying to add duplicates of student sovon but set doesn't allows it
		Set<Student> students = new TreeSet<>(Arrays.asList(new Student("sovon", 9),new Student("sovon", 10),new Student("guddu", 12),new Student("sougata", 6)));
		System.out.println("sorted by name : ");
		System.out.println(students);
		
		List<Student> list = Arrays.asList(new Student("sovon", 9),new Student("guddu", 12),new Student("sougata", 6));
		System.out.println("list doesn't sort the values "+list);
		// trying to do sort without passing a comparator cause class implements Comparatble interface
		Collections.sort(list);
		System.out.println("sorted list bsed on the sort defination class itself is providing through compareTo method: "+list);
	}

}
