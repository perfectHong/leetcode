package jvm.u8c.loader;

public class TestLoader {

	public static void main(String[] args) {
		String basePath = "C:\\U8Cwork";
		FileSystemClassLoader loader = new FileSystemClassLoader(basePath);
		try {
			Class.forName("loader.test.CanLoadedClass",true,loader).newInstance();  //������FileSystemClassLoader�ƻ�˫��ί�ɻ���loadclass();
//			Class.forName("java.lang.String",true,loader).newInstance();//������û���ƻ�ί�ɻ���  ��   FileSystemClassLoader�ƻ�˫��ί�ɻ���loadclass();
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
