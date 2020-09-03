package java_base.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author mengfh
 *
 * @version 2020-6-11上午9:20:15
 *
 * @description 迭代器
 */
public class IteratorTest {

	/**
	 * func1没问题，func2和func3会报并发修改异常
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private void func1() {

		List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.size());
            if ("1".equals(list.get(i))){
                list.add("4");
                list.remove("1");
            }
        }
	}
	
	private void func2() {

		List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (String s : list){
            if ("1".equals(s)){
                list.add("4");
                list.remove("1");
            }
        }
	}
	
	private void func3() {

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
}
