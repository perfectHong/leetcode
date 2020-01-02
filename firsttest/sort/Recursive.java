package sort;
/**
 * @author mengfh
 *
 * @version 2019-12-28下午4:20:36
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

	//我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    public static int rectCover(int target) {
    	// 最重要的是要发现需要用递归算法，其次再找到规律 
    	if(target <= 0)
    		return 0;
    	if(target == 1)
    		return 1;
    	if(target == 2)
    		return 2;
    	return rectCover(target - 1) + rectCover(target - 2);
    }
}
