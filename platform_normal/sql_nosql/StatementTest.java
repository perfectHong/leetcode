package sql_nosql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author mengfh
 * 
 * @description
 * 
 * @date 2020-9-24����12:41:38
 */
public class StatementTest {
	
	public static void main(String[] args) {
		
	}
	/****
	 * Ϊ������ ��Statement��PreparedStatement��PreparedStatement + ������
	 * ������֮���Ч�ʣ������ʾ��ִ�й��̶��������ݿ��t1�в���1������¼������¼�������ʱ��(��ʱ�������Ӳ���й�)��ʵ�������£�
	 * 1.ʹ��Statement���� ��ʱ31�� 2.Ԥ����PreparedStatement ��ʱ14�� 3.ʹ��PreparedStatement
	 * + ������ ��ʱ485����*** -------------------------------------------------------
	 * 1.ʹ��Statement���� ʹ�÷�Χ����ִ������SQL(�ṹ��ͬ������ֵ��ͬ)���Ĵ����Ƚ��� �ŵ㣺�﷨��
	 * ȱ�㣺����Ӳ����Ч�ʵͣ���ȫ�Խϲ ԭ��Ӳ���룬ÿ��ִ��ʱ����SQL������б���
	 * 
	 * ʾ��ִ�й���:
	 */
	public static void exec(Connection conn) {
		try {
			Long beginTime = System.currentTimeMillis();
			conn.setAutoCommit(false);// �����ֶ��ύ
			Statement st = conn.createStatement();
			for (int i = 0; i < 10000; i++) {
				String sql = "insert into t1(id) values (" + i + ")";
				st.executeUpdate(sql);
			}
			Long endTime = System.currentTimeMillis();
			System.out.println("Statement��ʱ��" + (endTime - beginTime) / 1000
					+ "��");// ����ʱ��
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ִ��ʱ�䣺Statement��ʱ��31��
	 * ----------------------------------------------------------------
	 * 2.Ԥ����PreparedStatement
	 * ʹ�÷�Χ����ִ������sql���Ĵ����Ƚ϶ࣨ�����û���½���Ա�Ƶ������..�����һ����ֻ�Ǿ����ֵ��һ��������Ϊ��̬SQL
	 * �ŵ㣺���ֻ����һ�Σ����ٱ������������˰�ȫ�ԣ���ֹ��SQLע�룩 ȱ��: ִ�з�����SQL���ʱ���ٶȽ�����
	 * ԭ������SQLֻ����һ�Σ����ٱ������ ����ִ�й���:
	 */
	public static void exec2(Connection conn) {
		try {
			Long beginTime = System.currentTimeMillis();
			conn.setAutoCommit(false);// �ֶ��ύ
			PreparedStatement pst = conn
					.prepareStatement("insert into t1(id) values (?)");
			for (int i = 0; i < 10000; i++) {
				pst.setInt(1, i);
				pst.execute();
			}
			conn.commit();
			Long endTime = System.currentTimeMillis();
			System.out.println("Pst��ʱ:" + (endTime - beginTime) + "��");// ����ʱ��
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ִ��ʱ�䣺Pst��ʱ:14��
	 * ------------------------------------------------------------------
	 * 3.ʹ��PreparedStatement + ������ ʹ�÷�Χ��һ����Ҫ�������ݿ�������¼
	 * �ŵ㣺���ٺ�SQL���潻���Ĵ������ٴ����Ч��,�������ֻ����һ�Σ����ٱ������������˰�ȫ�ԣ���ֹ��SQLע�룩 ȱ��: ԭ��������:
	 * ���ٺ�SQL���潻���Ĵ�����һ�δ��ݸ�SQL�������SQL�� ���ʽ��ͣ�
	 * PL/SQL���棺��oracle��ִ��pl/sql��������棬��ִ���з��ֱ�׼��sql�ύ��sql������д���
	 * SQL���棺ִ�б�׼sql�����档 ����ִ�й���:
	 */
	public static void exec3(Connection conn) {
		try {
			conn.setAutoCommit(false);
			Long beginTime = System.currentTimeMillis();
			PreparedStatement pst = conn
					.prepareStatement("insert into t1(id) values (?)");

			for (int i = 1; i <= 10000; i++) {
				pst.setInt(1, i);
				pst.addBatch();// �������������д��
				if (i % 1000 == 0) {// �������ò�ͬ�Ĵ�С����50��100��500��1000�ȵ�
					pst.executeBatch();
					conn.commit();
					pst.clearBatch();
				}// end of if
			}// end of for
			pst.executeBatch();
			Long endTime = System.currentTimeMillis();
			System.out.println("pst+batch��ʱ��" + (endTime - beginTime) + "����");
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
}
