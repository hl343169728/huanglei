package com.sxt.manager.model;

public class Student {
	private int id;
	private String sname;			//学员姓名
	private String qq;				//学员QQ
	private String phone;			//学员电话
	private String university;		//毕业院校
	private String department;		//专业
	private String grade;			//年级
	private String diploma; 		//学历
	private String state;  			//是否在读
	private String preTrainDate; 	//想参加培训月份
	private String payType; 		//学期内付清，先就业后付款
	private String howKnow;   		//视频，朋友推荐，学员推荐，网上文章，北风网，其他。。。
	private String classType;  		//业余班，脱产班，基地班，周末班，网络班，远程同步班,就业班，软件开发基础班
	private String description;		//其他信息描述
	private int    userId; 			//登记这个学生的用户
	private String type="意向学员"; 	//意向学员，不来了，预备学员，正式学员，退学。 就业
	private String nonArrivalReason;//不来的原因
	private int    gradeId; 		//班级id
	private double fee;  			//应缴总学费
	private String feeUpdateReason; //修改总学费的原因
	private double feeQuit;  		//应退学费
	private double feeRealQuit;  	//实退学费
	private String leaveReason;  	//退学理由
	private String liveFlag;   		//是，否,退。    是否需要安排住宿
	private double handLiveFee;  	//应收住宿费
	private double realLiveFee;   	//实收住宿费
	private double quitLiveFee; 	//应退住宿费
	private double realQuitLiveFee; //实退住宿费
	private String quitLiveReason;  //退住宿的理由

	private String computerFlag;   		//是，否，退。    是否需要安排电脑
	private double computerPay ;		//应收电脑押金
	private double realComputerPay ;	//实收电脑押金
	private double quitComputerPay ;	//应退电脑押金
	private double realQuitComputerPay ;//实退电脑押金
	
	
	//协议和证件标记
	private int stuCardFlag; 			//学员身份证复印件有。   1：有      0：无
	private int bondsmanCardFlag;  		//担保人身份证复印件。  1：有    0：无
	private int bondsmanHouseholdFlag;  //担保人户口本复印件。 1：有   0：无
	private int bondsmanAccountFlag;   	//担保人近三个月流水。   1：有    0：无
	private int photoFlag;     			//学员本人照片。                1：有     0：无
	private int trainFlag;    			//培训协议。                        1：有      0：无
	private int guaranteeFlag;    		//担保人担保协议      1：有     0：无
	private int practiceFlag;      		//实习协议			1：有     0：无
	private int preWorkFlag;         	//先就业后付款协议	1：有     0：无
	private int repaymentFlag;    		//还款协议			1：有     0：无
	private int laptopFlag;      		//笔记本使用协议	1：有     0：无
	
