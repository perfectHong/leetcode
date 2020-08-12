package jvm.optimize;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import vo.TestVO;

/**
 * @author mengfh
 *
 * @version 2020-7-3上午9:15:52
 *
 * @description OOM排查与优化
 */
public class OptimizeOOM {

	public static void main(String[] args) {
		testQueue();
	}
	
	private static void testQueue() {
		Queue<ArrayList<TestVO>> queue = new LinkedBlockingQueue<>();
		for (int i = 0; i < 10000; i++) {
			ArrayList<TestVO> list = new ArrayList<>();
			for (int j = 0; j < 1000; j++) {
				list.add(new TestVO());
			}
			queue.add(list);
		}
	}
}
