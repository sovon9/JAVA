package JavaTest2.singleton;

public class DBAccess {

	private static final DBAccess instance = new DBAccess();
	
	public static DBAccess getInstance()
	{
		return instance;
	}
	
}
