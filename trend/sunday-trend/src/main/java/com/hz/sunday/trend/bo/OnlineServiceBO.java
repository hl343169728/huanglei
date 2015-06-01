package com.hz.sunday.trend.bo;

import java.util.List;
import java.util.Map;

import org.javafans.dto.page.Page;
import org.javafans.dto.page.PageQuery;
import org.javafans.dto.page.PageQueryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.sunday.trend.dao.OnlineServiceMapper;
import com.hz.sunday.trend.orm.OnlineService;

/**
 * 在线客服管理
 * 
 * @author huanglei
 */
@Service
@Transactional
public class OnlineServiceBO {

	@Autowired
	private OnlineServiceMapper onlineServiceMapper;

	/**
	 * 分页查询数据
	 */
	public Page<OnlineService> pageQuery(Page<OnlineService> page,
			final Map<String, Object> queryMap) {
		return PageQueryUtils.pageQuery(page, queryMap,
				new PageQuery<OnlineService>() {

					@Override
					public long count() {
						return onlineServiceMapper.count(queryMap);
					}

					@Override
					public List<OnlineService> list() {
						return onlineServiceMapper.list(queryMap);
					}

				});
	}

	/**
	 * 新增
	 * 
	 * @param messageInfo
	 */
	public void insert(OnlineService onlineService) {
		onlineServiceMapper.insert(onlineService);
	}

	/**
	 * 更新
	 * 
	 * @param messageInfo
	 */
	public void update(OnlineService onlineService) {
		onlineServiceMapper.update(onlineService);
	}

	/**
	 * 获取分页数据
	 * 
	 * @param sqlMap
	 * @return
	 */
	public List<OnlineService> list(Map<String, Object> sqlMap) {
		return onlineServiceMapper.list(sqlMap);
	}

	/**
	 * 获取记录总数
	 * 
	 * @param sqlMap
	 * @return
	 */
	public Long count(Map<String, Object> sqlMap) {
		return onlineServiceMapper.count(sqlMap);
	}

	/**
	 * 根据ID，获取信息
	 * 
	 * @param id
	 * @return
	 */
	public OnlineService getById(Long id) {
		return onlineServiceMapper.getById(id);
	}

	/**
	 * 根据ID，删除
	 * 
	 * @param id
	 */
	public void deleteById(Long id) {
		onlineServiceMapper.deleteById(id);
	}
}
