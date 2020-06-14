package concurrency.artofconcurrency.chapter_four.instance.connectionpool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * �˴��õ��˶�̬�����������һ��
 * 
 * createConnection()Ҫ�����鱾У��һ�£�pdf���񲻶�
 * */
public class ConnectionDriver {
	
    static class ConnectionHandler implements InvocationHandler {
    	@Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{  //�ϵ㷢�֣���������null,��Ϊ������ǽӿڣ����ǽӿڵ�ʵ����
            if (method.getName().equals("commit")) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }
    
    // ����һ��Connection�Ĵ�����commitʱ����100����
    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(),new Class[] {Connection.class }, new ConnectionHandler());
    }
}