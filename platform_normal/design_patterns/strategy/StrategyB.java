package design_patterns.strategy;

import algorithm.sort.BubbleSort;

/**
 * @author mengfh
 *
 * @version 2020-5-21下午7:02:47
 *
 * @description 降序排序器
 */
public class StrategyB implements IStrategy{

	public int[] sort(int[] arrays) {
		if(arrays == null){
			System.out.println("您使用了个null");
		}
		else{
			System.out.println("您使用了策略B的降序排序器:");
			BubbleSort.bubbleSort(arrays);
			for (int i = 0; i < arrays.length; i++) {
				System.out.print(arrays[i]);
			}
			System.out.println();
		}
			
		return arrays;
	}

}
