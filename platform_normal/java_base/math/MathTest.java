package java_base.math;

/**
 * @author mengfh
 * 
 * @version 2020-5-23上午10:30:20
 * 
 * @description
 */
public class MathTest {

	public static void main(String[] args) {

		System.out.println("*************Math篇**************");
		//圆周率，平方根
		System.out.println(Math.PI);
		System.out.println(Math.pow(2, 3));

		//向上取整
		System.out.println(Math.ceil(12.3));
		System.out.println(Math.ceil(12.99));
		System.out.println(Math.ceil(-12.30));
		System.out.println(Math.ceil(-12.99));

		//向下取整
		System.out.println(Math.floor(12.3));
		System.out.println(Math.floor(12.99));
		System.out.println(Math.floor(-12.3));
		System.out.println(Math.floor(-12.99));
		
		//0.0~1.0   之间的小数。包括0.0不包括1.0
		System.out.println(Math.random());
		
		//四舍五入,加0.5再向下取整
		System.out.println(Math.round(12.3f));
		System.out.println(Math.round(12.9f));
		System.out.println(Math.round(-12.4));
		System.out.println(Math.round(-11.5)); //加0.5再向下取整，输出-12，怎么感觉有问题呢
		
		System.out.println("*************基础数据篇**************");
		//float a = 3.5;       //3.4是双精度数，将双精度型（double）赋值给浮点型（float）属于下转型
		float f =(float)3.4;   //强转倒是可以

		//short s1 = 1; s1 = s1 + 1;   //1是int型，需要强转才能转成short,如下
		short s1 = 1; s1 =(short)(s1 + 1);   
		short s2 = 1;s2 += 1;          //有隐含的强制类型转换，如上
	}
}
