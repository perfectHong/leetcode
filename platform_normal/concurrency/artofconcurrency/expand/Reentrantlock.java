package concurrency.artofconcurrency.expand;


/**
 * �������������þ���Ϊ�˱���������java��synchronized��ReentrantLock���ǿ�������
 * 
 * ���߳̽���funcitonA(),functionB���ø���Ķ�����,��ǰ�߳̿�����
 * */
public class Reentrantlock {
	
	public synchronized void functionA() {
		System.out.println("iAmFunctionA");
		functionB();
	}

	public synchronized void functionB() {
		System.out.println("iAmFunctionB");
	}
}