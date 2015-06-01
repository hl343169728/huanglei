package com.hz.yisheng.demo.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 
 * @Description JDBC事务
 * @author huanglei
 * @date 2015-2-9 下午3:10:05
 * @version 1.0
 * 
 */
public class JDBCTransaction {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		Statement st = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			// 开始事务
			conn.setAutoCommit(false);
			st = conn.createStatement();
			st.executeUpdate("UPDATE `hib_course` SET NAME='自然与科学' WHERE ID=1 ");
			// 事务提交
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// 注意有异常必须得回滚，否则执行成功的sql会持久化到数据库中
			conn.rollback();
		} finally {// 记得释放资源
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
}
