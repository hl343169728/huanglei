package com.bjsxt.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

	private static Properties props = new Properties();
	/**
	 * 静态代码块，在类被加载的时候执行
	 */
	static {
		InputStream is = null ; 
		is = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			props.load(is);		//load 一个流
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 获得数据库连接
	 * @return
	 */
	public static Connection createConn(){
		Connection conn = null ;
		try {
			Class.forName(props.getProperty("driver"));
			conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 操纵SQL语句
	 * @param conn
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getStat(Connection conn , String sql){
		PreparedStatement ps = null;
		try {
			 ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	/**
	 * 释放资源
	 * @param conn
	 */
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	/**
	 * 释放资源
	 * @param ps
	 */
	public static void close(PreparedStatement ps){
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	/**
	 * 释放资源
	 * @param rs
	 */
	public static void close(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	
}
