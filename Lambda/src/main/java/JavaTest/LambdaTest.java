package JavaTest;

public class LambdaTest
{
	public void printData(Printer printer)
	{
		System.out.println(printer.print());
	}
	
	public static void main(String args[])
	{
		LambdaTest test = new LambdaTest();
		test.printData(()->{
			return "print data from Printer";
		});
	}
}
