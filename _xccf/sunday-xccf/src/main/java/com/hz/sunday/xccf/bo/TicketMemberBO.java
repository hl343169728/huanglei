package com.hz.sunday.xccf.bo;

import java.util.List;
import java.util.Map;

import org.javafans.dto.page.Page;
import org.javafans.dto.page.PageQuery;
import org.javafans.dto.page.PageQueryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hz.sunday.xccf.dao.TicketMemberMapper;
import com.hz.sunday.xccf.orm.TicketMemberBean;

/**
 * 报名管理
 * 
 * @author huanglei
 * @date 2015年4月14日
 * @version V1.0
 */
@Service
public class TicketMemberBO {

	@Autowired
	private TicketMemberMapper ticketMemberMapper;

	/**
	 * 分页查询数据
	 */
	public Page<TicketMemberBean> pageQuery(Page<TicketMemberBean> page,
			final Map<String, Object> queryMap) {
		return PageQueryUtils.pageQuery(page, queryMap,
				new PageQuery<TicketMemberBean>() {

					@Override
					public long count() {
						return ticketMemberMapper.findCount(queryMap);
					}

					@Override
					public List<TicketMemberBean> list() {
						return ticketMemberMapper.findAll(queryMap);
					}

				});
	}

	/**
	 * 新增报名信息
	 * 
	 * @param ticket
	 */
	public void insert(TicketMemberBean ticket) {
		ticketMemberMapper.insert(ticket);
	}

	/**
	 * 根据ID，删除
	 * 
	 * @param id
	 */
	public void deleteById(Long id) {
		ticketMemberMapper.deleteById(id);
	}

	/**
	 * 判断手机号是否存在
	 * 
	 * @param phone
	 * @return
	 */
	public boolean isExist(String phone) {
		Map<String, Object> param = Maps.newHashMapWithExpectedSize(1);
		param.put("phone", phone);
		List<TicketMemberBean> list = ticketMemberMapper.findAll(param);
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

}
