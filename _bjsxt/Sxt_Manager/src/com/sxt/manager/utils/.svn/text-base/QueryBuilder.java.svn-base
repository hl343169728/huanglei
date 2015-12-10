package com.sxt.manager.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 本类是SQL语句工具生成类
 * @author oiYc_
 *
 */
public class QueryBuilder {

	/**
	 * 	子句字段属性
	 */
	private String fromClause ; 		
	private String whereClause ; 		
	private Class entityClass;
	private List<Object> parameters = new ArrayList<Object>();
	
	/**
	 * 生成	FROM 子句
	 * @param entityClass
	 */
	public QueryBuilder(Class entityClass){
		this.entityClass = entityClass;
		fromClause = "SELECT * FROM " + entityClass.getSimpleName();	// select * from employee
	}
	
	/**
	 * 添加 WHERE 条件约束
	 * @param condition 对应字段
	 * @param params	可变参数
	 */
	public QueryBuilder addWhereCondition(String condition , Object... params){
		
		/**
		 *  拼接where对应字段
		 */
		if( whereClause == null ) {
			whereClause = " WHERE " + condition + "=?" ; 
		} else {
			whereClause += " AND " + condition + "=?" ;	
		}
		/**
		 *  保存参数
		 */
		if( params != null && params.length > 0) {		

			for(Object obj : params){
				parameters.add(obj);				
			}
		}
		return this;
	}
	

	
	/**
	 * 生成 SQL 查询总记录数语句 
	 * @return
	 */
	public String toQueryCountSql() {
		StringBuffer sql = new StringBuffer() ;
		sql.append("SELECT COUNT(*) FROM " + entityClass.getSimpleName());		
		addClauseIfNotNull(sql , whereClause);	// 
		return sql.toString();
	}
	
	/**
	 * 生成 SQL 查询当前页List数据集合语句
	 * @return
	 */
	public String toQueryListSql(){
		
		StringBuffer sql = new StringBuffer() ;
		System.out.println(sql);
		sql.append("SELECT * FROM " + entityClass.getSimpleName());	
		addClauseIfNotNull(sql , whereClause);
		return sql.toString();
	}
	
	/**
	 * 第一次判断拼接语句
	 * @param clause
	 * @param hql
	 */
	private void addClauseIfNotNull( StringBuffer sql ,String clause ) {
		
		if(clause != null) {
			sql.append(clause).append(" ");
		}
	}
	
	/**
	 * 查询总记录数
	 * @param session
	 * @return 
	 * @throws SQLException 
	 */

	public int queryCount() throws SQLException {
		
		Connection conn = DBUtils.createConn();
		String sql = this.toQueryCountSql();//select count(*) from employee where state = ? and sex = ?
		System.out.println(sql);
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		for(int i = 0 ; i < parameters.size() ; i++) {
			ps.setObject(i+1, parameters.get(i));
		}
		ResultSet rs = ps.executeQuery();
		int count = 0;
		if(rs.next()){
			count = rs.getInt(1);
		}		
		return count;
	}

	
	/**
	 * 查询指定页的数据
	 * @param session
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws IllegalArgumentException 
	 */
	
	@SuppressWarnings("unchecked")
	public List queryList(int currentPage , int pageSize) throws SQLException, IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		Connection conn = DBUtils.createConn();
		String sql = this.toQueryListSql() + " limit " + (currentPage-1)*pageSize+ " , " + pageSize;
		//System.out.println(sql);
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		for(int i = 0 ; i < parameters.size() ; i++) {
			ps.setObject(i+1, parameters.get(i));
		}
		ResultSet rs = ps.executeQuery();
		List  list = new ArrayList();
		Field[] fs = entityClass.getDeclaredFields();
		while(rs.next()){
			Object obj = entityClass.getConstructor().newInstance();
			for(int i = 0 ; i <fs.length;i++ ){
				String methodName = "set" +fs[i].getName().substring(0, 1).toUpperCase()+fs[i].getName().substring(1);
				Method m = entityClass.getMethod(methodName, fs[i].getType());			
				Object value = rs.getObject(fs[i].getName());  
				m.invoke(obj, value); 
			}
			list.add(obj);
		}
		return list;
	}
	
	
	
}
