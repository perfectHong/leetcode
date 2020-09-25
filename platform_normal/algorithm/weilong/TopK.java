package algorithm.weilong;

import java.util.PriorityQueue;

/**
 * https://zhuanlan.zhihu.com/p/76734219
 * 
 * TopK问题一般都是用堆处理的，链接中有三种方案
 * 1.全局排序O(n*lg(n)),全部排序
 * 2.局部排序O(n*k),冒泡排序只排序前K个数
 * 3.堆排序O(n*lg(k)),TopK个数也不排序
 * */
class TopK {
	
	/** PriorityQueue默认是小根堆，所以前K个最小的数好用 */
    public int[] topMinK(int[] arr, int k) {
        if (arr == null || arr.length == 0) 
        	return new int[k];
        int[] result = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.offer(i);
        }
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
    
   /** 求前K个最大的数 */
    
   /** 求前K个重复度最高（最热门）的数 */
}
