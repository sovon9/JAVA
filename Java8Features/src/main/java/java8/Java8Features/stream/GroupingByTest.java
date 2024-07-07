package java8.Java8Features.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

class EmployeeVO
{
	private int eid;
	private String name;
	private String dept;
	public EmployeeVO() {
		super();
	}
	public EmployeeVO(int eid, String name, String dept) {
		super();
		this.eid = eid;
		this.name = name;
		this.dept = dept;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", dept=" + dept + "]";
	}
}

public class GroupingByTest {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(new Employee(100, "sovon", "DEV"), new Employee(202, "sougata", "DEV"),
				new Employee(105, "ABC", "QA"),new Employee(110, "CDE", "QA"));
		// groupingBy takes Function so takes input and returns a output based on which grouping will be done
	    Map<String, List<Employee>> groupBy = employees.stream().collect(Collectors.groupingBy((e)->e.getDept()));
		// grouping values as a List
		Set<Entry<String, List<Employee>>> entrySet = groupBy.entrySet();
		for(Entry<String, List<Employee>> entry : entrySet)
		{
			System.out.println(" groupBy Dept: "+entry.getKey()+" Employee details : "+entry.getValue());
		}
		/****************************************************************/
		// now instead of collecting/grouping same dept employees in a List , we will collect in a Set
		System.out.println("***************  grouping values as a Set  *******************");
		Map<String, Set<Employee>> groupByinaSet = employees.stream().collect(Collectors
				.groupingBy((e)->e.getDept(), Collectors.toSet()));
		
		for(Entry<String, Set<Employee>> entry : groupByinaSet.entrySet())
		{
			System.out.println(" groupBy Dept: "+entry.getKey()+" Employee details in SET : "+entry.getValue());
		}
		
	}

}
