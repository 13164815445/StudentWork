package unp.student.work.manager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.domain.PersonFinance;
import unp.student.work.manager.domain.PersonPersonInfo;
import unp.student.work.manager.service.PersonFinanceService;


@Component
public class PersonFinanceAction extends ActionSupport {
	private String id;
	private String name;
	private String type;  //����˵������String��Ӧ���ݿ��text
	private String createtime;
	private String money;
	private String remark;
	
	
	private PersonPersonInfo personPersonInfo = new PersonPersonInfo();
	private PersonFinance personFinance = new PersonFinance();
	
	@Resource
	private PersonFinanceService personFinanceService;

	public String add() throws Exception
	{
		Date d = new Date();
		
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map)ActionContext.getContext().getSession();    //�õ�session��Map��ʽ
		String studentid = (String)session.get("studentid");  //ȡ��session������Ϊstudentid��ֵ
		
		personFinance.setName(name);
		personFinance.setType(type);
		personFinance.setMoney(money);
		personFinance.setCreatetime(d);
		personFinance.setRemark(remark);
		personPersonInfo.setStudentid(studentid);  //�����ǻ�ȡ��ǰsession�е��û����Ĵ���
		personFinance.setPersonPersonInfo(personPersonInfo);
		
		
		personFinanceService.save(personFinance);
		
		return SUCCESS;
	}


	
	
	public String delete() throws Exception
	{
		personFinanceService.delete(id);
		
		return SUCCESS;
	}
	
	
	public String modify() throws Exception
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date d = formatter.parse(createtime);
		
		personFinance.setId(Integer.parseInt(id));
		personFinance.setName(name);
		personFinance.setType(type);
		personFinance.setMoney(money);
		personFinance.setCreatetime(d);
		personFinance.setRemark(remark);
		
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map)ActionContext.getContext().getSession();    //�õ�session��Map��ʽ
		String studentid = (String)session.get("studentid");  //ȡ��session������Ϊstudentid��ֵ
		personPersonInfo.setStudentid(studentid);  //�����ǻ�ȡ��ǰsession�е��û����Ĵ���
		personFinance.setPersonPersonInfo(personPersonInfo);
		
		personFinanceService.modify(personFinance);
		
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




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getMoney() {
		return money;
	}




	public void setMoney(String money) {
		this.money = money;
	}




	public String getRemark() {
		return remark;
	}




	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	
	
	
	
}
