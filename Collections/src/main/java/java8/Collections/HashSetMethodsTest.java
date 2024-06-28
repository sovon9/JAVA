package java8.Collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class EmployeeVO
{
	private String name;
	private int empID;
	
	public EmployeeVO(String name, int empID) {
		super();
		this.name = name;
		this.empID = empID;
	}
	public EmployeeVO() {
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
	
	@Override
	public int hashCode() {
		return Objects.hash(empID, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeVO other = (EmployeeVO) obj;
		return empID == other.empID && Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empID=" + empID + "]";
	}
}

public class HashSetMethodsTest {

	public static void main(String[] args) {

		Set<String> names =  new HashSet<>();
		names.add("sovon");
		names.add("nawaz");
		names.add("dubey");
		
		System.out.println(names); // [sovon, dubey, nawaz]
		names.remove("dubey");
		System.out.println(names); // [sovon, nawaz]
		
		Set<EmployeeVO> employees =  new HashSet<>();
		employees.add(new EmployeeVO("sovon", 1234));
		employees.add(new EmployeeVO("nawaz", 4567));
		employees.add(new EmployeeVO("dubey", 4568));
		employees.add(new EmployeeVO("sougata", 4569));
		
		employees.clear();
		System.out.println(employees);
		
		
		
		
	}

}
