package binary;

/**
 * @author mengfh
 * 
 * @version 2019-12-28����4:36:28
 * 
 * @description
 */
public class Binary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η�����֤base��exponent��ͬʱΪ0
	
	/**
	 * 1.ȫ�濼��ָ���������������Ƿ�Ϊ�������� 
	 * 2.д��ָ���Ķ����Ʊ�����13���Ϊ������1101�� 
	 * 3.����:10^1101 = 10^0001*10^0100*10^1000�� 
	 * 4.ͨ��&1��>>1����λ��ȡ1101��Ϊ1ʱ����λ����ĳ����۳˵����ս����
	 */
	public double Power(double base, int n) {
		double res = 1, curr = base;
		int exponent;
		if (n > 0) {
			exponent = n;
		} else if (n < 0) {
			if (base == 0)
				throw new RuntimeException("��ĸ����Ϊ0");
			exponent = -n;
		} else {// n==0
			return 1;// 0��0�η�
		}
		while (exponent != 0) {
			if ((exponent & 1) == 1)
				res *= curr;
			curr *= curr;// ����
			exponent >>= 1;// ����һλ
		}
		return n >= 0 ? res : (1 / res);
	}
}
