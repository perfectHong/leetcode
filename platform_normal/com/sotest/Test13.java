package com.sotest;

/**
 * @author mengfh
 *
 * @description ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 * 
 * ���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 *
 * @date 2020-10-15����9:10:58
 */
public class Test13 {

	/**
	 * @param ����⵱ʱ���Լ�һ����ˣ��ڶ��������ɵĻ���������
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public static void reOrderArray(int[] array) {
		
		int[] temp = new int[array.length];
		int ouindex = 0;
		int jiindex = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] % 2 != 1){
				temp[ouindex++] = array[i];
			}else{
				array[jiindex++] = array[i];
			}
		}
		for (int i = ouindex + 1; i < array.length; i++) {
			array[i] = temp[i-jiindex];
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
