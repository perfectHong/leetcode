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
 * @version 2019-12-27����2:29:12
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
	/** �������齻��*/

	/**���鹤����*/
	
	/** ����תlist*/
	String[] array = {"a","b","c"};
	List<String> resultList= new ArrayList<>(Arrays.asList(array));
	Set<String> set = new HashSet<>(resultList);
	
	/*
	valueOf(type[] a, int length); �����ݰ��մ���ĳ��ȿ�����һ���µ�������
	
	copyOfRange(type[] a, int start, int end); ��Դ���鰴�մ���Ŀ�ʼλ�úͽ���λ�ÿ�����һ���µ�������;
	
	sort(type[] a); ��Դ���鰴���Ż��Ŀ������򷨽�������
	
	binarySearch(type[] a, type v); �����������а��ն��ֲ��ҷ��������ݣ����ҳɹ������±꣬���򷵻�-1��
	
	fill(type[] a, type v); �������е�����Ԫ��ֵ������Ϊv;
	
	equals(type[] a, type[] b,); �����������ĳ��Ⱥ�ÿ��Ԫ��ֵ����ȣ���ô����true,���򷵻�false
	*/
}
