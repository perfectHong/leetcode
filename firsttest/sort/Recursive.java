package sort;
/**
 * @author mengfh
 *
 * @version 2019-12-28����4:20:36
 *
 * @description
 */
public class Recursive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
    public static int rectCover(int target) {
    	// ����Ҫ����Ҫ������Ҫ�õݹ��㷨��������ҵ����� 
    	if(target <= 0)
    		return 0;
    	if(target == 1)
    		return 1;
    	if(target == 2)
    		return 2;
    	return rectCover(target - 1) + rectCover(target - 2);
    }
}
