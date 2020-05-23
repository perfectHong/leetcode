package design_patterns.strategy;

import java.util.Arrays;
import java.util.Comparator;

import algorithm.sort.BubbleSort;

/**
 * @author mengfh
 *
 * @version 2020-5-21����7:02:47
 *
 * @description ����������
 */
public class StrategyB implements IStrategy{

	public int[] sort(int[] arrays) {
		if(arrays == null){
			System.out.println("��ʹ���˸�null");
		}
		else{
			System.out.println("��ʹ���˲���B�Ľ���������:");
			BubbleSort.bubbleSort(arrays);
			for (int i = 0; i < arrays.length; i++) {
				System.out.print(arrays[i]);
			}
			System.out.println();
		}
			
		return arrays;
	}

}
