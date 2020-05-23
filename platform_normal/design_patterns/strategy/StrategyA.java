package design_patterns.strategy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mengfh
 *
 * @version 2020-5-21下午7:02:27
 *
 * @description 升序排序器
 */
public class StrategyA implements IStrategy{
	
	public int[] sort(int[] arrays) {
		if(arrays == null){
			System.out.println("您使用了个null");
		}
		else{
			System.out.println("您使用了策略A的升序排序器:");
			Arrays.sort(arrays);
			for (int i = 0; i < arrays.length; i++) {
				System.out.print(arrays[i]);
			}
			System.out.println();
		}
			
		return arrays;
	}

}
