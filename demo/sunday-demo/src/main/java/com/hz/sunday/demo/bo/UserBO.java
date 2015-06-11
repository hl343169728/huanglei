package com.hz.sunday.demo.bo;

import java.util.List;
import java.util.Map;

import org.javafans.dto.page.Page;
import org.javafans.dto.page.PageQuery;
import org.javafans.dto.page.PageQueryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.sunday.demo.dao.UserMapper;
import com.hz.sunday.demo.entity.User;

/**
 * 用户信息管理BO
 * 
 * @author huanglei
 */
@Service
@Transactional
public class UserBO {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 分页查询数据
	 */
	public Page<User> pageQuery(Page<User> page, final Map<String, Object> queryMap) {
		return PageQueryUtils.pageQuery(page, queryMap, new PageQuery<User>() {

			@Override
			public long count() {
				return userMapper.findCount(queryMap);
			}

			@Override
			public List<User> list() {
				return userMapper.findAll(queryMap);
			}

		});
	}

	/**
	 * 获取信息列表
	 */
	public List<User> findAll(Map<String, Object> queryParam) {
		return userMapper.findAll(queryParam);
	}

	/**
	 * 获取信息总数
	 */
	public Long findCount(Map<String, Object> queryParam) {
		return userMapper.findCount(queryParam);
	}

	/**
	 * 根据ID，获取客户信息
	 */
	public User findById(Long id) {
		return userMapper.findById(id);
	}

	/**
	 * 新增信息
	 * 
	 * @param customer
	 */
	public void insert(User user) {
		userMapper.insert(user);
	}

	/**
	 * 更新信息
	 * 
	 * @param customer
	 */
	public void update(User user) {
		userMapper.update(user);

	}

	/**
	 * 根据ID，删除信息
	 * 
	 * @param id
	 */
	public void deleteById(Long id) {
		userMapper.deleteById(id);
	}

	/**
	 * 批量获取信息
	 * 
	 * @param ids
	 * @return
	 */
	public List<User> getUserByIds(List<Long> ids) {
		return userMapper.getUserByIds(ids);
	}

	/**
	 * 取消附件
	 * 
	 * @param id
	 */
	public void cancel(Long id) {
		User user = userMapper.findById(id);
		user.setLogo(null);
		userMapper.cancel(user);
	}

}
