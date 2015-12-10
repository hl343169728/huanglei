package com.sxt.manager.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.sxt.manager.model.Grade;
import com.sxt.manager.model.Student;
import com.sxt.manager.service.StudentService;
import com.sxt.manager.service.impl.StudentServiceImpl;

public class StudentAction extends BaseAction{
	
	//属性驱动
	private Student student;
	private Grade grade;
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	private StudentService studentService = new StudentServiceImpl();
	
	/**
	 * 新增意向学员信息方法
	 * @return
	 * @throws Exception
	 */
	public String saveStudent() throws Exception{
		this.studentService.save(this.student);
		this.request.setAttribute("url","/jsp/student/student_add.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 验证QQ是否存在的方法
	 * @return
	 * @throws Exception
	 */
	public String checkStudentQQ() throws Exception{
		String qq = this.request.getParameter("qq");
		boolean flag = this.studentService.checkStudentQQ(qq);
		if(flag){
			this.myWriter("1");
		}else{
			this.myWriter("2");
		}
		return NONE;
	}
	
	/**
	 * 获取意向学员、不来了、正式学员的列表信息
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String getStudentList() throws Exception{
		String currentPage = this.request.getParameter("page");
		String pageSize    = this.request.getParameter("rows");
		String flag = this.request.getParameter("flag");
		List<Map> list = this.studentService.getStudentList(currentPage,pageSize,flag);
		int total = this.studentService.getStudentTotal(flag);
		//传输数据
		response.setContentType("text/html;charset=UTF-8");
		//写出指定的JSON格式的数据
		String json ="{\"total\":"+total+",\"rows\":"+JSONArray.fromObject(list).toString()+"}";
		response.getWriter().write(json);
		return NONE;
	}
	
	/**
	 * 获取预备学员的列表信息
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String getPreStudentList() throws Exception{
		String currentPage = this.request.getParameter("page");
		String pageSize    = this.request.getParameter("rows");
		List<Map> list = this.studentService.getPreStudentList(currentPage,pageSize);
		int total = this.studentService.getPreStudentTotal();
		//传输数据
		response.setContentType("text/html;charset=UTF-8");
		//写出指定的JSON格式的数据
		String json ="{\"total\":"+total+",\"rows\":"+JSONArray.fromObject(list).toString()+"}";
		response.getWriter().write(json);
		return NONE;
	}
	
	/**
	 * 获取正式学员的列表信息
	 * @return
	 * @throws Exception
	 */
	public String getRealStudentList() throws Exception{
		String currentPage = this.request.getParameter("page");
		String pageSize    = this.request.getParameter("rows");
		String flag = this.request.getParameter("flag");
		List<Map> list    = this.studentService.getStudentList(currentPage, pageSize, flag);
		int total = this.studentService.getRealStudentTotal(flag);
		//传输数据
		response.setContentType("text/html;charset=UTF-8");
		//写出指定的JSON格式的数据
		String json ="{\"total\":"+total+",\"rows\":"+JSONArray.fromObject(list).toString()+"}";
		response.getWriter().write(json);
		return NONE;
	}
	
	/**
	 * 修改学员为不来学员预修改方法
	 * @return
	 * @throws Exception
	 */
	public String preLeave() throws Exception{
		this.student = this.studentService.findById(this.id);
		return "LEAVE";
	}
	
	/**
	 * 修改意向学员为不来学员
	 * @return
	 * @throws Exception
	 */
	public String leave() throws Exception{
		Student stu  = this.studentService.getStudentById(this.id);
		stu.setNonArrivalReason(this.student.getNonArrivalReason());
		stu.setType("不来了");
		this.studentService.update(stu);
		this.request.setAttribute("url","/jsp/student/student_list.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 转为意向学员
	 * @return
	 * @throws Exception
	 */
	public String changeStudentType() throws Exception{
		Student stu = this.studentService.findById(this.id);
		stu.setType("意向学员");
		stu.setNonArrivalReason(null);
		this.studentService.update(stu);
		this.request.setAttribute("url","/jsp/student/student_leaveList.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 转为预备学员的预备方法
	 * @return
	 * @throws Exception
	 */
	public String changeToPreStudent() throws Exception{
		this.student = this.studentService.findById(this.id);
		String studentName = this.studentService.getStudentName(this.student.getId());
		this.request.setAttribute("studentName",studentName);
		return "PRESTUDENT";
	}
	
	/**
	 * 真正的保存预备学员信息的方法
	 * @return
	 * @throws Exception
	 */
	public String preStudent() throws Exception{
		String gradeId = this.request.getParameter("gradeId");
		System.out.println(Integer.parseInt(gradeId));
		Student stu = this.studentService.findById(this.id);
		stu.setGradeId(Integer.parseInt(gradeId));
		stu.setPayType(this.student.getPayType());
		stu.setLiveFlag(this.student.getLiveFlag());
		stu.setComputerFlag(this.student.getComputerFlag());
		stu.setDescription(this.student.getDescription());
		stu.setType("预备学员");
		this.studentService.update(stu);
		this.request.setAttribute("url","/jsp/student/student_preStudentList.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 预修改的方法
	 * @return
	 * @throws Exception
	 */
	public String preUpdate() throws Exception{
		this.student = this.studentService.findById(this.id);
		return "UPDATE";
	}
	
	/**
	 * 真正的修改方法
	 * @return
	 * @throws Exception
	 */
	public String updateStudent() throws Exception{
		Student stu = this.studentService.findById(this.id);
		stu.setSname(this.student.getSname());
		stu.setQq(this.student.getQq());
		stu.setPhone(this.student.getPhone());
		stu.setUniversity(this.student.getUniversity());
		stu.setDepartment(this.student.getDepartment());
		stu.setGrade(this.student.getGrade());
		stu.setDiploma(this.student.getDiploma());
		stu.setState(this.student.getState());
		stu.setPreTrainDate(this.student.getPreTrainDate());
		stu.setPayType(this.student.getPayType());
		stu.setHowKnow(this.student.getHowKnow());
		stu.setClassType(this.student.getClassType());
		stu.setDescription(this.student.getDescription());
		this.studentService.update(stu);
		this.request.setAttribute("url","/jsp/student/student_list.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 转为正式学员的预备方法
	 * @return
	 * @throws Exception
	 */
	public String changeToRealStudent() throws Exception{
		this.student = this.studentService.findById(this.id);
		String studentName = this.studentService.getStudentName(this.student.getId());
		this.request.setAttribute("studentName",studentName);
		return "REALSTUDENT";
	}
	
	/**
	 * 真正的转为正式学员的方法
	 * @return
	 * @throws Exception
	 */
	public String realStudent() throws Exception{
		Student stu = this.studentService.findById(this.id);
		stu.setPayType(this.student.getPayType());
		stu.setLiveFlag(this.student.getLiveFlag());
		stu.setComputerFlag(this.student.getComputerFlag());
		stu.setFee(this.student.getFee());
		stu.setFeeUpdateReason(this.student.getFeeUpdateReason());
		stu.setDescription(this.student.getDescription());
		stu.setType("正式学员");
		this.studentService.update(stu);
		this.request.setAttribute("url","/jsp/student/student_realStudentList.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 预退学方法
	 * @return
	 * @throws Exception
	 */
	public String preDropOut() throws Exception{
		this.student = this.studentService.findById(this.id);
		double prePayFee = this.studentService.getPrePayFeeValue();
		this.request.setAttribute("prePayFee",prePayFee);
		return "DROPOUT";
	}
	
	/**
	 * 真正的退学方法
	 * @return
	 * @throws Exception
	 */
	public String dropOut() throws Exception{
		Student stu = this.studentService.findById(this.id);
		stu.setFeeQuit(this.student.getFeeQuit());
		stu.setLeaveReason(this.student.getLeaveReason());
		stu.setType("退学");
		this.studentService.update(stu);
		this.request.setAttribute("url","/jsp/student/student_realStudentList.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 通过gradeId获取Student对象
	 * @return
	 * @throws Exception
	 */
	public String getStudentByGradeId() throws Exception{
		String gradeId = this.request.getParameter("gradeId");
		List<Student> sList =  this.studentService.getStudentNamesByGradeId(Integer.parseInt(gradeId));
		this.myWriter(JSONArray.fromObject(sList).toString());
		return NONE;
	}
}
