package java8.Collections.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {

	private static final String INSPSTATUS = "INSPSTATUS";
	private static final String HKSTATUS = "HKSTATUS";
	private static final String FDSTATUS = "FDSTATUS";
	private static final String ROOM = "ROOM";

	public Map<String, String> getRoomStatus(int roomnum)
	{
		Map<String, String> roomstatusMap = new HashMap<>();
		
		/*
		 * get room status for room number from database
		 */
		// room number , FD status, Hk status, Insp status
		List<String> list1 = Arrays.asList("202","VAC","VC","PASS");
		List<String> list2 = Arrays.asList("205","OOO","VD","AN");
		
		roomstatusMap.put(ROOM, list1.get(0));
		roomstatusMap.put(FDSTATUS, list1.get(1));
		roomstatusMap.put(HKSTATUS, list1.get(2));
		roomstatusMap.put(INSPSTATUS, list1.get(3));
		
		return roomstatusMap;
	}
	
	public static void main(String[] args) {

		/********************* scenario where hashmap used in project *********************/
		HashMapTest mapTest = new HashMapTest();
		Map<String, String> roomStatus = mapTest.getRoomStatus(202);
		// get(key) to get the value associated with the key
		System.out.println(roomStatus.get(ROOM));
		System.out.println(roomStatus.get(FDSTATUS));
		System.out.println(roomStatus.get(HKSTATUS));
		System.out.println(roomStatus.get(INSPSTATUS));
		
		/************************************************/
		Map<String, Integer> data = new HashMap<>();
		data.put("SS", null); // null is allowed as a value
		System.out.println("null is allowed as a value: "+data);
		data.put("SS", 26);
		System.out.println("insert the duplicate key, it will replace the element of the corresponding key="+data);
		// allows us to store the null elements as well, but there should be only one null key
		data.put(null, null);
		System.out.println(data);
		System.out.println("data contains key: "+data.containsKey("SS"));
		System.out.println("data contains value: "+data.containsValue(26));
		/***********************	Iterate through map using Keyset	*************************/
		System.out.println("\n Iterate through map using keyset	");
		Set<String> keys = roomStatus.keySet(); //Returns a Set view of the keys contained in this map
		for(String k : keys)
		{
			System.out.println("Status Type: "+k+" Status: "+roomStatus.get(k));
		}
		/***********************	Iterate through map using entrySet	*************************/
		System.out.println("\n Iterate through map using entrySet	");
		Set<Entry<String, String>> allMappings = roomStatus.entrySet();
		for(Entry<String, String> set : allMappings)
		{
			System.out.println("Status Type: "+set.getKey()+" Status: "+set.getValue());
		}
		/***********************	remove an element	*************************/
		roomStatus.remove(ROOM);
		System.out.println("roomnum get deleted: "+roomStatus);
	}

}
