package besttest;

import vo.ListNode;

/**
 * @author mengfh
 *
 * @version 2020-1-2����9:00:24
 *
 * @description
 */
public class MergeList {

	//���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
	public static void main(String[] args) {
		//�ݹ�������Ҫ˼��
		//1.����ֹͣ����,���� �׳˵������е�nΪ1ʱ�Ϳ���ֱ�ӷ���
		//2.����������ԭ����Ϊͬ�����£��ҹ�ģ��С
		
		//��������������ǳ����ģ����Ǿ�֪������ݹ�������е� n ������ȷ�ġ�
		//�� n=0,1 ʱ�������ȷ��
		//����ݹ���� n ����ȷ�ģ�ͬʱ���� n+1 Ҳ��ȷ��
	}
	// �ݹ��Ƽ��ο���https://blog.csdn.net/qmdweb/article/details/80537602
	// �ݹ飬����Ҫ���ǵݹ�˼�룬��ʱ�Լ����ʹ�õݹ�
    public static ListNode Merge(ListNode list1,ListNode list2) {
    	if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }       
    }
}
