package design_patterns.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author mengfh
 *
 * @version 2020-6-14下午1:30:11
 *
 * @description 防序列化攻击
 */
public class SingletonResolveTwo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		SingletonResolveTwo s1 = SingletonResolveTwo.getSingleton();
		SingletonResolveTwo s2 = null;
        try {
            FileOutputStream fos = new FileOutputStream("Singleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("Singleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s2 = (SingletonResolveTwo)ois.readObject();
            ois.close();

            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	/**防序列化攻击在这呢*/
	private Object readResolve() {
        return SubClass.singleton;
    }
	
	public static class SubClass{
		private static SingletonResolveTwo singleton = new SingletonResolveTwo();
	}
	
	public static SingletonResolveTwo getSingleton(){
		return SubClass.singleton;
	}
}
