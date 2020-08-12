package java_base.reflect;
import java.lang.reflect.Method;
import java.util.ArrayList;
 
/**
 * 反射使用案例，反射越过泛型检查
 * 1.获取Class
 * 2.获取Method
 * 3.调用invoke()
 */
public class Demo {
	
	public static void main(String[] args) throws Exception{
		ArrayList<String> strList = new ArrayList<>();
		strList.add("aaa");
		strList.add("bbb");
		//获取ArrayList的Class对象，反向的调用add()方法，添加数据
		Class<?> listClass = strList.getClass(); //得到 strList 对象的字节码 对象
		//获取add()方法
		Method m = listClass.getMethod("add", Object.class);
		//调用add()方法
		m.invoke(strList, 100);
		//遍历集合
		for(Object obj : strList){
			System.out.println(obj);
		}
	}
	
}