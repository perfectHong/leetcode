package jvm.u8c.nativ;

public class LoadTest {

	public static void main(String[] args) {
//		System.out.println(Woman.name);
//		Woman[] wenman = new Woman[10];  //new的是数组，不是真正的对象，数组编译后是L开头的对象，什么都不输出
		System.out.println(Woman.femaleName);  //如果Woman.femaleName被final修饰就是另外一种结果了
	}

}
