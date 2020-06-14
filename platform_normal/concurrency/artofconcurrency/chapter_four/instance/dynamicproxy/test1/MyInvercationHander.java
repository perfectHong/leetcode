
package concurrency.artofconcurrency.chapter_four.instance.dynamicproxy.test1;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class MyInvercationHander implements InvocationHandler{

 private Object obj;

 public Object bind(Object obj){
  this.obj=obj;
  return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
 }

 @Override
 public Object invoke(Object proxy, Method method, Object[] args)
   throws Throwable {
  Object temp = method.invoke(this.obj, args);
  //这里做切面操作 比如我要加功能 
  System.out.println("方法之前！");
  return temp;
 }

}
