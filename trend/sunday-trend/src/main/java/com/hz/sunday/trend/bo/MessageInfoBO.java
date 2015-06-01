package com.hz.sunday.trend.bo;

import java.util.List;
import java.util.Map;

import org.javafans.dto.page.Page;
import org.javafans.dto.page.PageQuery;
import org.javafans.dto.page.PageQueryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.sunday.trend.dao.MessageInfoMapper;
import com.hz.sunday.trend.orm.MessageInfo;

/**
 * 在线留言管理
 * 
 * @author huanglei
 */
@Service
@Transactional
public class MessageInfoBO {

	@Autowired
	private MessageInfoMapper messageInfoMapper;

	/**
	 * 分页查询数据
	 */
	public Page<MessageInfo> pageQuery(Page<MessageInfo> page,
			final Map<String, Object> queryMap) {
		return PageQueryUtils.pageQuery(page, queryMap,
				new PageQuery<MessageInfo>() {

					@Override
					public long count() {
						return messageInfoMapper.count(queryMap);
					}

					@Override
					public List<MessageInfo> list() {
						return messageInfoMapper.list(queryMap);
					}

				});
	}

	/**
	 * 新增
	 * 
	 * @param messageInfo
	 */
	public void insert(MessageInfo messageInfo) {
		messageInfoMapper.insert(messageInfo);
	}

	/**
	 * 更新
	 * 
	 * @param messageInfo
	 */
	public void update(MessageInfo messageInfo) {
		messageInfoMapper.update(messageInfo);
	}

	/**
	 * 获取分页数据
	 * 
	 * @param sqlMap
	 * @return
	 */
	public List<MessageInfo> list(Map<String, Object> sqlMap) {
		return messageInfoMapper.list(sqlMap);
	}

	/**
	 * 获取记录总数
	 * 
	 * @param sqlMap
	 * @return
	 */
	public Long count(Map<String, Object> sqlMap) {
		return messageInfoMapper.count(sqlMap);
	}

	/**
	 * 根据ID，获取信息
	 * 
	 * @param id
	 * @return
	 */
	public MessageInfo getById(Long id) {
		return messageInfoMapper.getById(id);
	}

	/**
	 * 根据ID，删除
	 * 
	 * @param id
	 */
	public void deleteById(Long id) {
		messageInfoMapper.deleteById(id);
	}
}
