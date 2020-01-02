package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author mengfh
 *
 * @version 2019-12-27下午2:29:12
 *
 * @description
 */
public class ArrayIntersect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.clear();

	}
	/** 求两数组交集*/

	/**数组工具类*/
	
	/** 数组转list*/
	String[] array = {"a","b","c"};
	List<String> resultList= new ArrayList<>(Arrays.asList(array));
	Set<String> set = new HashSet<>(resultList);
	
	/*
	valueOf(type[] a, int length); 将数据按照传入的长度拷贝到一个新的数组中
	
	copyOfRange(type[] a, int start, int end); 将源数组按照传入的开始位置和结束位置拷贝到一个新的数组中;
	
	sort(type[] a); 将源数组按照优化的快速排序法进行排序
	
	binarySearch(type[] a, type v); 在整个数组中按照二分查找法查找数据，查找成功返回下标，否则返回-1；
	
	fill(type[] a, type v); 将数组中的所有元素值都设置为v;
	
	equals(type[] a, type[] b,); 如果两个数组的长度和每个元素值都相等，那么返回true,否则返回false
	*/
}
