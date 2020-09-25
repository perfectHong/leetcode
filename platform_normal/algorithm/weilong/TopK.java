package algorithm.weilong;

import java.util.PriorityQueue;

/**
 * https://zhuanlan.zhihu.com/p/76734219
 * 
 * TopK����һ�㶼���öѴ���ģ������������ַ���
 * 1.ȫ������O(n*lg(n)),ȫ������
 * 2.�ֲ�����O(n*k),ð������ֻ����ǰK����
 * 3.������O(n*lg(k)),TopK����Ҳ������
 * */
class TopK {
	
	/** PriorityQueueĬ����С���ѣ�����ǰK����С�������� */
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
    
   /** ��ǰK�������� */
    
   /** ��ǰK���ظ�����ߣ������ţ����� */
}
