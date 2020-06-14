package design_patterns.singleton;
/**
 * @author mengfh
 *
 * @version 2020-6-14ÏÂÎç1:02:30
 *
 * @description ÀÁºº
 */
public class SingletonOne {

	public static void main(String[] args) {
		System.out.println(SingletonOne.getSingleton() == SingletonOne.getSingleton());
	}
	
	private static SingletonOne singleton = null;
	
	private SingletonOne(){}
	
	public static SingletonOne getSingleton(){
		
		if(singleton == null)
			singleton = new SingletonOne();
		return singleton;
	}

}
