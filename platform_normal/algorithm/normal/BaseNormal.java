package algorithm.normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import vo.ListNode;

/**
 * @author mengfh
 * 
 * @version 2020-4-29����3:48:39
 * 
 * @description
 */
public class BaseNormal {

	public static void main(String[] args) {
//		maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
//		maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
//		singleNumber(new int[] { 7, 1, 5, 7, 1 });
//		majorityElement(new int[] { 7, 1, 1, 7, 1 });
//		rotate(new int[] { 7, 11, 12, 17, 13, 55, 66 }, 3);
//		isHappy(111);
		rob2(new int[] { 7, 1, -1, 1, 7 });
	}

	// �ж����� n �Ƿ�������(����)
	boolean isPrime(int n) {
	    for (int i = 2; i < n/2; i++)
	        if (n % i == 0)
	            // ��������������
	            return false;
	    return true;
	}

	public static int rob(int[] num) {
	    int prevMax = 0;
	    int currMax = 0;
	    for (int x : num) {
	        int temp = currMax;
	        currMax = Math.max(prevMax + x, currMax);
	        prevMax = temp;
	        System.out.println("currMax:" + currMax);
	        System.out.println("prevMax:" + prevMax);
	    }
	    System.out.println("���գ�" + currMax);
	    return currMax;
	}
	
	public static int rob2(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[nums.length];
    }

	public static boolean isHappy(int n) {
		if (n == 1)
			return true;
		if (n < 1)
			return false;
		int sum = 0;
		while (n > 0) {
			int temp = n % 10;
			n = n / 10;
			sum += temp * temp;
			if(sum == 1 && n == 0){
				return true;
			}
			else if(sum != 1 && n == 0){
				n = sum;
				sum = 0;
			}
		}
		return true;
	}
	
	/**λ1�ĸ�����n & (n - 1) : ��n�Ķ����Ʊ�ʾ�е����λΪ1�ĸ�Ϊ0*/
	public int hammingWeight(int n) {
	    int bits = 0;
	    int mask = 1;
	    for (int i = 0; i < 32; i++) {
	        if ((n & mask) != 0) {
	            bits++;
	        }
	        mask <<= 1;
	    }
	    return bits;
	}

	public int hammingWeight2(int n) {
	    int sum = 0;
	    while (n != 0) {
	        sum++;
	        n &= (n - 1);
	    }
	    return sum;
	}

	/**ԭ�ط�ת����*/
	public static void rotate(int[] nums, int k) {
		for (int i = 0; i < k; i++) {
			int temp = nums[nums.length - 1];
			for (int j = nums.length - 1; j > 0; j--) {
				nums[j] = nums[j-1];
			}
			nums[0] = temp;
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
    }
	
	/**��̬�滮*/
	public int maxSubArray1(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
	
	/** ̰������������� */
	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int currSum = 0, maxSum = 0;// �ӵ�ǰ���Ž⵽ȫ�����Ž�
		for (int i = 0; i < nums.length; ++i) {
			currSum = Math.max(nums[i], currSum + nums[i]);
			maxSum = Math.max(maxSum, currSum);
		}
		System.out.println(maxSum);
		return maxSum;
	}

	/**��׳˵�0����10����0��2����10��һ��0��2*5��һ��0���Լ����*/
	public int trailingZeroes(int n) {
	    int count = 0;
	    while (n > 0) {
	        count += n / 5;
	        n = n / 5;
	    }
	    return count;
	}
	
	public static int majorityElement(int[] nums) {
		
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		Iterator<Integer> it = set.iterator();
		int[] arr = new int[set.size()];
		Map<Integer, Integer> map = new HashMap<>();
		while(it.hasNext()){
			int count = 0;
			int temp = it.next();
			for (int i = 0; i < nums.length; i++) {
				if(nums[i] == temp)
					count++;
			}
			map.put(temp, count);
		}
		int max = 0;
		for(Entry<Integer, Integer> entry : map.entrySet()){
			if(entry.getValue() > max)
				max = entry.getValue();
		}
		System.out.println(max);
		return max;
    }
	
	/**
	 * ����: numbers = [2, 7, 11, 15], target = 9 ���: [1,2] ����: 2 �� 7 ֮�͵���Ŀ����9 ����� index1 = 1, index2 = 2 ��
	 * */
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null) return null;
	    int i = 0, j = numbers.length - 1;
	    while (i < j) {
	        int sum = numbers[i] + numbers[j];
	        if (sum == target) {
	            return new int[]{i + 1, j + 1};
	        } else if (sum < target) {
	            i++;
	        } else {
	            j--;
	        }
	    }
	    return null;
	}

	public static int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			int j = 0;
			while (j < i) {
				int temp = prices[i] - prices[j];
				if (temp > profit)
					profit = temp;
				j++;
			}
		}
		System.out.println(profit);
		return profit;
	}

	/** ֻ��һ�������ظ������������ظ����Ҷ�ֻ������,��ʱ����������ţ�� */
	public static int singleNumber(int[] nums) {
		int a = 0;
		for (int i : nums)
			a ^= i;
		return a;
	}
}
