package java_base.bit_operation;
/**
 * @author mengfh
 *
 * @version 2020-5-23����10:30:38
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
		System.out.println(1<<3);     // ������Ч�ʵķ�������1����8
		System.out.println(1>>3);     // 0 ,1����һ�¾�Ϊ0��
		System.out.println(16>>>3);   // �޷�������
		System.out.println(8>>>3);
		
		System.out.println(n &(n-1)); //��n�Ķ����Ʊ�ʾ�е����λΪ1�ĸ�Ϊ0
		
		System.out.println(-8>>>3);   // ���������
		//System.out.println(1<<<3);  // ��֧���޷������ƣ������
	}

}
