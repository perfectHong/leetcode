package java_base.bit_operation;
/**
 * @author mengfh
 *
 * @version 2020-5-23上午10:30:38
 *
 * @description
 */
public class BitOperationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 0;
		System.out.println("1|9 : " + ( 1|9));
		System.out.println("1^9 : " + ( 1^9));
		System.out.println("1&9 : " + ( 1&9));
		System.out.println(1<<3);     // 用最有效率的方法计算1乘以8
		System.out.println(1>>3);     // 0 ,1右移一下就为0了
		System.out.println(16>>>3);   // 无符号右移
		System.out.println(8>>>3);
		
		System.out.println(n &(n-1)); //将n的二进制表示中的最低位为1的改为0
		
		System.out.println(-8>>>3);   // 负数不理解
		//System.out.println(1<<<3);  // 不支持无符号左移，不理解
	}

}
