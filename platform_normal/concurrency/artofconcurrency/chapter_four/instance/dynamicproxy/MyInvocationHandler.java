package concurrency.artofconcurrency.chapter_four.instance.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class MyInvocationHandler implements InvocationHandler {
	
    JavaProxyInterface javaProxy;
    
    public MyInvocationHandler(JavaProxyInterface javaProxy) {
        this.javaProxy = javaProxy;
    }
    
    /**AOP思想*/
    private void aopMethod() {
        System.out.println("before method");
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { //断点发现，代理类是ConcreteClass
        aopMethod();
        return method.invoke(javaProxy, args);
    }
}
