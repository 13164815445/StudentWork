package unp.student.work.manager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.domain.PersonPlan;
import unp.student.work.manager.domain.PersonPersonInfo;
import unp.student.work.manager.service.PersonPlanService;


@Component
public class PersonPlanAction extends ActionSupport {
	private String id;
	private String name;
	private String start;  //����˵������String��Ӧ���ݿ��text
	private String end;
	private String createtime;
	private String result;
	private String remark;
	
	
	private PersonPersonInfo personPersonInfo = new PersonPersonInfo();
	private PersonPlan personPlan = new PersonPlan();
	
	@Resource
	private PersonPlanService personPlanService;

	public String add() throws Exception
	{
		Date c = new Date();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		Date s = formatter.parse(start);
		Date e = formatter.parse(end);
		
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map)ActionContext.getContext().getSession();    //�õ�session��Map��ʽ
		String studentid = (String)session.get("studentid");  //ȡ��session������Ϊstudentid��ֵ
		
		personPlan.setName(name);
		personPlan.setStart(s);
		personPlan.setEnd(e);
		personPlan.setCreatetime(c);
		personPlan.setResult("unfinished");  //��Ϊ�մ���һ���ƻ�ʱ���ƻ��϶���δ���
		personPlan.setRemark(remark);
		personPersonInfo.setStudentid(studentid);  //�����ǻ�ȡ��ǰsession�е��û����Ĵ���
		personPlan.setPersonPersonInfo(personPersonInfo);
		
		
		personPlanService.save(personPlan);
		
		return SUCCESS;
	}


	
	
	public String delete() throws Exception
	{
		personPlanService.delete(id);
		
		return SUCCESS;
	}
	
	
	public String modify() throws Exception
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		Date c = formatter.parse(createtime);
		Date s = formatter.parse(start);
		Date e = formatter.parse(end);
		
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map)ActionContext.getContext().getSession();    //�õ�session��Map��ʽ
		String studentid = (String)session.get("studentid");  //ȡ��session������Ϊstudentid��ֵ
		
		personPlan.setId(Integer.parseInt(id));
		personPlan.setName(name);
		personPlan.setStart(s);
		personPlan.setEnd(e);
		personPlan.setCreatetime(c);
		personPlan.setResult(result);
		personPlan.setRemark(remark);
		personPersonInfo.setStudentid(studentid);  //�����ǻ�ȡ��ǰsession�е��û����Ĵ���
		personPlan.setPersonPersonInfo(personPersonInfo);
		personPlanService.modify(personPlan);
		
		return SUCCESS;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getStart() {
		return start;
	}




	public void setStart(String start) {
		this.start = start;
	}




	public String getEnd() {
		return end;
	}




	public void setEnd(String end) {
		this.end = end;
	}




	public String getCreatetime() {
		return createtime;
	}




	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}




	public String getResult() {
		return result;
	}




	public void setResult(String result) {
		this.result = result;
	}




	public String getRemark() {
		return remark;
	}




	public void setRemark(String remark) {
		this.remark = remark;
	}
	

	
	
	
	
	
}