	public Student() {
		super();
	}
	public Student(int id, String sname, String qq, String phone,
			String university, String department, String grade, String diploma,
			String state, String preTrainDate, String payType, String howKnow,
			String classType, String description, int userId, String type,
			String nonArrivalReason, int gradeId, double fee,
			String feeUpdateReason, double feeQuit, double feeRealQuit,
			String leaveReason, String liveFlag, double handLiveFee,
			double realLiveFee, double quitLiveFee, double realQuitLiveFee,
			String quitLiveReason, String computerFlag, double computerPay,
			double realComputerPay, double quitComputerPay,
			double realQuitComputerPay, int stuCardFlag, int bondsmanCardFlag,
			int bondsmanHouseholdFlag, int bondsmanAccountFlag, int photoFlag,
			int trainFlag, int guaranteeFlag, int practiceFlag,
			int preWorkFlag, int repaymentFlag, int laptopFlag) {
		super();
		this.id = id;
		this.sname = sname;
		this.qq = qq;
		this.phone = phone;
		this.university = university;
		this.department = department;
		this.grade = grade;
		this.diploma = diploma;
		this.state = state;
		this.preTrainDate = preTrainDate;
		this.payType = payType;
		this.howKnow = howKnow;
		this.classType = classType;
		this.description = description;
		this.userId = userId;
		this.type = type;
		this.nonArrivalReason = nonArrivalReason;
		this.gradeId = gradeId;
		this.fee = fee;
		this.feeUpdateReason = feeUpdateReason;
		this.feeQuit = feeQuit;
		this.feeRealQuit = feeRealQuit;
		this.leaveReason = leaveReason;
		this.liveFlag = liveFlag;
		this.handLiveFee = handLiveFee;
		this.realLiveFee = realLiveFee;
		this.quitLiveFee = quitLiveFee;
		this.realQuitLiveFee = realQuitLiveFee;
		this.quitLiveReason = quitLiveReason;
		this.computerFlag = computerFlag;
		this.computerPay = computerPay;
		this.realComputerPay = realComputerPay;
		this.quitComputerPay = quitComputerPay;
		this.realQuitComputerPay = realQuitComputerPay;
		this.stuCardFlag = stuCardFlag;
		this.bondsmanCardFlag = bondsmanCardFlag;
		this.bondsmanHouseholdFlag = bondsmanHouseholdFlag;
		this.bondsmanAccountFlag = bondsmanAccountFlag;
		this.photoFlag = photoFlag;
		this.trainFlag = trainFlag;
		this.guaranteeFlag = guaranteeFlag;
		this.practiceFlag = practiceFlag;
		this.preWorkFlag = preWorkFlag;
		this.repaymentFlag = repaymentFlag;
		this.laptopFlag = laptopFlag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDiploma() {
		return diploma;
	}
	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPreTrainDate() {
		return preTrainDate;
	}
	public void setPreTrainDate(String preTrainDate) {
		this.preTrainDate = preTrainDate;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getHowKnow() {
		return howKnow;
	}
	public void setHowKnow(String howKnow) {
		this.howKnow = howKnow;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNonArrivalReason() {
		return nonArrivalReason;
	}
	public void setNonArrivalReason(String nonArrivalReason) {
		this.nonArrivalReason = nonArrivalReason;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getFeeUpdateReason() {
		return feeUpdateReason;
	}
	public void setFeeUpdateReason(String feeUpdateReason) {
		this.feeUpdateReason = feeUpdateReason;
	}
	public double getFeeQuit() {
		return feeQuit;
	}
	public void setFeeQuit(double feeQuit) {
		this.feeQuit = feeQuit;
	}
	public double getFeeRealQuit() {
		return feeRealQuit;
	}
	public void setFeeRealQuit(double feeRealQuit) {
		this.feeRealQuit = feeRealQuit;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public String getLiveFlag() {
		return liveFlag;
	}
	public void setLiveFlag(String liveFlag) {
		this.liveFlag = liveFlag;
	}
	public double getHandLiveFee() {
		return handLiveFee;
	}
	public void setHandLiveFee(double handLiveFee) {
		this.handLiveFee = handLiveFee;
	}
	public double getRealLiveFee() {
		return realLiveFee;
	}
	public void setRealLiveFee(double realLiveFee) {
		this.realLiveFee = realLiveFee;
	}
	public double getQuitLiveFee() {
		return quitLiveFee;
	}
	public void setQuitLiveFee(double quitLiveFee) {
		this.quitLiveFee = quitLiveFee;
	}
	public double getRealQuitLiveFee() {
		return realQuitLiveFee;
	}
	public void setRealQuitLiveFee(double realQuitLiveFee) {
		this.realQuitLiveFee = realQuitLiveFee;
	}
	public String getQuitLiveReason() {
		return quitLiveReason;
	}
	public void setQuitLiveReason(String quitLiveReason) {
		this.quitLiveReason = quitLiveReason;
	}
	public String getComputerFlag() {
		return computerFlag;
	}
	public void setComputerFlag(String computerFlag) {
		this.computerFlag = computerFlag;
	}
	public double getComputerPay() {
		return computerPay;
	}
	public void setComputerPay(double computerPay) {
		this.computerPay = computerPay;
	}
	public double getRealComputerPay() {
		return realComputerPay;
	}
	public void setRealComputerPay(double realComputerPay) {
		this.realComputerPay = realComputerPay;
	}
	public double getQuitComputerPay() {
		return quitComputerPay;
	}
	public void setQuitComputerPay(double quitComputerPay) {
		this.quitComputerPay = quitComputerPay;
	}
	public double getRealQuitComputerPay() {
		return realQuitComputerPay;
	}
	public void setRealQuitComputerPay(double realQuitComputerPay) {
		this.realQuitComputerPay = realQuitComputerPay;
	}
	public int getStuCardFlag() {
		return stuCardFlag;
	}
	public void setStuCardFlag(int stuCardFlag) {
		this.stuCardFlag = stuCardFlag;
	}
	public int getBondsmanCardFlag() {
		return bondsmanCardFlag;
	}
	public void setBondsmanCardFlag(int bondsmanCardFlag) {
		this.bondsmanCardFlag = bondsmanCardFlag;
	}
	public int getBondsmanHouseholdFlag() {
		return bondsmanHouseholdFlag;
	}
	public void setBondsmanHouseholdFlag(int bondsmanHouseholdFlag) {
		this.bondsmanHouseholdFlag = bondsmanHouseholdFlag;
	}
	public int getBondsmanAccountFlag() {
		return bondsmanAccountFlag;
	}
	public void setBondsmanAccountFlag(int bondsmanAccountFlag) {
		this.bondsmanAccountFlag = bondsmanAccountFlag;
	}
	public int getPhotoFlag() {
		return photoFlag;
	}
	public void setPhotoFlag(int photoFlag) {
		this.photoFlag = photoFlag;
	}
	public int getTrainFlag() {
		return trainFlag;
	}
	public void setTrainFlag(int trainFlag) {
		this.trainFlag = trainFlag;
	}
	public int getGuaranteeFlag() {
		return guaranteeFlag;
	}
	public void setGuaranteeFlag(int guaranteeFlag) {
		this.guaranteeFlag = guaranteeFlag;
	}
	public int getPracticeFlag() {
		return practiceFlag;
	}
	public void setPracticeFlag(int practiceFlag) {
		this.practiceFlag = practiceFlag;
	}
	public int getPreWorkFlag() {
		return preWorkFlag;
	}
	public void setPreWorkFlag(int preWorkFlag) {
		this.preWorkFlag = preWorkFlag;
	}
	public int getRepaymentFlag() {
		return repaymentFlag;
	}
	public void setRepaymentFlag(int repaymentFlag) {
		this.repaymentFlag = repaymentFlag;
	}
	public int getLaptopFlag() {
		return laptopFlag;
	}
	public void setLaptopFlag(int laptopFlag) {
		this.laptopFlag = laptopFlag;
	}
}
