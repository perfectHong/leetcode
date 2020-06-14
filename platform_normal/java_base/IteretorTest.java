package java_base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author mengfh
 *
 * @version 2020-6-11����9:20:15
 *
 * @description
 */
public class IteretorTest {

	/**
	 * func1û���⣬func2��func3�ᱨ�����޸��쳣
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
