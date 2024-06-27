package java8.Collections.hashcodeEquals;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class User
{
	private int id;
	private String name;
	public User() {
		super();
	}
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}

/**
 * with custom hashcode implementation
 */
class UserWithHashCode
{
	private int id;
	private String name;
	public UserWithHashCode() {
		super();
	}
	public UserWithHashCode(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int hashCode()
	{
		return name.hashCode();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}

/**
 * with custom hashcode and equals implementation
 */
class UserWithHashCodeAndEquals
{
	private int id;
	private String name;
	public UserWithHashCodeAndEquals() {
		super();
	}
	public UserWithHashCodeAndEquals(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserWithHashCodeAndEquals other = (UserWithHashCodeAndEquals) obj;
		return id == other.id && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}

public class HashCodeAndEquals {

	public static void main(String[] args) {
		
		Set<User> users = new HashSet<>();
		
		User user1 = new User(123, "sovon");
		User user2 = new User(123, "sovon");
		/*
		 * since both user1 and user2 are different objects they point to different memory location
		 * even though they have same values, so we have different hashcode values
		 */
		System.out.println("hashcode of user1: "+user1.hashCode()+" user2: "+user2.hashCode());
		// equals is false since both object references are different
		System.out.println("object references are different : "+user1.equals(user2));
		
		users.add(user1);
		users.add(user2);
		// since both hashcode and equals saying user1 and user2 are different so hashset adding them both
		System.out.println("duplicates without custom HC and Equals :( "+users);
		System.out.println();
		/***********************************	with custom hashcode	***********************************/
		UserWithHashCode userHC1 = new UserWithHashCode(123, "sovon");
		UserWithHashCode userHC2 = new UserWithHashCode(123, "sovon");
		/*
		 * though both user1 and userHC2 are different objects and they point to different memory location
		 * custom hasdcode checks for name hashgcode with is same for both so returning same hashcode
		 */
		System.out.println("hashcode of userHC1: "+userHC1.hashCode()+" userHC2: "+userHC2.hashCode());
		// equals is false since both object references are different
		System.out.println("object references are different : "+userHC1.equals(userHC2));
		
		Set<UserWithHashCode> usersHC = new HashSet<>();
		usersHC.add(userHC1);
		usersHC.add(userHC2);
		/*
		 *  though hashcode says both are same but still userHC2 get's added to the set as hashtable checks if both
		 *  are equal using equals method and that still says both are different
		 */
		System.out.println("still duplicates with custom HC :( "+usersHC);
		System.out.println();
		/*************************************	with custom hascode and equals	*********************************/
		UserWithHashCodeAndEquals userHCE1 = new UserWithHashCodeAndEquals(123, "sovon");
		UserWithHashCodeAndEquals userHCE2 = new UserWithHashCodeAndEquals(123, "sovon");
		System.out.println("hashcode of userHCE1: "+userHCE1.hashCode()+" userHCE2: "+userHCE2.hashCode());
		
		// equals is true since custom equals method compares each member of the class is same or not
		System.out.println("same with custom equals method : "+userHCE1.equals(userHCE2));
		
		Set<UserWithHashCodeAndEquals> usersHCE = new HashSet<>();
		usersHCE.add(userHCE1);
		usersHCE.add(userHCE2);
		System.out.println("no duplicates with custom HC and Equals :) "+usersHCE);

	}

}
