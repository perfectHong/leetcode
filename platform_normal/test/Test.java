package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author mengfh
 *
 * @version 2020-6-8ÏÂÎç6:36:32
 *
 * @description
 */
public class Test {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if ("1".equals(iterator.next())) {
                iterator.remove();
                list.add("4");
                list.remove("1");
            }
        }
	}
	
	private static void func1() {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 100; i++) {
			map.put(i, i+10);
		}
		System.out.println(map.size());
	}

}
