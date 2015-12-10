package com.bjsxt.basedao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.basedao.BaseDao;
import com.bjsxt.utils.DBUtils;

public class BaseDaoImpl<Entity> implements BaseDao<Entity>{

	@SuppressWarnings("rawtypes")
	protected Class clazz ;
	
	@SuppressWarnings("rawtypes")
	public BaseDaoImpl(){
		
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz =  (Class) pt.getActualTypeArguments()[0];
	}
	
	/**
	 * 保存方法
	 */
	@SuppressWarnings("unchecked")
	public void save(Entity entity) throws Exception {
		
		Connection conn = DBUtils.getConn(); 
		String sql = "insert into " + clazz.getSimpleName() + " values(null";
		//获取clazz类所声明的属性 去 拼接sql语句
		Field[] fs = clazz.getDeclaredFields();
		//System.out.println(fs.length);
		for(int i = 1 ; i < fs.length; i ++){
			sql += ",?";
		}
		sql = sql + ")";
		//System.out.println(sql);
		PreparedStatement ps = DBUtils.getState(conn, sql);
		//ps.setString(1, user.getName());  // id name age descrition
		for(int i = 1 ; i < fs.length; i ++){
			String methodName = "get" + Character.toUpperCase(fs[i].getName().charAt(0)) + fs[i].getName().substring(1);
			Method m = clazz.getMethod(methodName);
			ps.setObject(i, m.invoke(entity));  
		}	
		ps.executeUpdate();
		DBUtils.close(ps);
		DBUtils.close(conn);
		
	} 

	/**
	 * 更新方法
	 */
	@SuppressWarnings("unchecked")
	public void update(Entity entity) throws Exception { 
		 Connection conn = DBUtils.getConn();
		 /**
		  * update user set name =? , age =? , description=? where id = ?
		  * 拼接sql语句
		  */
		 String sql = "update " + clazz.getSimpleName() + " set ";  //where id = ?
		 Field[] fs = clazz.getDeclaredFields();
		 for(int i = 1 ; i <fs.length ; i ++){
			 sql += fs[i].getName() + "=?,";
		 }
		 sql = sql.substring(0, sql.length()-1) + " where id =?";
		 //System.out.println(sql);
		 PreparedStatement ps = DBUtils.getState(conn, sql);
		 for(int i = 1 ; i < fs.length ; i++){ 
				String methodName = "get" + Character.toUpperCase(fs[i].getName().charAt(0)) + fs[i].getName().substring(1);
				Method m = clazz.getMethod(methodName);
				ps.setObject(i, m.invoke(entity));  			 
		 }
		 //getId
		 Method m2 = clazz.getMethod("getId");
		 ps.setObject(fs.length, m2.invoke(entity));
		 ps.executeUpdate();
		 DBUtils.close(ps);
		 DBUtils.close(conn);
		 
		 
	}
	
	/**
	 * 删除方法
	 */
	public void delete(int id) throws Exception {
		Connection conn = DBUtils.getConn();
		String sql = "delete from " + clazz.getSimpleName() + " where id = ?";
		PreparedStatement ps = DBUtils.getState(conn, sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		DBUtils.close(ps);
		DBUtils.close(conn);	
		
	}

	/**
	 * 查询列表所有记录
	 */
	@SuppressWarnings("unchecked")
	public List<Entity> findAll() throws Exception {
		
		Connection conn = DBUtils.getConn();
		String sql = "select * from " + clazz.getSimpleName();
		PreparedStatement ps = DBUtils.getState(conn, sql);
		ResultSet rs = ps.executeQuery();
		
		List<Entity> list = new ArrayList<Entity>();
		Field[] fs = clazz.getDeclaredFields();
		
		
		while(rs.next()){
			//创建实例对象 User u = new User();
			Entity entity = (Entity) clazz.newInstance();
			for(int i = 0 ; i < fs.length ; i ++) {
				//User u = new User();
				//u.setName(rs.getString("name"));
				String methodName = "set" + Character.toUpperCase(fs[i].getName().charAt(0)) + fs[i].getName().substring(1);
				//System.out.println(methodName); 
				Method m = clazz.getMethod(methodName, fs[i].getType());
				//u.setAge(rs.getInt("age"));
				m.invoke(entity, rs.getObject(fs[i].getName()));
			}
			list.add(entity);
		}

		return list;
	}

	
	/**
	 * 根据id 查询指定对象
	 */
	@SuppressWarnings("unchecked")
	public Entity findById(int id) throws Exception {
		
		Connection conn = DBUtils.getConn();
		String sql = "select * from "  + clazz.getSimpleName() + " where id = ?"; 
		PreparedStatement ps = DBUtils.getState(conn, sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Entity entity = (Entity)clazz.newInstance();
		
		Field[] fs = clazz.getDeclaredFields();
		if(rs.next()){
			// user.setId(rs.getInt("id"));
			for (int i = 0; i < fs.length; i++) {
				String methodName = "set" + Character.toUpperCase(fs[i].getName().charAt(0)) + fs[i].getName().substring(1);
				Method m = clazz.getMethod(methodName, fs[i].getType());
				m.invoke(entity, rs.getObject(fs[i].getName()));
			}
		}
		
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return entity;
	}

}
