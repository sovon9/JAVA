package JavaTest2.singleton;

public class TestSingleton {

	public static void main(String[] args) {

		DBAccess access = DBAccess.getInstance();
		System.out.println(access.hashCode());
		DBAccess access1 = DBAccess.getInstance();
		System.out.println(access1.hashCode());
		DBAccess access2 = DBAccess.getInstance();
		System.out.println(access2.hashCode());
		System.out.println(new DBAccess().hashCode());
		System.out.println(new DBAccess().hashCode());
	}

}
