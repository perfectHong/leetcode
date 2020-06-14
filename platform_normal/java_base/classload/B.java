package java_base.classload;

public class B {
	// ��̬����
	static int i = 1;
	// ��̬����
	static {
		System.out.println("Class B1:static blocks" + i);   //1
	}
	// �Ǿ�̬����
	int j = 1;
	// ��̬����
	static {
		i++;
		System.out.println("Class B2:static blocks" + i);  //2
	}

	// ���캯��
	public B() {
		i++;
		j++;
		System.out.println("constructor B: " + "i=" + i + ",j=" + j);  //6
	}

	// �Ǿ�̬����
	{
		i++;
		j++;
		System.out.println("Class B:common blocks" + "i=" + i + ",j=" + j);  //5�������丸��B�Ĺ��캯��ǰ,�����ȵ��ø���B�еķǾ�̬�������Ǿ�̬����
	}

	// �Ǿ�̬����
	public void bDisplay() {
		i++;
		System.out.println("Class B:static void bDisplay():	" + "i=" + i
				+ ",j=" + j);
		return;
	}

	// ��̬����
	public static void bTest() {
		i++;
		System.out.println("Class B:static void bTest():	" + "i=" + i);
		return;
	}
}