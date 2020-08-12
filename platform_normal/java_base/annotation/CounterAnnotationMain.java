package java_base.annotation;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CounterAnnotationMain {

	public static void main(String[] args) throws Exception{
		//����ģ����ע���Ա���Դӳ����ؽ����Ĺ���
		Map<String,Object> values = new HashMap<>(8);
		values.put("count", 1);
		//���ɴ�����
		CounterAnnotation proxy = (CounterAnnotation)Proxy.newProxyInstance(CounterAnnotationMain.class.getClassLoader(),
				new Class[]{CounterAnnotation.class},
				new CounterAnnotationInvocationHandler(values, CounterAnnotation.class));
		System.out.println(proxy.count());
	}
}
//���к����̨���:1