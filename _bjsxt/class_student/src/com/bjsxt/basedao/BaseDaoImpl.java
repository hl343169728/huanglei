package com.bjsxt.basedao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.utils.DBUtils;

/**
 * 本类用于实现baseDao中的公共接口CRUD方法
 */
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {
	/**
	 * 公共Class类全限命名对象
	 */
	@SuppressWarnings("rawtypes")
	protected Class clazz ;	
	
	@SuppressWarnings("rawtypes")
	public BaseDaoImpl(){
		/**
		 * 带有真实类型参数的返回值对象
		 */
		ParameterizedType pt =(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) pt.getActualTypeArguments()[0];
	}	
	
	/**
	 * reflect实现公共保存方法
	 */
	public void save(T obj) throws Exception {
		Connection conn = DBUtils.createConn();	
		String sql = "insert into " + clazz.getSimpleName() + " values(null";
		Field[] fs =clazz.getDeclaredFields();  
		for(int i = 1 ; i < fs.length;i++){
			sql += ",? ";
		}
		sql += ")";
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		for(int i = 1 ; i < fs.length;i++){
			String methodName = "get" +fs[i].getName().substring(0, 1).toUpperCase()+fs[i].getName().substring(1) ;
			//System.out.println(methodName);  
			Method m = clazz.getMethod(methodName);
			ps.setObject(i, m.invoke(obj));						
		}
		ps.executeUpdate();
		DBUtils.close(ps);
		DBUtils.close(conn);		
	}
	
	/**
	 * reflect实现公共修改方法
	 */
	public void update(T obj)  throws Exception {
		
		Connection conn = DBUtils.createConn();	
		String sql = "update " + clazz.getSimpleName() + " set ";
		Field[] fs = clazz.getDeclaredFields();
		for(int i =1 ; i < fs.length;i++){
			String fieldName = fs[i].getName();
			if(i == fs.length - 1){
				sql += fieldName + "=?";
			} else {
				sql += fieldName + "=?, ";
			}
		}		
		Method m = clazz.getMethod("getId");
		sql += " where id=" + (Integer)m.invoke(obj);
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		for(int i = 1 ; i<fs.length;i++){
			String fieldName = fs[i].getName();
			String methodName = "get" + fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
			Method m2 = clazz.getMethod(methodName);
			ps.setObject(i, m2.invoke(obj));
		}
		ps.executeUpdate();
		DBUtils.close(ps);
		DBUtils.close(conn);
	}	
	
	/**
	 * reflect实现公共删除方法
	 */
	public void delete(int id) throws Exception {

		Connection conn = DBUtils.createConn();
		String sql = "delete from " + clazz.getSimpleName() + " where id=?" ;
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		DBUtils.close(ps);
		DBUtils.close(conn);
	}
	
	/**
	 * reflect实现公共根据id查询对象方法
	 */
	public T findById(int id)  throws Exception {

		Connection conn = DBUtils.createConn();	
		String sql = "select * from " +clazz.getSimpleName() + " where id =" + id;	
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ResultSet rs = ps.executeQuery();
		
		Field[] fs = clazz.getDeclaredFields();		
		Object obj = clazz.getConstructor().newInstance();	
		if(rs.next()){
			for(int i = 0 ; i <fs.length;i++ ){
				String methodName = "set" +fs[i].getName().substring(0, 1).toUpperCase()+fs[i].getName().substring(1);
				Method m2 = clazz.getMethod(methodName, fs[i].getType());			
				Object value = rs.getObject(fs[i].getName());  
				m2.invoke(obj, value); 		
			}
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return (T) obj;
	}
	
	/**
	 * reflect实现公共查询所有方法
	 */
	@SuppressWarnings("rawtypes")
	public List<T> findAll()  throws Exception {
		Connection conn = DBUtils.createConn();	
		String sql = "select * from " +clazz.getSimpleName();
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ResultSet rs = ps.executeQuery();
		Field[] fs = clazz.getDeclaredFields();
		List list =new ArrayList();
		
		
		while(rs.next()){
			Object obj = clazz.getConstructor().newInstance();
			for(int i = 0 ; i <fs.length;i++ ){
				String methodName = "set" +fs[i].getName().substring(0, 1).toUpperCase()+fs[i].getName().substring(1);
				Method m = clazz.getMethod(methodName, fs[i].getType());			
				Object value = rs.getObject(fs[i].getName());  
				m.invoke(obj, value); 
			}
			list.add(obj);
		}

		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);	
		return list;
	}
	
	/**
	 * 条件查询的反射封装方法
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public  List<T> queryListForParams(String sql,Object[] params ) throws Exception{
		Connection conn  = DBUtils.createConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			// 建立statement对象(封装了sql)
			ps = conn.prepareStatement(sql); // select * from org where id = ? and name = ?  [1 , z3]
			if(params!=null){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			Field[] fs = clazz.getDeclaredFields();
			rs = ps.executeQuery();
			while(rs.next()){
				Object obj = clazz.getConstructor().newInstance();
				for(int i = 0 ; i <fs.length;i++ ){
					String methodName = "set" +fs[i].getName().substring(0, 1).toUpperCase()+fs[i].getName().substring(1);
					Method m = clazz.getMethod(methodName, fs[i].getType());			
					Object value = rs.getObject(fs[i].getName());  
					m.invoke(obj, value); 
				}
				list.add(obj);
			}				

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(rs);
			DBUtils.close(ps);
			DBUtils.close(conn);
		}
		return list;
	}	
	
	/**
	 * 查询1张表总记录数 
	 * @return
	 * @throws Exception
	 */
	public int getTotal() throws Exception {
		Connection conn  = DBUtils.createConn();
		String sql =" select count(*) from " + clazz.getSimpleName() ;
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ResultSet rs = ps.executeQuery();
		int total = 0 ;
		if(rs.next()){
			total = rs.getInt(1);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return total;
	}

}
