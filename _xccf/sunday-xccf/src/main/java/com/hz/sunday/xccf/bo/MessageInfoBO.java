package com.hz.sunday.xccf.bo;

import java.util.List;
import java.util.Map;

import org.javafans.common.utils.time.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.hz.sunday.xccf.constants.ColumnType;
import com.hz.sunday.xccf.dao.MessageInfoMapper;
import com.hz.sunday.xccf.orm.MessageInfo;
import com.hz.yisheng.commondata.bo.AttachementBO;
import com.hz.yisheng.commondata.orm.Attachement;

/**
 * 信息管理
 * 
 * @author huanglei
 * @date 2015年4月24日 下午9:45:45
 * @version V1.0
 */
@Service
@Transactional
public class MessageInfoBO {

	@Autowired
	private MessageInfoMapper messageInfoMapper;
	@Autowired
	private AttachementBO attachementBO;

	/**
	 * 新增
	 * 
	 * @param MessageNotice
	 */
	public void insert(MessageInfo messageNotice) {
		messageInfoMapper.insert(messageNotice);
	}

	/**
	 * 编辑
	 * 
	 * @param MessageNotice
	 */
	public void update(MessageInfo messageNotice) {
		messageInfoMapper.update(messageNotice);
	}

	/**
	 * 根id，删除一条信息
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		messageInfoMapper.delete(id);
	}

	/**
	 * 根据条件查询符合条件的信息条数
	 * 
	 * @param param
	 * @return
	 */
	public Long getCount(Map<String, Object> param) {
		return messageInfoMapper.getCount(param);
	}

	/**
	 * 根据条件，查询符合条件的信息，返回的是一个集合
	 * 
	 * @param param
	 * @return
	 */
	public List<MessageInfo> getList(Map<String, Object> param) {
		List<MessageInfo> list = messageInfoMapper.getList(param);
		int mType = (Integer) param.get("mtype");
		if (mType == ColumnType.PROGRAM_TYPE) {// 论坛日程
			if (null != list && list.size() > 0) {
				for (MessageInfo info : list) {
					int month = TimeUtils.getMonth(info.getActionTime());
					int day = TimeUtils.getDay(info.getActionTime());
					info.setSchedule(month + "月" + day + "日" + "	" + TimeUtils.getWeekOfDate(info.getActionTime()));
				}
			}
		} else if(mType == ColumnType.NEWS_TYPE || mType == ColumnType.LEADER_TYPE || mType == ColumnType.GUEST_TYPE || 
				mType == ColumnType.TURN_IMAGE || mType == ColumnType.ORGANIGER_TYPE || mType == ColumnType.DOWN_TURN_IMAGE || 
				mType == ColumnType.ADVERT_IMAGE || mType == ColumnType.STRUCTURE_TYPE || mType == ColumnType.COOPERATION_TYPE || 
				mType == ColumnType.UP_ADVERT_IMAGE) {
			// 新闻中心、顶尖领导团、拟邀请嘉宾、顶部轮番图片、总策划人、底部轮播图片、广告位、组织机构、合作媒体
			if (null != list && list.size() > 0) {
				for (MessageInfo info : list) {
					info.setAttList(attachementBO.findBy(String.valueOf(info.getId()), "messnoti" + mType));
				}
			}
		} 
		return list;
	}

	/**
	 * 根户id，获取一条详情
	 * 
	 * @param id
	 * @return
	 */
	public MessageInfo getSingleDetail(Long id) {
		return messageInfoMapper.getSingleDetail(id);
	}

	/**
	 * 根据信息类型获取
	 * 
	 * @param mtype
	 * @return
	 */
	public List<MessageInfo> getByMtype(int mtype) {
		List<MessageInfo> list = messageInfoMapper.getByMtype(mtype);
		// 加载新闻的标题图片 只限一张 并且是最后一张
		for (MessageInfo mn : list) {
			String mtypeFile = "messnoti" + mn.getMtype();
			List<Attachement> attachList = attachementBO.findBy(
					String.valueOf(mn.getId()), mtypeFile);
			if (attachList != null && attachList.size() > 0) {
				mn.setFilePath(attachList.get(attachList.size() - 1).getPath());
			}
		}
		return list;
	}

	/**
	 * 根据信息类型，取一定条数的信息
	 * 
	 * @param mtype
	 * @param limit
	 * @return
	 */
	public List<MessageInfo> getByMtypeLimit(int mtype, int limit) {
		Map<String, Object> param = Maps.newHashMapWithExpectedSize(3);
		param.put("mtype", mtype);
		param.put("rowStart", 0);
		param.put("pageSize", limit);
		List<MessageInfo> list = getList(param);
		// 加载新闻的标题图片 只限一张 并且是最后一张
		for (MessageInfo mn : list) {
			String mtypeFile = "messnoti" + mn.getMtype();
			List<Attachement> attachList = attachementBO.findBy(
					String.valueOf(mn.getId()), mtypeFile);
			if (attachList != null && attachList.size() > 0) {
				mn.setFilePath(attachList.get(attachList.size() - 1).getPath());
			}
		}
		return list;
	}

}
