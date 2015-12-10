package com.sxt.manager.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;

import com.sxt.manager.model.Employee;
import com.sxt.manager.model.User;

public class QueryHelper {
	
	/**
	 *  key : tableName  
	 *  value : 关联字段 
	 */
	private Map<Class , Object> tableNames = new HashMap<Class, Object>() ;
	private LinkedHashSet<String> parameters = new LinkedHashSet<String>();
	private boolean notSingle ;			// false
	private boolean hasParam ;			// false
	




	/**
	 * @return the tableNames
	 */
	public Map<Class, Object> getTableNames() {
		return tableNames;
	}

	/**
	 * @param tableNames the tableNames to set
	 */
	public void setTableNames(Map<Class, Object> tableNames) {
		this.tableNames = tableNames;
	}

	/**
	 * @return the parameters
	 */
	public LinkedHashSet<String> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(LinkedHashSet<String> parameters) {
		this.parameters = parameters;
	}

	/**
	 * @return the notSingle
	 */
	public boolean isNotSingle() {
		return notSingle;
	}

	/**
	 * @param notSingle the notSingle to set
	 */
	public void setNotSingle(boolean notSingle) {
		this.notSingle = notSingle;
	}

	/**
	 * @return the hasParam
	 */
	public boolean isHasParam() {
		return hasParam;
	}

	/**
	 * @param hasParam the hasParam to set
	 */
	public void setHasParam(boolean hasParam) {
		this.hasParam = hasParam;
	}



	

	/**
	 * 分页公共的方法
	 * @param currentPage
	 * @param pageSize
	 * @param qh
	 * @return
	 * @throws Exception
	 */
	
	/*
	public List<Map> queryPage(String currentPage , String pageSize , QueryHelper qh) throws Exception{
		Connection conn = DBUtils.createConn();
		
		// 第一步 拼 tableName  
		String sql = "select * from ";
		Set<Class> set =  qh.getTableNames().keySet();
		
		List fieldList = new ArrayList();		// 获得Class的所有属性
		
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Class clazz = (Class) iterator.next();
			Field[] fs = clazz.getDeclaredFields();  
			fieldList.add(fs);
			sql += clazz.getSimpleName() + ",";
		}
		//判断到底需不需要参数
		if(qh.isNo_param()){
			sql = sql.substring(0, sql.length()-1);
		} else {
			sql = sql.substring(0, sql.length()-1) + " where ";
		}
		
		System.out.println(sql);
		
		
		Collection<Object> linkSet =  qh.getTableNames().values();
		for (Iterator iterator = linkSet.iterator(); iterator.hasNext();) {
			String value = (String) iterator.next();
			sql += value + "=" ; 
		}
		sql = sql.substring(0, sql.length()-1);
		System.out.println(sql);
		
		//sql += " and " + 
		for (Iterator iterator = qh.getParameters().iterator(); iterator.hasNext();) {
			String param = (String) iterator.next();
			if(qh.isSingle_table()){
				sql += " " + param ;
				qh.setSingle_table(false);
			} else {
				sql += " and " + param ;
			}
		}
		
		System.out.println(sql);
		sql += " limit " + (Integer.parseInt(currentPage)-1)*Integer.parseInt(pageSize) + " , " + pageSize ;
		System.out.println(sql);
		
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ResultSet rs = ps.executeQuery();
		
		List<Map> resultList = new ArrayList();
		while(rs.next()){
				Map map = new HashMap();
				for(int j = 0 ; j < fieldList.size(); j++){
						Field[] temp = (Field[])fieldList.get(j);
						for(int k = 0 ; k < temp.length; k ++) {
							map.put(temp[k].getName(), rs.getObject(temp[k].getName()));
						}
				}
				resultList.add(map);
		}
		return resultList;
	}
	
	*/


	/*
	public static void main(String[] args) throws Exception {
		String currentPage = "1" ;
		String pageSize = "10" ;
		QueryHelper qh = new QueryHelper();
		qh.single_table = true ;
		qh.tableNames.put(Employee.class, "");
		qh.parameters.add("employee.sex=2");
		List<Map> list1 = qh.query(currentPage, pageSize, qh);
		//qh.parameters.add("user.name='张三'");
		//qh.query(currentPage, pageSize, qh);
		System.out.println(list1.size());
		System.out.println(JSONArray.fromObject(list1).toString());
		QueryHelper qh = new QueryHelper();
		qh.single_table = false ;
		qh.tableNames.put(User.class, "user.empid");
		qh.tableNames.put(Employee.class, "employee.id");
		qh.parameters.add("employee.address='北京'");
		qh.parameters.add("user.createTime='2012-08-17'");
		List<Map> list2 = qh.queryPage(currentPage, pageSize, qh);
		System.out.println(list2.size());
		System.out.println(JSONArray.fromObject(list2).toString());		
	}*/
}
