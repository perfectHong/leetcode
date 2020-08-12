package java_base.reflect;
import java.lang.reflect.Method;
import java.util.ArrayList;
 
/**
 * ����ʹ�ð���������Խ�����ͼ��
 * 1.��ȡClass
 * 2.��ȡMethod
 * 3.����invoke()
 */
public class Demo {
	
	public static void main(String[] args) throws Exception{
		ArrayList<String> strList = new ArrayList<>();
		strList.add("aaa");
		strList.add("bbb");
		//��ȡArrayList��Class���󣬷���ĵ���add()�������������
		Class<?> listClass = strList.getClass(); //�õ� strList ������ֽ��� ����
		//��ȡadd()����
		Method m = listClass.getMethod("add", Object.class);
		//����add()����
		m.invoke(strList, 100);
		//��������
		for(Object obj : strList){
			System.out.println(obj);
		}
	}
	
}