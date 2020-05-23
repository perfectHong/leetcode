package design_patterns.strategy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mengfh
 *
 * @version 2020-5-21����7:02:27
 *
 * @description ����������
 */
public class StrategyA implements IStrategy{
	
	public int[] sort(int[] arrays) {
		if(arrays == null){
			System.out.println("��ʹ���˸�null");
		}
		else{
			System.out.println("��ʹ���˲���A������������:");
			Arrays.sort(arrays);
			for (int i = 0; i < arrays.length; i++) {
				System.out.print(arrays[i]);
			}
			System.out.println();
		}
			
		return arrays;
	}

}
