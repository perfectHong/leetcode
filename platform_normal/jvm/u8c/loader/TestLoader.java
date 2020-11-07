package jvm.u8c.loader;

public class TestLoader {

	public static void main(String[] args) {
		String basePath = "C:\\U8Cwork";
		FileSystemClassLoader loader = new FileSystemClassLoader(basePath);
		try {
			Class.forName("loader.test.CanLoadedClass",true,loader).newInstance();  //测试下FileSystemClassLoader破坏双亲委派机制loadclass();
//			Class.forName("java.lang.String",true,loader).newInstance();//测试下没有破坏委派机制  和   FileSystemClassLoader破坏双亲委派机制loadclass();
		} catch (ClassNotFoundException e) {
			System.out.println(" TestLoader error");
		} 
		catch (InstantiationException e) {
			System.out.println(" TestLoader error");
		} 
		catch (IllegalAccessException e) {
			System.out.println(" TestLoader error");
		}
	}

}
