package java8.Java8Features.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Employee
{
	private int eid;
	private String name;
	private String dept;
	public Employee() {
		super();
	}
	public Employee(int eid, String name, String dept) {
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

public class CollectionMap {

	public static void main(String[] args) {

		List<EmployeeVO> employees = Arrays.asList(new EmployeeVO(100, "sovon", "DEV"), new EmployeeVO(202, "sougata", "DEV"),
				new EmployeeVO(105, "ABC", "QA"),new EmployeeVO(110, "CDE", "QA"));
		// toMap takes keymapper and valueMapper , both are Function so takes input and returns a output
		Map<Integer, EmployeeVO> map = employees.stream().collect(Collectors.toMap((e)->{return e.getEid();}, (e)->{ return e; }));
		// upper version of toMap returns HashMap
		Set<Entry<Integer, EmployeeVO>> entrySet = map.entrySet();
		for(Entry<Integer, EmployeeVO> entry : entrySet)
		{
			System.out.println(" Eid: "+entry.getKey()+" Employee details : "+entry.getValue());
		}
		/****************************************************************/
		// Now if there is a change of having eid duplicate in the list then we can handle it using another overloaded toMap
		System.out.println("*********  duplicate keys handling  ******");
		List<EmployeeVO> empwithdup = Arrays.asList(new EmployeeVO(100, "sovon", "DEV"), new EmployeeVO(202, "sougata", "DEV"),
				new EmployeeVO(105, "ABC", "QA"),new EmployeeVO(110, "CDE", "QA"),new EmployeeVO(202, "xxx", "DEV"));
		Map<Integer, EmployeeVO> dupComparedMap = empwithdup.stream().collect(
				Collectors.toMap((e)->e.getEid(), (e)->e, (e1, e2)-> 
		{
			return e1.getName().length()>e2.getName().length()?e1:e2;
		}));
		
		for(Entry<Integer, EmployeeVO> entry : dupComparedMap.entrySet())
		{
			System.out.println(" Eid: "+entry.getKey()+" Employee details : "+entry.getValue());
		} // no duplicates
		/****************************************************************/
		// normally toMap returns HashMap, if we need TreeMap then we have to pass a TreeMap
		System.out.println("*********  TreeMap  ********");
		TreeMap<Integer, EmployeeVO> treeMap = employees.stream().collect(Collectors.toMap((e)->e.getEid(), e->e,
			(e1, e2)-> 
			{
				return e1.getName().length()>e2.getName().length()?e1:e2;
			},
			TreeMap::new));
		
		for(Entry<Integer, EmployeeVO> entry : treeMap.entrySet())
		{
			System.out.println(" Eid: "+entry.getKey()+" Employee details : "+entry.getValue());
		}
		// sort treemap in desending order
		System.out.println("*********  TreeMap in Desending order ********");
		TreeMap<Integer, EmployeeVO> treeMapADesc = employees.stream().collect(Collectors.toMap((e)->e.getEid(), e->e, (e1, e2)-> 
		{
			return e1.getName().length()>e2.getName().length()?e1:e2;
		},()->new TreeMap<>((eid1,eid2)->{
			return Integer.compare(eid2,eid1);
		})));
		
		for(Entry<Integer, EmployeeVO> entry : treeMapADesc.entrySet())
		{
			System.out.println(" Eid: "+entry.getKey()+" Employee details : "+entry.getValue());
		}
		
	}

}
