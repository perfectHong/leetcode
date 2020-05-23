package concurrency.artofconcurrency.chapter_four.instance.ConnectionPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * 此处用到了动态代理，可以理解一下
 * 
 * createConnection()要对照书本校验一下，pdf好像不对
 * */
public class ConnectionDriver {
	
    static class ConnectionHandler implements InvocationHandler {
    	@Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
            if (method.getName().equals("commit")) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }
    
    // 创建一个Connection的代理，在commit时休眠100毫秒
    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),new ConnectionPool(0).getClass().getInterfaces(), new ConnectionHandler());
    }
}