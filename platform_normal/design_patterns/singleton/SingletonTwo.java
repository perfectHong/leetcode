package design_patterns.singleton;
/**
 * @author mengfh
 *
 * @version 2020-6-14ÏÂÎç1:08:32
 *
 * @description ¶öºº
 */
public class SingletonTwo {

	public static void main(String[] args) {
		System.out.println(SingletonTwo.getSingleton() == SingletonTwo.getSingleton());
	}
	
	private static SingletonTwo singleton = new SingletonTwo();
	
	private SingletonTwo(){}
	
	public static SingletonTwo getSingleton(){
		return singleton;
	}

}
