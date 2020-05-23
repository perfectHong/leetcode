package design_patterns.strategy;

import java.util.Comparator;

/**
 * @author mengfh
 *
 * @version 2020-5-21����7:05:03
 *
 * @description �������
 */
public class StrategyTest {

	private IStrategy is;

	private StrategyTest(IStrategy is) {
		this.is = is;
	}
	
	public static void main(String[] args) {
		
		new StrategyTest(new StrategyA()).testA();
		System.out.println();
		new StrategyTest(new StrategyB()).testB();
		
	}
	
	public void testA(){
		System.out.println("��һ�����򷽷���");
		this.is.sort(new int[]{3,2,5,4,1});
		this.is.sort(new int[]{3,2,5,4,1});
	}
	
	public void testB(){
		System.out.println("�ڶ������򷽷���");
		this.is.sort(new int[]{3,2,5,4,1});
	}
}
