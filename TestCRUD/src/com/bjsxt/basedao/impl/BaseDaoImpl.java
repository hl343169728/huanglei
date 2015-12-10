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

public class BaseDaoImpl<Entity> implements BaseDao<Entity> {
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	protected Class clazz;
	//无参数的构造函数
	public BaseDaoImpl(){
		//this.getClass()ָ指：UserDaoImpl    this.getClass().getGenericSuperclass ：调用它的真正的父类
		//带用真实类型的参数的对象，取得的就是父类的引用
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		//System.out.println(pt);
		//获得真实类型的参数，传递过来什么就是什么，返回的是Type[]
		clazz = (Class)pt.getActualTypeArguments()[0];
		//System.out.println("----->"+clazz);
	}
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/**
	 * 保存方法
	 */
	public void save(Entity obj) throws Exception {
		//获取连接
		Connection conn = DBUtils.getConn();
		/**
		 * clazz.getSimpleName()  获取简单的名称，即表名
		 * String sql = " insert into " +clazz.getSimpleName()+ " values(null,?,?,?) ";
		 * System.out.println(sql);
		 * 注意：" values() " 前面要加空格
		 */
		String sql = "insert into " +clazz.getSimpleName()+ " values(null";
		//获取clazz类所声明的属性，去拼接sql语句
		Field[] fs = clazz.getDeclaredFields();
		//System.out.println(fs.length);// 得到真实的属性个数
		for(int i=1;i<fs.length;i++){//从1开始，因为id是自增的，不用处理
			sql += ",?"; 
		}
		sql += ")";
		//System.out.println(sql);//insert into user values(null,?,?,?);
		PreparedStatement ps = DBUtils.getState(conn, sql);
		//ps.setString(1,user.getName());  // id 、name、age、description
		for (int i = 1; i < fs.length; i++) {
			String methodName = "get" + Character.toUpperCase(fs[i].getName().charAt(0))+fs[i].getName().substring(1);
			//System.out.println(methodName);//getName   getAge    getDescription
			Method m = clazz.getMethod(methodName);
			ps.setObject(i,m.invoke(obj));
		}
		//执行操作
		ps.executeUpdate();
		//释放资源
		DBUtils.close(ps);
		DBUtils.close(conn);
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/**
	 *更新方法
	 */
	public void update(Entity obj) throws Exception {
		//获取连接
		Connection conn = DBUtils.getConn();
		/**
		 * 类似于：update user set name=?,age=?,description=? where id=?
		 */
		String sql = "update " +clazz.getSimpleName()+ " set ";
		//获取clazz 类所声明的属性去拼接sql语句
		Field[] fs = clazz.getDeclaredFields();
		//从1开始，不用处理id，因为id是自增的
		for (int i = 1; i < fs.length; i++) {
			sql += fs[i].getName() + "=?,";
		}
		//取出逗号，再拼接sql语句
		sql = sql.substring(0,sql.length()-1) + " where id=?";
		//System.out.println(sql);
		PreparedStatement ps = DBUtils.getState(conn, sql);
		for (int i = 1; i < fs.length; i++) {
			//ps.setInt(1,user.getAge());
			//利用反射
			String methodName = "get" + Character.toUpperCase(fs[i].getName().charAt(0))+fs[i].getName().substring(1);
			//System.out.println(methodName);//getName   getAge  getDescription
			Method m = clazz.getMethod(methodName);
			ps.setObject(i,m.invoke(obj));
		}
		//id已知
		Method m2 = clazz.getMethod("getId");
		ps.setObject(fs.length,m2.invoke(obj));
		//执行操作
		ps.executeUpdate();
		//释放资源
		DBUtils.close(ps);
		DBUtils.close(conn);
	}
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/**
	 * 删除方法:根据id删除指定的对象
	 */
	public void delete(int id) throws Exception {
		//获取连接
		Connection conn = DBUtils.getConn();
		/**
		 * 类似于：delete from user where id = 3;
		 */
		String sql = "delete from " +clazz.getSimpleName() +" where id=?";
		//System.out.println(sql);//sql语句：delete from user where id=?;
		PreparedStatement ps = DBUtils.getState(conn, sql);
		ps.setInt(1,id);
		//执行操作
		ps.executeUpdate();
		//释放资源
		DBUtils.close(ps);
		DBUtils.close(conn);
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/**
	 * 查询列表的所有记录
	 */
	public List<Entity> findAll() throws Exception {
		//获取数据库连接
		Connection conn = DBUtils.getConn();
		/**
		 * sql 语句类似于：select * from user;
		 */
		String sql = "select * from "+clazz.getSimpleName();
		//System.out.println(sql);//sql语句：select * from user ;
		PreparedStatement ps = DBUtils.getState(conn, sql);
		//执行操作
		ResultSet rs = ps.executeQuery();
		//用List集合来接受所有的表记录
		List<Entity> list = new ArrayList<Entity>();
		//获取clazz类所声明的属性
		Field[] fs = clazz.getDeclaredFields();
		//System.out.println(fs.length);
		while(rs.next()){
			//创建实例对象        类似于： User user = new User();
			Entity entity = (Entity) clazz.newInstance();
			for (int i = 0; i < fs.length; i++) {
				//user.setName(rs.getString("name"));
				String methodName = "set" +Character.toUpperCase(fs[i].getName().charAt(0))+fs[i].getName().substring(1);
				Method m = clazz.getMethod(methodName,fs[i].getType());
				m.invoke(entity, rs.getObject(fs[i].getName()));
			}
			//往集合中添加数据
			list.add(entity);
		}
		//释放资源
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		//返回list集合
		return list;
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/**
	 * 根据id查找指定的对象
	 */
	public Entity findById(int id) throws Exception {
		//获取连接
		Connection conn = DBUtils.getConn();
		/**
		 * 类似于：select * from user where id=2;
		 */
		String sql = "select * from "+clazz.getSimpleName()+" where id=?";
		//System.out.println(sql);//select * from user where id=?;
		PreparedStatement ps = DBUtils.getState(conn, sql);
		ps.setInt(1,id);
		//执行操作
		ResultSet rs = ps.executeQuery();
		//利用反射实例化一个对象
		Entity entity = (Entity) clazz.newInstance();
		Field[] fs = clazz.getDeclaredFields();
		if(rs.next()){
			for (int i = 0; i < fs.length; i++) {
				//类似于：user.setName(rs.getString("name"));
				//利用反射
				String methodName = "set" +Character.toUpperCase(fs[i].getName().charAt(0))+fs[i].getName().substring(1);
				Method m = clazz.getMethod(methodName,fs[i].getType());
				m.invoke(entity,rs.getObject(fs[i].getName()));
			}
		}
		//释放资源
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		//返回这个对象
		return entity;
	}
}
