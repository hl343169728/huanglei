package com.hz.sunday.trend.bo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.sunday.trend.TrendConstants;
import com.hz.sunday.trend.dao.InformationMapper;
import com.hz.sunday.trend.orm.Information;
import com.hz.yisheng.commondata.bo.AttachementBO;
import com.hz.yisheng.commondata.orm.Attachement;

/**
 * 相关信息发布管理
 * 
 * @author huanglei
 */
@Service
@Transactional
public class InformationBO {
	
	@Autowired
	private InformationMapper informationMapper;
	@Autowired
	private AttachementBO attachementBO;

	/**
	 * 新增
	 * 
	 * @param MessageNotice
	 */
	public void insert(Information info) {
		informationMapper.insert(info);
	}

	/**
	 * 编辑
	 * 
	 * @param MessageNotice
	 */
	public void update(Information info) {
		informationMapper.update(info);
	}

	/**
	 * 根id，删除一条信息
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		informationMapper.delete(id);
	}

	/**
	 * 根据条件查询符合条件的信息条数
	 * 
	 * @param param
	 * @return
	 */
	public Long getCount(Map<String, Object> param) {
		return informationMapper.getCount(param);
	}

	/**
	 * 根据条件，查询符合条件的信息，返回的是一个集合
	 * 
	 * @param param
	 * @return
	 */
	public List<Information> getList(Map<String, Object> param) {
		List<Information> list = informationMapper.getList(param);
		int mType = (Integer) param.get("mType");
		if(mType == TrendConstants.SHOP_TYPE || mType == TrendConstants.PRODUCT_TYPE 
				|| mType == TrendConstants.CONTACT_TYPE || mType == TrendConstants.BRAND_TYPE 
				|| mType == TrendConstants.FIRST_LOGO || mType == TrendConstants.SECOND_LOGO 
				|| mType == TrendConstants.FOOTER_LOGO) {
			// 店面形象、产品中心、联系我们、知名品牌、首页LOGO、次级页面LOGO、网站底部LOGO
			if (null != list && list.size() > 0) {
				for (Information info : list) {
					info.setAttList(attachementBO.findBy(String.valueOf(info.getId()), TrendConstants.MSG_TYPE + mType));
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
	public Information getSingleDetail(Long id) {
		return informationMapper.getSingleDetail(id);
	}

	/**
	 * 根据信息类型获取
	 * 
	 * @param mtype
	 * @return
	 */
	public List<Information> getByMtype(int mtype) {
		List<Information> list = informationMapper.getByMtype(mtype);
		// 加载新闻的标题图片 只限一张 并且是最后一张
		for (Information mn : list) {
			String mtypeFile = TrendConstants.MSG_TYPE + mn.getmType();
			List<Attachement> attachList = attachementBO.findBy(String.valueOf(mn.getId()), mtypeFile);
			if (attachList != null && attachList.size() > 0) {
				mn.setFilePath(attachList.get(attachList.size() - 1).getPath());
			}
		}
		return list;
	}
}
