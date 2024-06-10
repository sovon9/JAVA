package JavaTest;

@FunctionalInterface
public interface Printer
{
	public String print();
	default void hello()
	{
		
	}
}
