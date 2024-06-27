package java8.Collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Employee
{
	private String name;
	private int empID;
	
	public Employee(String name, int empID) {
		super();
		this.name = name;
		this.empID = empID;
	}
	public Employee() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(empID, name);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Employee other = (Employee) obj;
//		return empID == other.empID && Objects.equals(name, other.name);
//	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empID=" + empID + "]";
	}
}

public class HashSetTest {

	public static void main(String[] args) {

		Set<Employee> employees =  new HashSet<>();
		employees.add(new Employee("sovon", 1234));
		employees.add(new Employee("nawaz", 4567));
		employees.add(new Employee("dubey", 4568));
		employees.add(new Employee("nawaz", 4569));
		
		System.out.println(employees);

		employees.clear(); // clears the set
		Employee employee = new Employee("sovon", 1234);
		employees.add(employee);
		System.out.println("hashcode before modification: "+employee.hashCode());
		employees.add(new Employee("nawaz", 4567));
		employees.add(new Employee("dubey", 4568));
		
		//add a duplicate element in HashSet, the old value would be overwritten
		employee.setEmpID(1222);
		System.out.println("hashcode after modification: "+employee.hashCode());
		employees.add(employee);
		
		// empID value overriden
		System.out.println(employees);
		
		// duplicate values without hashcode method impl in Employee class
		Set<Employee> emps=new HashSet<>();
		Employee emp1 = new Employee("sovon", 1234);
		Employee emp2 = new Employee("nawaz", 4567);
		Employee emp3 = new Employee("sovon", 1234);
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		//though emp1 and emp3 has same data but they have different hashcode
		System.out.println("hashcode for emp1 "+emp1.hashCode()+" hashcode for emp3 "+emp3.hashCode());
		// since they have different hashcode both emp1 and emp2 are allowed though they are duplicates
		System.out.println(emps);
		
		// now if we override hashcode and equals method then duplicates will not be added
		
		
	}

}
