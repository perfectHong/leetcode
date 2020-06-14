package design_patterns.singleton;
/**
 * @author mengfh
 *
 * @version 2020-6-14����1:15:49
 *
 * @description ˫�ؼ����
 */
public class SingletonThree {

	public static void main(String[] args) {
		System.out.println(SingletonThree.getSingleton() == SingletonThree.getSingleton());
	}
	
	private static volatile SingletonThree singleton = null;

	private SingletonThree(){}
	
	public static SingletonThree getSingleton(){
		if(singleton == null){
			synchronized(SingletonThree.class){  // ע��������������.class��������this
				if (singleton == null) {         // this�ؼ��ֱ�����ڷǾ�̬��������,��Ϊthis����ǰ��������ã��Ƕ��󼶱�ģ�static���༶���
					singleton = new SingletonThree();				
					}
			}
		}
		return singleton;
	}
}
