package design_patterns.strategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
	}
	
	public void testB(){
		System.out.println("�ڶ������򷽷���");
		this.is.sort(new int[]{3,2,5,4,1});
	}
	
	// �����ڲ���ʵ��Comparator����
	public void testC(){
		List<String> names = Arrays.asList("1", "2", "3", "4");
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
//		JDK1.8������Lambda ���ʽд��һ
//		Collections.sort(names, (String a, String b) -> {
//			return b.compareTo(a);
//		});
//		JDK1.8������Lambda ���ʽд����
//		Collections.sort(names, (String a, String b) -> b.compareTo(a));
	}
}
