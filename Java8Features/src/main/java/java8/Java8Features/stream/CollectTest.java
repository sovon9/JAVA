package java8.Java8Features.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectTest {

	public static void main(String[] args) {

		List<Integer> dataList = Arrays.asList(5,1,3);
		
		ArrayList<Integer> collectData = dataList.stream()
				.collect(
				()->new ArrayList<Integer>(), 
				(d1,d2)->{ System.out.println("d1= "+d1+" d2= "+d2); d1.add(d2);},
				(d3,d4)->{ System.out.println("d3= "+d3+" d4= "+d4); d3.addAll(d4); }
				);
		System.out.println(collectData);
		
		/**************************************************************/
		List<String> list = Arrays.asList("A","B","C","D");
		
		list.stream().map(s->s.concat(s)).collect(()->new ArrayList<String>(), (s1,s2)-> System.out.println("s1 "+s1+" s2 "+s2), 
				(s3,s4)->System.out.println("s3 "+s3+" s4 "+s4));
		
		ArrayList<String> collect = list.stream().map(s->s.concat(s)).collect(()->new ArrayList<String>(), (s1,s2)-> s1.add(s2), (s3,s4)->s3.addAll(s4));
		System.out.println("collected value: "+collect);
		
		String stringData = list.stream().collect(String::new, (s1,s2)->{
			   s1.concat(s2);},
				(s3,s4)->{
					s3.concat(s4);
				});
		System.out.println("stringData isBlank= "+stringData.isBlank());
		
		String reduce = list.stream().reduce(new String(),
				(s1,s2)->s1.concat(s2),
				(s3,s4)->s3.concat(s4)
				);
		System.out.println("reduce= "+reduce);
		
	}

}
