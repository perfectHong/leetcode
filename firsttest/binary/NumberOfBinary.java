package binary;
/**
 * @author mengfh
 *
 * @version 2019-12-28����4:29:20
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
	//����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
	/** ţ�ƾ���λ����*/
    public int NumberOf1(int n) {
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);
         }
        return count;
    }
    /** Integer�Դ�ʮ���Ƶ�������ת��*/
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
