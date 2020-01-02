package binary;
/**
 * @author mengfh
 *
 * @version 2019-12-28下午4:29:20
 *
 * @description
 */
public class NumberOfBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	/** 牛逼就用位运算*/
    public int NumberOf1(int n) {
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);
         }
        return count;
    }
    /** Integer自带十进制到二进制转换*/
    public int NumberOf2(int n) {
        int t=0;
            char[]ch=Integer.toBinaryString(n).toCharArray();
            for(int i=0;i<ch.length;i++){
                if(ch[i]=='1'){
                    t++;
                }
            }
            return t;
    }
}
