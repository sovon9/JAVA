package java8.Java8Features.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReduceTest {

	public static void main(String[] args) {

		List<Integer> dataList = Arrays.asList(5,1,3);
		//1st version
		Integer addedVal = dataList.stream()
		.reduce((d1, d2)->{
			return d1+d2;
		}).get();
		System.out.println("Added value using reduce(Bioperator) : "+addedVal);
		//2nd version
		Integer addedValue = dataList.stream()
		.reduce(0, (d1,d2)->{
			return d1+d2;
		});
		System.out.println("Added value using identifier , reduce(Bioperator) : "+addedValue);
		// 3rd version
		/*
		 * 1st identity element should be of type what ultimately we want from this reduction
		 * 2nd BiFunction first parameter will be of identity type, second parameter will be of type data 
		 * we are playing with here it's Integer
		 * 3rd BinaryOperator which we know takes and outputs same type data , so it will be ultimate return type
		 * that is identity type = ArrayList<Integer>
		 */
		ArrayList<Integer> collectData = dataList.stream()
				.reduce(
					new	ArrayList<Integer>(), 
				(d1,d2)->{ System.out.println("d1= "+d1+" d2= "+d2); d1.add(d2); return d1;},
				(d3,d4)->{ System.out.println("d3= "+d3+" d4= "+d4); d3.addAll(d4); return d3;}
				);
		System.out.println(collectData);
		
		/**************************************************************/
		List<String> list = Arrays.asList("A","B","C","D");
		
		list.stream().map(s->s.concat(s)).collect(()->new ArrayList<String>(), (s1,s2)-> System.out.println("s1 "+s1+" s2 "+s2), 
				(s3,s4)->System.out.println("s3 "+s3+" s4 "+s4));
		
		ArrayList<String> collect = list.stream().map(s->s.concat(s)).collect(()->new ArrayList<String>(), (s1,s2)-> s1.add(s2), (s3,s4)->s3.addAll(s4));
		System.out.println("collected value: "+collect);
		
	}

}
