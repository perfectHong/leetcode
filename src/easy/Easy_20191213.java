package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

/**
 * @author mengfh
 *
 * @version 2019-12-13����2:42:48
 *
 * @description
 */
public class Easy_20191213 {

	public static void main(String[] args) {
		//func_test();
		//reverse(-123456);
		//twoSum(new int[]{1,2,3,4}, 6);
	}
	/**
	 * ����֮��
	 */
    @SuppressWarnings("unused")
	public static int[] twoSum(int[] nums, int target) {
    	/** һά���鶨�����ַ�ʽ */
        int[] num1 = new int[]{1};
        int[] num2 = new int[2];
        int[] num3 = {1};
        /** ��λ���鶨�����ַ�ʽ */
        int[][] num4 = new int[][]{{1,3},{2}};
        int[][] num6 = new int[1][2];
        int[][] num5 = new int[1][];
        int[][] num7 = {{1,1},{2}};
        /** ��ʼ���� */
        /** ʱ�临�Ӷ�O(n^2)�����ڱ��� */
        /**
        for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 1; j < nums.length; j++) {
				if(target == nums[i] + nums[j]){
					return new int[] {i, j};
				}
			}
		}
    	*/
        Map<Integer, Integer> map = new HashMap();
        /** �˴���Entry���Ǿ����࣬�˴�Ҳ��Ҫ���������� */
        for(Entry<Integer, Integer> enter : map.entrySet()){
        	
        }
        /** Ҫ�󷵻������±꣬���Խ��±���Ϊvalue�洢 */
        for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
			map.entrySet();
        }
        for (int j = 0; j < nums.length; j++) {
        	int other = target - nums[j];
        	if(map.containsKey(other)){
        		return new int[]{j, map.get(other)};
        	}
		}
        /** �˴��׳��쳣�����Բ���return */
        throw new IllegalArgumentException("��·��ͨ");
    }
	
    /**
     * ����֮��δ���
     */
    public List<List<Integer>> threeSum(int[] nums) {
    	
    	List<List<Integer>> list = new ArrayList<>();
    	
		return list;
    }
    
    /**
     * String.valueOf(x);
     * Integer.valueOf(x);
     * StringBuilder.reverse().toString();
     * Math.abs();
     */
    public static int reverse(int x) {
    	System.out.println(1<<31);
//    	if(x < 1>>31 || x > (1<<31 - 1) || x == 0)
//    		return 0;
    	if(x > 0){
    		String str = String.valueOf(x);
    		StringBuilder sb = new StringBuilder(str);
    		int result = Integer.valueOf(sb.reverse().toString());
    		System.out.println(result);
    		return result;
    	}
    	if(x < 0){
    		int y = Math.abs(x);
    		String str = String.valueOf(y);
    		StringBuilder sb = new StringBuilder(str);
    		int result = Integer.valueOf(sb.reverse().toString());
    		System.out.println(0 - result);
    		return 0 - result;
    	}
    	return x;
    }
    
    public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0)
    		return null;
    	String prefix = strs[0];
    	for (int i = 1; i < strs.length; i++) {
			while(!strs[i].startsWith(prefix)){
				prefix = prefix.substring(0, prefix.length()-1);
				if(prefix.isEmpty())
					return "";
			}
		}
    	Map<String, String> map = new LinkedHashMap<>(); 
    	for (Map.Entry<String, String> entry : map.entrySet()) {
		}
		return prefix;
    }
	
    public int removeElement(int[] nums, int val) {
		return val;
        
    }
}
