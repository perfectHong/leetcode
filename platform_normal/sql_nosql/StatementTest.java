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
 * @date 2020-9-24下午12:41:38
 */
public class StatementTest {
	
	public static void main(String[] args) {
		
	}
	/****
	 * 为了区分 “Statement、PreparedStatement、PreparedStatement + 批处理”
	 * 这三者之间的效率，下面的示例执行过程都是在数据库表t1中插入1万条记录，并记录出所需的时间(此时间与电脑硬件有关)。实验结果如下：
	 * 1.使用Statement对象 用时31秒 2.预编译PreparedStatement 用时14秒 3.使用PreparedStatement
	 * + 批处理 用时485毫秒*** -------------------------------------------------------
	 * 1.使用Statement对象 使用范围：当执行相似SQL(结构相同，具体值不同)语句的次数比较少 优点：语法简单
	 * 缺点：采用硬编码效率低，安全性较差。 原理：硬编码，每次执行时相似SQL都会进行编译
	 * 
	 * 示例执行过程:
	 */
	public static void exec(Connection conn) {
		try {
			Long beginTime = System.currentTimeMillis();
			conn.setAutoCommit(false);// 设置手动提交
			Statement st = conn.createStatement();
			for (int i = 0; i < 10000; i++) {
				String sql = "insert into t1(id) values (" + i + ")";
				st.executeUpdate(sql);
			}
			Long endTime = System.currentTimeMillis();
			System.out.println("Statement用时：" + (endTime - beginTime) / 1000
					+ "秒");// 计算时间
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 执行时间：Statement用时：31秒
	 * ----------------------------------------------------------------
	 * 2.预编译PreparedStatement
	 * 使用范围：当执行相似sql语句的次数比较多（例如用户登陆，对表频繁操作..）语句一样，只是具体的值不一样，被称为动态SQL
	 * 优点：语句只编译一次，减少编译次数。提高了安全性（阻止了SQL注入） 缺点: 执行非相似SQL语句时，速度较慢。
	 * 原理：相似SQL只编译一次，减少编译次数 事例执行过程:
	 */
	public static void exec2(Connection conn) {
		try {
			Long beginTime = System.currentTimeMillis();
			conn.setAutoCommit(false);// 手动提交
			PreparedStatement pst = conn
					.prepareStatement("insert into t1(id) values (?)");
			for (int i = 0; i < 10000; i++) {
				pst.setInt(1, i);
				pst.execute();
			}
			conn.commit();
			Long endTime = System.currentTimeMillis();
			System.out.println("Pst用时:" + (endTime - beginTime) + "秒");// 计算时间
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 执行时间：Pst用时:14秒
	 * ------------------------------------------------------------------
	 * 3.使用PreparedStatement + 批处理 使用范围：一次需要更新数据库表多条记录
	 * 优点：减少和SQL引擎交互的次数，再次提高效率,相似语句只编译一次，减少编译次数。提高了安全性（阻止了SQL注入） 缺点: 原理：批处理:
	 * 减少和SQL引擎交互的次数，一次传递给SQL引擎多条SQL。 名词解释：
	 * PL/SQL引擎：在oracle中执行pl/sql代码的引擎，在执行中发现标准的sql会交给sql引擎进行处理。
	 * SQL引擎：执行标准sql的引擎。 事例执行过程:
	 */
	public static void exec3(Connection conn) {
		try {
			conn.setAutoCommit(false);
			Long beginTime = System.currentTimeMillis();
			PreparedStatement pst = conn
					.prepareStatement("insert into t1(id) values (?)");

			for (int i = 1; i <= 10000; i++) {
				pst.setInt(1, i);
				pst.addBatch();// 加入批处理，进行打包
				if (i % 1000 == 0) {// 可以设置不同的大小；如50，100，500，1000等等
					pst.executeBatch();
					conn.commit();
					pst.clearBatch();
				}// end of if
			}// end of for
			pst.executeBatch();
			Long endTime = System.currentTimeMillis();
			System.out.println("pst+batch用时：" + (endTime - beginTime) + "毫秒");
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
}
