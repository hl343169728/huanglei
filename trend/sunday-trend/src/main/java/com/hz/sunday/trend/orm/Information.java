package com.hz.sunday.trend.orm;

import java.util.Date;
import java.util.List;

import org.javafans.orm.entity.base.BaseAdminEntity;

import com.hz.yisheng.commondata.orm.Attachement;

/**
 * 信息相关资料表
 * 
 * @author huanglei
 */
public class Information extends BaseAdminEntity {

	private static final long serialVersionUID = 1L;

	private String title;// 标题
	private String subhead;// 副标题
	private String summary;// 摘要
	private String comment;// 内容
	private int mType;// 信息类型 （1：公司介绍；2：新闻动态；3：店面形象；4：潮之邦； 5：产品中心；6:项目介绍；7:投资方案； 8:联系我们）
	private String filePath;// 文件路径
	private String reource;// 来源
	private Date actionTime;// 活动时间
	private String actionTime2;// 活动时间2
	private String actionAddr;// 活动地址
	private String description;// 描述
	private String field1;// 备用字段
	private String field2;// 备用字段
	private String field3;// 备用字段
	private String field4;// 备用字段

	private String phone;// 公司电话
	private List<Attachement> attList;// 附件表信息

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubhead() {
		return subhead;
	}

	public void setSubhead(String subhead) {
		this.subhead = subhead;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getmType() {
		return mType;
	}

	public void setmType(int mType) {
		this.mType = mType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getReource() {
		return reource;
	}

	public void setReource(String reource) {
		this.reource = reource;
	}

	public Date getActionTime() {
		return actionTime;
	}

	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}

	public String getActionTime2() {
		return actionTime2;
	}

	public void setActionTime2(String actionTime2) {
		this.actionTime2 = actionTime2;
	}

	public String getActionAddr() {
		return actionAddr;
	}

	public void setActionAddr(String actionAddr) {
		this.actionAddr = actionAddr;
	}

	public List<Attachement> getAttList() {
		return attList;
	}

	public void setAttList(List<Attachement> attList) {
		this.attList = attList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

}
