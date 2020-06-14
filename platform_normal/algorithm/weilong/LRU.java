package algorithm.weilong;

import java.util.LinkedHashMap;
import java.util.Map;

/**        
 * Title: ʹ��LinkedHashMapʵ��LRU�㷨    
 * Description: 
 * @author rico       
 * @created 2017��5��12�� ����11:32:10    
 */      
public class LRU<K,V> extends LinkedHashMap<K, V> implements Map<K, V>{

    private static final long serialVersionUID = 1L;

    public LRU(int initialCapacity,
             float loadFactor,
                        boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    /** 
     * @description ��дLinkedHashMap�е�removeEldestEntry��������LRU��Ԫ�ض���6��ʱ��
     *              ɾ�������ʹ�õ�Ԫ��
     * @author rico       
     * @created 2017��5��12�� ����11:32:51      
     * @param eldest
     * @return     
     * @see java.util.LinkedHashMap#removeEldestEntry(java.util.Map.Entry)     
     */  
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        // TODO Auto-generated method stub
        if(size() > 6){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        LRU<Character, Integer> lru = new LRU<Character, Integer>(
                16, 0.75f, true);

        String s = "abcdefghijkl";
        for (int i = 0; i < s.length(); i++) {
            lru.put(s.charAt(i), i);
        }
        System.out.println("LRU��keyΪh��Entry��ֵΪ�� " + lru.get('h'));
        System.out.println("LRU�Ĵ�С ��" + lru.size());
        System.out.println("LRU ��" + lru);
    }
}