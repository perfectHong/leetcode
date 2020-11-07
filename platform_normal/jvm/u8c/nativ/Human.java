package jvm.u8c.nativ;

public class Human {

	public static String name = "human";
	
	static{
		System.out.println(" Human is loaded");
	}
}

class Woman extends Human{

	//public static final String femaleName = "female";
	
	public static String femaleName = "female";
	
	static {
		System.out.println(" Woman is loaded");
	}
}
